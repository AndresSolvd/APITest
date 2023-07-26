package com.solvd.carina.demo.mobile.saucedemomobile.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSauceDemoScreenBase extends AbstractPage implements IMobileUtils {

    protected AbstractSauceDemoScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw new UnsupportedOperationException("Not implemented isOpened() for this page");
    }
}