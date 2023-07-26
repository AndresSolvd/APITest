package com.solvd.carina.demo.mobile.saucedemomobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutYourInformationScreen extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
    private ExtendedWebElement pageTitle;

    protected CheckOutYourInformationScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }
}
