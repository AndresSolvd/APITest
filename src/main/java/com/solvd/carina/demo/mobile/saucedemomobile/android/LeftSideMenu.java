package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.LeftSideMenuScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.LoginScreenBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LeftSideMenu extends LeftSideMenuScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Close\"]/android.widget.ImageView")
    private ExtendedWebElement closeMenuButton;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Checkout: Your Info\"]" +
            "/android.view.ViewGroup/android.view.ViewGroup[5]")
    private ExtendedWebElement logOutButton;

    public LeftSideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return closeMenuButton.isElementPresent();
    }

    @Override
    public LoginScreenBase clickLogOutButton() {
        logOutButton.click();
        return initPage(LoginScreenBase.class);
    }
}
