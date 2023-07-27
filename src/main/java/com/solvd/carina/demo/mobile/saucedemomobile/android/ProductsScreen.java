package com.solvd.carina.demo.mobile.saucedemomobile.android;

import com.solvd.carina.demo.mobile.saucedemomobile.common.CartScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.LeftSideMenuScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductDetailsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.components.CatalogProductItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsScreenBase.class)
public class ProductsScreen extends ProductsScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement screenTitle;

    @FindBy(css = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[@text='%s']")
    private ExtendedWebElement productTitleS;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement leftSideMenu;

    public ProductsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return screenTitle.isElementPresent();
    }

    @Override
    public LeftSideMenuScreenBase getLeftSideMenu() {
        leftSideMenu.click();
        return initPage(LeftSideMenuScreenBase.class);
    }

    @Override
    public ProductDetailsScreenBase clickProductTitle(String productTitle) {
        productTitleS.format(productTitle).click();
        return initPage(ProductDetailsScreenBase.class);
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(CartScreenBase.class);
    }
}