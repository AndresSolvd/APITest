package com.solvd.carina.demo.mobile.saucedemomobile.common;

import org.openqa.selenium.WebDriver;

public abstract class LeftSideMenuScreenBase extends AbstractSauceDemoScreenBase {

    public LeftSideMenuScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginScreenBase clickLogOutButton();
}