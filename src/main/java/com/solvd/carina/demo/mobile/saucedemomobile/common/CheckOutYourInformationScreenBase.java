package com.solvd.carina.demo.mobile.saucedemomobile.common;

import org.openqa.selenium.WebDriver;

public abstract class CheckOutYourInformationScreenBase extends AbstractSauceDemoScreenBase {

    public CheckOutYourInformationScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String firstName);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipcode(String zip);

    public abstract OverviewScreenBase clickContinue();
}