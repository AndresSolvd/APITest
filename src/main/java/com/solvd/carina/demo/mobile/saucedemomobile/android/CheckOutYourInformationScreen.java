package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CheckOutYourInformationScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.OverviewScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutYourInformationScreenBase.class)
public class CheckOutYourInformationScreen extends CheckOutYourInformationScreenBase {

    @FindBy(xpath = "")
    private ExtendedWebElement firstName;

    @FindBy(xpath = "")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "")
    private ExtendedWebElement zipCode;

    @FindBy(xpath = "")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[2]/android.widget.TextView")
    private ExtendedWebElement screenTitle;

    public CheckOutYourInformationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return screenTitle.isElementPresent();
    }

    @Override
    public void typeFirstName(String firstName) {
        this.firstName.type(firstName);

    }

    @Override
    public void typeLastName(String lastName) {
        this.lastName.type(lastName);

    }

    @Override
    public void typeZipcode(String zip) {
        this.zipCode.type(zip);
    }

    @Override
    public OverviewScreenBase clickContinue() {
        continueButton.click();
        return initPage(OverviewScreenBase.class);
    }
}