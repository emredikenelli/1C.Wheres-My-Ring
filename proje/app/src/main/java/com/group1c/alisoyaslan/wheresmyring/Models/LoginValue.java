package com.group1c.alisoyaslan.wheresmyring.Models;

import com.google.gson.annotations.Expose;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public class LoginValue {

    @Expose
    private int loginValue;

    public int getLoginValue() {
        return loginValue;
    }

    public void setLoginValue(int loginValue) {
        this.loginValue = loginValue;
    }
}
