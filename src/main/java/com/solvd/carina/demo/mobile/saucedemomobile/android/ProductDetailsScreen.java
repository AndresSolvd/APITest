package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CartScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductDetailsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsScreenBase.class)
public class ProductDetailsScreen extends ProductDetailsScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "00000000-0000-0074-ffff-ffff000001a9")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]")
    private ExtendedWebElement cartButton;

    public ProductDetailsScreen(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productTitle.isElementPresent();
    }

    @Override
    public void clickAddToCardButton() {
        addToCartButton.click();
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(CartScreenBase.class);
    }
}