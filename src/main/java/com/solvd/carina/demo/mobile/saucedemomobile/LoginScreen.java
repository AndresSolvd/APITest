package com.solvd.carina.demo.mobile.saucedemomobile;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginScreen extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private ExtendedWebElement passwordField;

    @FindBy(css = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginButton);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isElementPresent();
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public ProductsScreen clickLoginButton() {
        loginButton.click();
        return initPage(ProductsScreen.class);
    }
}
