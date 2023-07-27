package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ThankYouScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ThankYouScreenBase.class)
public class ThankYouScreen extends ThankYouScreenBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
    private ExtendedWebElement backHomeButton;

    protected ThankYouScreen(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return backHomeButton.isElementPresent();
    }

    @Override
    public ProductsScreenBase clickBackHomeButton() {
        backHomeButton.click();
        return initPage(ProductsScreenBase.class);
    }
}