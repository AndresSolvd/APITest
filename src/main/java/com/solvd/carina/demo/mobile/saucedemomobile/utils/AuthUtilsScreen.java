package com.solvd.carina.demo.mobile.saucedemomobile.utils;

import com.solvd.carina.demo.mobile.saucedemomobile.common.LoginScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthUtilsScreen implements ICustomTypePageFactory{
    public ProductsScreenBase login(String username, String password) {
        LoginScreenBase loginScreenBase = initPage(LoginScreenBase.class);
        loginScreenBase.open();
        loginScreenBase.typeUsername(username);
        loginScreenBase.typePassword(password);
        return loginScreenBase.clickLoginButton();
    }

    public ProductsScreenBase loginStandardUser() {
        return login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_password"));
    }
}