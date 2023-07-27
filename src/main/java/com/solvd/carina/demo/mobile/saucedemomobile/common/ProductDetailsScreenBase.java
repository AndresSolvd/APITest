package com.solvd.carina.demo.mobile.saucedemomobile.common;

import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsScreenBase extends AbstractSauceDemoScreenBase {
    public ProductDetailsScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddToCardButton();

    public abstract CartScreenBase clickCartButton();
}