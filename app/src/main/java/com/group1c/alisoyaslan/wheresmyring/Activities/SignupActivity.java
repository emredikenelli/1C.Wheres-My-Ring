package com.group1c.alisoyaslan.wheresmyring.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.group1c.alisoyaslan.wheresmyring.Models.ResponsePHP;
import com.group1c.alisoyaslan.wheresmyring.R;
import com.group1c.alisoyaslan.wheresmyring.Utils.GeneralClass;
import com.group1c.alisoyaslan.wheresmyring.Utils.UtilsGson;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AliSoyaslan on 3.11.2017.
 */

public class SignupActivity extends AppCompatActivity{
        @InjectView(R.id.kullanicigiris2)
        EditText kullanicigiris2;
        @InjectView(R.id.sifregiris2)
        EditText sifregiris2;
        @InjectView(R.id.yasgiris)
        EditText yasgiris;
        @InjectView(R.id.epostagiris)
        EditText epostagiris;
        @InjectView(R.id.iptal)
        Button iptal;
        @InjectView(R.id.sozlesme)
        CheckBox sozlesmegiris;


        JSONObject jsonObject = new JSONObject();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            initUi();

//            spinner = (Spinner) findViewById(R.id.spinnercinsiyet);
  //          ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.dizi,android.R.layout.simple_spinner_item);
    //        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //      spinner.setAdapter(adapter);
        }

        private void initUi() {
            ButterKnife.inject(this);
        }


        //Database check for integrity and approval (Sign Up Button)
        @OnClick(R.id.kayitol)
        public void onGiris(View v) {

//Control the inputs according to format
//        while(!(cinsiyetTamam && yasTamam && emailTamam && sifreTamam && sozlesmeTamam)){

            //Gather input data into string
            final String kayitKullanici = kullanicigiris2.getText().toString();
            final String kayitSifre = sifregiris2.getText().toString();
            final String kayitYas = yasgiris.getText().toString();
            final String kayitEposta = epostagiris.getText().toString();


            //Şifre doğrulaması
            boolean numFlag = false, capitalFlag = false;
            for (int j = 0; j < kayitSifre.length(); j++) {
                if(kayitSifre.charAt(j) > 47 && kayitSifre.charAt(j) < 58)
                    numFlag = true;
                if(kayitSifre.charAt(j) > 64 && kayitSifre.charAt(j) < 91)
                    capitalFlag = true;
            }
            if(kayitSifre.length() < 8 || !(capitalFlag && numFlag))

            {sifregiris2.setError("Password must comprise of at least 8 characters with at least 1 being a capital character and an integer");
                return;
            }
            //Şifre END


            //Yaş Doğrulaması
            int yasCevir;

            try{
                yasCevir = Integer.parseInt(kayitYas);
            } catch (NumberFormatException e){
                yasgiris.setError("Please enter a positive integer ");
                return;
            }
            if(yasCevir < 0)
            {yasgiris.setError("Please enter a positive integer");
                return;
            }


            //Yas END





            //Email Doğrulaması
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(kayitEposta).matches()) {
                epostagiris.setError("Not an email adress");
                return;
            }
/*
                for (int i = 0; i < kayitEposta.length(); i++) {
                    if (kayitEposta.charAt(i) == '@')
                        if (!kayitEposta.substring(i).contains("bilkent.edu.tr"))
                            epostagiris.setError("Not an email adress attributed to bilkent");
                            return;

                }
                */
            if(!kayitEposta.contains("bilkent.edu.tr")) {
                epostagiris.setError("Not an email adress attributed to bilkent");
                return;
            }

            //Email END

            //Sözleşme Doğrulaması
            if(!sozlesmegiris.isChecked()) {
                sozlesmegiris.setError("Please accept the agreement");
                return;
            }
            //Sözleşme END

            //Fill JSON Object

            try {
                jsonObject.put("kullaniciadi", kayitKullanici);
                jsonObject.put("sifre", kayitSifre);
                jsonObject.put("yas", kayitYas);
                jsonObject.put("email", kayitEposta);
            } catch (JSONException e) {
                e.printStackTrace();
            }

//        }

//Send Everything to database via PHP(slim)
            GeneralClass.getInstance().restInterface.setUser(UtilsGson.converteRetrofit(jsonObject)).enqueue(new Callback<ResponsePHP>() {

                @Override
                public void onResponse(Call<ResponsePHP> call, Response<ResponsePHP> response) {
                    if(response.body().isStatus()){
                        //Kayıt Başarılı UYGULAMAYA DEVAM ET
                        finish();
                    }
                    else{kullanicigiris2.setError("Uğur hocamızı seviyoruz...");
                        return;
                    }

                }
                @Override
                public void onFailure(Call<ResponsePHP> call, Throwable t) {

                }
            });
        } //END GİRİŞ


        //Back to Login Screen
        @OnClick(R.id.iptal)
        public void onExit(View v) {
            finish();
        }


    }



