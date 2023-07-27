package com.solvd.carina.demo.mobile.saucedemomobile.common;

import org.openqa.selenium.WebDriver;

public abstract  class ThankYouScreenBase extends AbstractSauceDemoScreenBase {
    public ThankYouScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductsScreenBase clickBackHomeButton();
}
