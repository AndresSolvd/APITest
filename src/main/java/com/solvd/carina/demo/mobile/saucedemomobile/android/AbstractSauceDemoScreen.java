package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.AbstractSauceDemoScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class AbstractSauceDemoScreen extends AbstractSauceDemoScreenBase {

    protected AbstractSauceDemoScreen(WebDriver driver) {
        super(driver);
    }
}