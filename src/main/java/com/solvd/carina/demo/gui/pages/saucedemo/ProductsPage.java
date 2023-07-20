package com.solvd.carina.demo.gui.pages.saucedemo;

import com.solvd.carina.demo.gui.pages.saucedemo.components.CatalogProductItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ProductsPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Products'][@class='title']")
    private ExtendedWebElement pageTitleLabel;

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<CatalogProductItem> products;

    protected ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitleLabel);
//        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public List<CatalogProductItem> getProductItems() {
        return products;
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }
}