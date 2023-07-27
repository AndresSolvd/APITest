package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.OverviewScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ThankYouScreenBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewScreen extends OverviewScreenBase {

    @FindBy(xpath = "")
    private ExtendedWebElement finishButton;

    protected OverviewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ThankYouScreenBase clickFinish() {
        finishButton.click();
        return initPage(ThankYouScreenBase.class);
    }
}
