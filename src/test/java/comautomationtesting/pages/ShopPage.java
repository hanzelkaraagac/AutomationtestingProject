package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class ShopPage {

    public ShopPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@tabindex='0'][2]")
    public WebElement leftSliderHandleIcon;
    @FindBy(css = "span.to")
    public WebElement priceRangeTo;
    @FindBy(css = "span.from")
    public WebElement priceRangeFrom;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement filterBtn;
    @FindBy(css = "span.woocommerce-Price-amount.amount")
    public List<WebElement> prices;
    @FindBy(css = "del>span.woocommerce-Price-amount.amount")
    public List<WebElement> onSaleItemOldPrice;
    @FindBy(css = "ul.product-categories>li>a")
    public List<WebElement> productCategoriesList;
    @FindBy(name = "orderby")
    public WebElement defaultSortingDropDown;
    //onSale items are more than one but this locator will take the first one anyway it could be in the list too.
    @FindBy(xpath = "//span[text()=\"Sale!\"]")
    public WebElement onSaleItem;
    @FindBy(css = "del>span")
    public WebElement oldPriceOnSaleItem;
    @FindBy(css = "ins>span")
    public WebElement actualPriceOnSaleItem;
    //There are 8 add to basket link but this locator will represent the first one
    @FindBy(xpath = "//a[text()=\"Add to basket\"]")
    public WebElement addToBasketLink;
    @FindBy(css = "span.amount")
    public WebElement amountOnShoppingCart;
    @FindBy(css = "span.cartcontents")
    public WebElement cartContentOnShoppingCart;
    @FindBy(xpath = "//a[@title=\"View Basket\"]")
    public WebElement viewBasketLink;
    @FindBy(xpath = "//a[@title=\"View your shopping cart\"]")
    public WebElement viewShoppingCartLink;
    @FindBy(xpath = "//a[text()=\"Android Quick Start Guide\"]")
    public WebElement itemAddedToBasket;
    @FindBy(css = "td.product-subtotal>span")
    public WebElement priceOfProductInBasket;


    public void adjustPriceBySlider(int startPrice, int endPrice) {
        Actions move = new Actions(Driver.getDriver());
        move.click(leftSliderHandleIcon).build().perform();
        ReusableMethods.wait(2);

        int i = 0;
        while (i >= 0) {
            if (priceRangeTo.getText().contains(String.valueOf(endPrice)) && priceRangeFrom.getText().contains(String.valueOf(startPrice))) {
                break;
            } else {
                move.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            i++;
        }
    }

    public void verifyPricesAfterFilter() {
//       for(WebElement element: onSaleItemOldPrice){
//           if(prices.contains(element)){
//               prices.remove(element);
//           }
//       }

        for(int i=0; i<onSaleItemOldPrice.size();i++){
            if(onSaleItemOldPrice.get(i).getText().equals(prices.get(i).getText())){
                prices.remove(i);
            }
        }


        Iterator<WebElement> i = prices.iterator();
        while (i.hasNext()) {
            WebElement price = i.next();


            if(onSaleItemOldPrice.contains(price)){
                prices.remove(price);
            }
            String sPrice =price.getText().substring(1);


            Assert.assertTrue(Double.parseDouble(sPrice) >= 150 && Double.parseDouble(sPrice) <= 450);


        }
    }

    public void clickOnProductCategories(String category) {

        Driver.getDriver().findElement(By.xpath("//li/a[text()='"+category+"']")).click();


    }
    public void verifyParticularProductCategory(String category){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(category));
    }
}
