package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CheckOutYourInformationScreenBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutYourInformationScreen extends CheckOutYourInformationScreenBase {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[2]/android.widget.TextView")
    private ExtendedWebElement screenTitle;

    protected CheckOutYourInformationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return screenTitle.isElementPresent();
    }
}