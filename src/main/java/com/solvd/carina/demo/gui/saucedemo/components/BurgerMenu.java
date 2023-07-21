package com.solvd.carina.demo.gui.saucedemo.components;

import com.solvd.carina.demo.gui.saucedemo.AboutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    @FindBy(xpath ="//a[@id='about_sidebar_link' and @href='https://saucelabs.com/' ]")
    private ExtendedWebElement aboutButtonInHamburgerMenu;

    public BurgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AboutPage clickAboutButtonInHamburgerMenu() {
        aboutButtonInHamburgerMenu.click();
        return new AboutPage(driver);
    }
}
