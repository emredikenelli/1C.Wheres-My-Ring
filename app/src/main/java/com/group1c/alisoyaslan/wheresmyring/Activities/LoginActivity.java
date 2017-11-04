package com.group1c.alisoyaslan.wheresmyring.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.group1c.alisoyaslan.wheresmyring.Models.LoginValue;
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

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.usernameLogin) EditText usernameLogin;
    @InjectView(R.id.passwordLogin) EditText passwordLogin;
    @InjectView(R.id.passImage) ImageView passwordImage;
    @InjectView(R.id.userImage) ImageView usernameImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        initUi();
    }

    private void initUi() {
        ButterKnife.inject(this);
    }

    /**
     * On click of the login button, the JSON object will get the username and
     * password as it is declared in PHP file and send it to the PHP file
     **/
    @OnClick(R.id.loginButton)
    public void onLogin(View v){
        final String username = usernameLogin.getText().toString();
        final String password = passwordLogin.getText().toString();
        //put the entries in json object
        final JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        GeneralClass.getInstance().restInterface.getUser(UtilsGson.converteRetrofit(jsonObject)).enqueue(new Callback<LoginValue>() {
            @Override
            public void onResponse(Call<LoginValue> call, retrofit2.Response<LoginValue> response) {
                if(response.body() == null)
                    return;
                //True = kullanıcı var
                if(response.body().getLoginValue() == 1){
                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                    startActivity(intent);
                }
                else if(response.body().getLoginValue() == 2){passwordLogin.setError("Wrong Password..."); return;}
                else{
                    Toast.makeText(getApplicationContext(), "No such user found...", Toast.LENGTH_LONG).show(); return;}
            }
            @Override
            public void onFailure(Call<LoginValue> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Network Connectivity Issue...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick(R.id.signUpTextClick)
    public void onSignUp(View v){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }

}
