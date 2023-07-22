package com.solvd.carina.demo.gui.saucedemo.components;

import com.solvd.carina.demo.gui.saucedemo.AboutPage;
import com.solvd.carina.demo.gui.saucedemo.LoginPage;
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
    private ExtendedWebElement aboutButtonInLeftSideMenu;

    @FindBy(xpath = ".//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logOutButtonInLeftSideMenu;

    public LeftSideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPage clickLogOutButtonInLeftSideMenu() {
        logOutButtonInLeftSideMenu.click();
        return new LoginPage(driver);
    }

    public AboutPage clickAboutButtonInLeftSideMenu() {
        aboutButtonInLeftSideMenu.click();
        return new AboutPage(driver);
    }
}
