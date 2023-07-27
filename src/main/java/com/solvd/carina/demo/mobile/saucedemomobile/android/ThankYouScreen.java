package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ThankYouScreenBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ThankYouScreen extends ThankYouScreenBase {

    @FindBy(xpath = "")
    private ExtendedWebElement backHomeButton;

    protected ThankYouScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsScreenBase clickBackHomeButton() {
        backHomeButton.click();
        return initPage(ProductsScreenBase.class);
    }
}
