package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CartScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductDetailsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsScreenBase.class)
public class ProductDetailsScreen extends ProductDetailsScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(accessibilityId = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToProductButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]")
    private ExtendedWebElement cartButton;

    public ProductDetailsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return backToProductButton.isElementPresent();
    }

    @Override
    public void clickAddToCardButton() {
        swipe(addToCartButton);
        addToCartButton.click();
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(CartScreenBase.class);
    }
}