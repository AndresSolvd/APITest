package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.OverviewScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ThankYouScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewScreenBase.class)
public class OverviewScreen extends OverviewScreenBase {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private ExtendedWebElement finishButton;

    public OverviewScreen(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return pageTitle.isElementPresent();
    }

    @Override
    public ThankYouScreenBase clickFinish() {
        swipe(finishButton);
        finishButton.click();
        return initPage(ThankYouScreenBase.class);
    }
}