package com.solvd.carina.demo.mobile.saucedemomobile.components;

import com.solvd.carina.demo.mobile.saucedemomobile.AboutScreen;
import com.solvd.carina.demo.mobile.saucedemomobile.LoginScreen;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LeftSideMenu extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//a[@id='about_sidebar_link']")
    private ExtendedWebElement aboutButton;

    @FindBy(xpath = ".//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logOutButton;

    public LeftSideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginScreen clickLogOutButton() {
        logOutButton.click();
        return new LoginScreen(driver);
    }

    public AboutScreen clickAboutButton() {
        aboutButton.click();
        return new AboutScreen(driver);
    }
}
