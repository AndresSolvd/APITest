package com.solvd.carina.demo.mobile.saucedemomobile.common;

import org.openqa.selenium.WebDriver;

public abstract class OverviewScreenBase extends AbstractSauceDemoScreenBase {
    protected OverviewScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract ThankYouScreenBase clickFinish();
}