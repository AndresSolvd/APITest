package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.LeftSideMenuScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LeftSideMenuScreenBase.class)
public class LeftSideMenu extends LeftSideMenuScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Close\"]")
    private ExtendedWebElement closeMenuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
    private ExtendedWebElement logOutButton;

    public LeftSideMenu(WebDriver driver) {
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
