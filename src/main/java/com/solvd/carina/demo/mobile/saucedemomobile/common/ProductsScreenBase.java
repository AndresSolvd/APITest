package com.solvd.carina.demo.mobile.saucedemomobile.common;

import com.solvd.carina.demo.mobile.saucedemomobile.android.ProductDetailsScreen;
import org.openqa.selenium.WebDriver;


public abstract class ProductsScreenBase extends AbstractSauceDemoScreenBase {

    protected ProductsScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract LeftSideMenuScreenBase getLeftSideMenu();

    public abstract ProductDetailsScreenBase clickProductTitle(String productTitle);

    public abstract CartScreenBase clickCartButton();
}