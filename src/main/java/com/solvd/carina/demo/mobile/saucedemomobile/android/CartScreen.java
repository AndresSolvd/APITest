package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CartScreenBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartScreen extends CartScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    private ExtendedWebElement screenTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[@text='%s']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    private ExtendedWebElement checkOutButton;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return screenTitle.isElementPresent();
    }

    @Override
    public boolean isProductDisplayed(String productName) {
        LOGGER.info("Will verify if product with title: " + productName + " is displayed");
        return productTitle.format(productName).isElementPresent();
    }

    @Override
    public CheckOutYourInformationScreen clickCheckOutButton() {
        checkOutButton.click();
        return initPage(CheckOutYourInformationScreen.class);
    }
}