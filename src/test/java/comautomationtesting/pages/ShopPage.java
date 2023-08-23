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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

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

    @FindBy(linkText = "Shop")
    public WebElement shopButton;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]")
    public WebElement filterRightButton;

    @FindBy(xpath = "//button[.='Filter']")
    public WebElement filterButton;

    @FindBy(xpath = "//a[.='Android']")
    public WebElement productAndroid;

    @FindBy(xpath = "//nav[@class='woocommerce-breadcrumb']")
    public WebElement homeChosenProduct;
    @FindBy(css = "select[name='orderby']")
    public WebElement defaultSortingDropdown;

    @FindBy(xpath = "//a[.='Shop']")
    public WebElement shopBtn;

    @FindBy(xpath = "//span[.='Sale!']")
    public WebElement saleBtn;

    @FindBy(xpath = "//p[@class='price']/del/span")
    public WebElement oldPrice;

    @FindBy(xpath = "//p[@class='price']//ins/span")
    public WebElement actualPrice;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]")
    public WebElement threeSliders;

    @FindBy(xpath = "//div[@data-slide-duration='0']")
    public List<WebElement> threeSlidersOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
    public List<WebElement> threeArrivalOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//img")
    public WebElement image1;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement messageText;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//h3")
    public WebElement itemInImage1;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[3]//h3")
    public WebElement itemInImage3;

    @FindBy(xpath = "//img[@title='Mastering JavaScript']")
    public WebElement image3LessThan450;

    @FindBy(css = "li[class='description_tab active']")
    public WebElement descriptionButton;

    @FindBy(xpath = "//div[@id='tab-description']/p")
    public WebElement descriptionText;

    @FindBy(xpath = "//span[@class='posted_in']/a")
    public WebElement categoryOfBook;

    @FindBy(xpath = "//li[@class='reviews_tab']")
    public WebElement reviewsButton;

    @FindBy(xpath = "//div[@id='comments']//p")
    public WebElement reviewText;

    @FindBy(xpath = "//a[.='View Basket']")
    public WebElement viewBasketButton;

    @FindBy(xpath = "//a[.='Selenium Ruby']")
    public WebElement productNameImage1;

    @FindBy(xpath = "//td[@data-title='Product']/a")
    public WebElement productName;

    @FindBy(xpath = "//td[@class='product-price']/span")
    public WebElement productPrice;

    @FindBy(css = "input[title='Qty']")
    public WebElement quantityOfBook;

    @FindBy(className = "cartcontents")
    public WebElement itemLink;

    @FindBy(css = "a[class='checkout-button button alt wc-forward'")
    public WebElement proceedToCheckout;

    @FindBy(id = "coupon_code")
    public WebElement inputCouponCode;

    @FindBy(xpath = "//input[@value='Apply Coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//td[@data-title='Coupon: krishnasakinala']/span")
    public WebElement freeCouponAmount;

    @FindBy(xpath = "//a[.='×']")
    public WebElement removeButton;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    public WebElement returnToShopButton;


    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement couponErrorMessage;

    @FindBy(css = "a[class='pp_close']")
    public WebElement closeButton;

    @FindBy(css = "input[value='Update Basket']")
    public WebElement updateBasketButton;

    @FindBy(xpath = "(//td[@data-title='Total'])[1]/span")
    public WebElement totalPriceOfSelectedBook;

    @FindBy(xpath = "(//td[@data-title='Total'])[2]/strong/span")
    public WebElement finalTotalPrice;

    @FindBy(xpath = "//td[@data-title='Subtotal']")
    public WebElement subtotalValue;

    @FindBy(css = "div[class='woocommerce-billing-fields']")
    public WebElement billingDetails;

    @FindBy(css = "div[class='woocommerce-shipping-fields']")
    public WebElement additionalInformation;

    @FindBy(css = "table[class='shop_table woocommerce-checkout-review-order-table']")
    public WebElement orderDetails;

    @FindBy(css = "div[class='woocommerce-checkout-payment']")
    public WebElement paymentGateway;

    @FindBy(css = "input[id='billing_first_name']")
    public WebElement inputFirstName;

    @FindBy(css = "input[id='billing_last_name']")
    public WebElement inputLastName;

    @FindBy(css = "input[id='billing_email']")
    public WebElement inputEmailAddress;

    @FindBy(css = "input[id='billing_phone']")
    public WebElement inputPhoneNumber;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement inputCountry;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    public WebElement searchCountryBox;

    @FindBy(xpath = "//*[@id='billing_country']")
    public WebElement dropdownCountry;

    @FindBy(css = "input[id='billing_address_1']")
    public WebElement inputAddress;

    @FindBy(css = "input[id='billing_postcode']")
    public WebElement inputPostCode;

    @FindBy(css = "input[id='billing_city']")
    public WebElement inputTown;

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement dropdownProvince;

    @FindBy(css = "input[id='payment_method_bacs']")
    public WebElement directBankRadioBtn;

    @FindBy(css = "input[id='payment_method_cod']")
    public WebElement cashOnDeliveryRadioBtn;
    @FindBy(css = "input[id='payment_method_cheque']")
    public WebElement checkRadioBtn;

    @FindBy(css = "input[id='payment_method_ppec_paypal']")
    public WebElement payPalRadioBtn;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(className = "showcoupon")
    public WebElement addACouponLink;

    @FindBy(xpath = "//img[@loading='lazy']")
    public List<WebElement> threeArrivals;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homePageButton;

    @FindBy(xpath = "//div[@style='width: 1160px; height: 652px;']")
    public WebElement threeslide;

    @FindBy(xpath = "//img[@title='Selenium Ruby']")
    public WebElement firstArrivals;

    @FindBy(xpath = "//img[@title='Mastering JavaScript']")
    public WebElement thirdArrivals;

    @FindBy(xpath = "//a[.='Description']")
    public WebElement descriptionTab;

    @FindBy(xpath = "//a[.='Reviews (0)']")
    public WebElement reviewsTab;

    @FindBy(xpath = "//h2[.='Reviews']")
    public WebElement reviewsText;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasketBtn;
    @FindBy(xpath = "//span[.='1 item']")
    public WebElement itemText;
    @FindBy(xpath = "//span[@class='amount']")
    public WebElement priceText;

    @FindBy(xpath = "(//a[@href='https://practice.automationtesting.in/basket/'])[1]")
    public WebElement checkoutPageButton;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeInputBox;

    @FindBy(xpath = "//table[@class='shop_table shop_table_responsive']/tbody/tr[2]")
    public WebElement couponCode;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@title='Remove this item']")
    public WebElement removeThisButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    public WebElement quantityInputBox;

    @FindBy(xpath = "//div[.='Basket updated.']")
    public WebElement basketUpdatedText;

    @FindBy(xpath = "//input[@id='s2id_autogen2_search']")
    public WebElement searchProvinceBox;

    @FindBy(id = "billing_state")
    public WebElement dropdown;

    @FindBy(xpath = "//li[@role='presentation']")
    public WebElement provinceOptions;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]")
    public WebElement inputProvince;

    @FindBy(css = "p[class='woocommerce-thankyou-order-received']")
    public WebElement orderThankyouMessage;

    @FindBy(css = "table[class='shop_table order_details']")
    public WebElement orderDetailTable;

    @FindBy(css = "h2[class='wc-bacs-bank-details-heading']")
    public WebElement bankDetail;
    @FindBy(xpath = "//h3[text()='Android Quick Start Guide']")
    public WebElement sale1;
    @FindBy(xpath = "//h3[text()='Thinking in HTML']")
    public WebElement sale2;
    @FindBy(xpath = "//span[@class='amount']")
    public WebElement priceAmount;
    @FindBy(xpath = "//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']")
    public WebElement subTotal;
    @FindBy(xpath = "//strong//span[@class='woocommerce-Price-amount amount']")
    public WebElement total;
    @FindBy(id = "s2id_billing_state")
    public WebElement county;
    @FindBy(id = "s2id_autogen2_search")
    public WebElement countyInputBox;
    @FindBy(id = "payment_method_bacs")
    public WebElement bankTransfer;
    @FindBy(id = "payment_method_cheque")
    public WebElement paymentRadioBtn;
    @FindBy(xpath = "//span[@class='cartcontents']")
    public WebElement itemMenu;
    @FindBy(xpath = "//a[normalize-space()='HTML5 Forms']")
    public WebElement product;
    @FindBy(xpath = "//td[@class='product-price']//span[@class='woocommerce-Price-amount amount']")
    public WebElement prodctPrice;

    @FindBy(xpath = "//span[@style='left: 100%;']")
    public WebElement adjustRightBtn;

    @FindBy(xpath = "//span[@style='left: 85.7143%;']")
    public WebElement adjustLeft450;

    @FindBy(xpath = "//ul[@class='product-categories']/li")
    public List<WebElement> productList;

    @FindBy(xpath = "//a[.='Android']")
    public WebElement androidBtn;

    @FindBy(xpath = "//nav[@class='woocommerce-breadcrumb']/a")
    public WebElement productPage;

    @FindBy(tagName = "h3")
    public List<WebElement> productTitle;

    @FindBy(xpath = "//select[@name='orderby']")
    public WebElement sortDropdown;

    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    public List<WebElement> priceList;
    @FindBy(xpath = "//a[@data-product_id='160']")
    public WebElement shopPageAddToBasketBtn;

    @FindBy(xpath = "//*[.='View Basket']")
    public WebElement viewBasketBtn;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//h3[.='Your order']")
    public WebElement peymentGateWay;

    @FindBy(id = "billing_first_name")
    public WebElement billingFirsNameInputBox;

    @FindBy(id = "billing_last_name")
    public WebElement billingLastNameInputBox;

    @FindBy(id = "billing_email")
    public WebElement billing_emailInputBox;

    @FindBy(id = "billing_phone")
    public WebElement billing_phone_InputBox;
    @FindBy(id = "s2id_billing_country")
    public WebElement billingCountryDropdown;
    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
    public List<WebElement> countryOptions;
    @FindBy(id = "s2id_autogen1_search")
    public WebElement billingCountryInputBox;

    @FindBy(id = "billing_address_1")
    public WebElement billingAddress;

    @FindBy(id = "billing_postcode")
    public WebElement billingPostCodeInputBox;

    @FindBy(id = "billing_state")
    public WebElement billingState;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement billingStateOption;

    @FindBy(id = "billing_city")
    public WebElement billing_cityInputBox;

    @FindBy(id = "select2-chosen-2")
    public WebElement billingProvincedropdown;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
    public List<WebElement> billingProvinceOptions;
    @FindBy(id = "s2id_autogen2_search")
    public WebElement billingProvinceInputBox;

    @FindBy(id = "place_order")
    public WebElement placeOrderBtn;
    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    public WebElement orderConfirmMessage;

    @FindBy(xpath = "//h2[.='Our Bank Details']")
    public WebElement bankDetails;

    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-in-tax-1']/td")
    public WebElement taxForIndia;

    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-roaming-tax-1']/td")
    public WebElement taxForOtherCountries;

    @FindBy(xpath = "//td[@class='product-total']/span")
    public WebElement totalAtLastPage;

    @FindBy(xpath = "//span[@tabindex='0']")
    public WebElement rightSliderHandleIcon;


    public void price(String number, String number1) {
        WebElement price = Driver.getDriver().findElement(By.xpath("//ins/span[contains(text(),'" + number + "')]"));
        WebElement price2 = Driver.getDriver().findElement(By.xpath("//del/span[contains(text(),'" + number1 + "')]"));
        if (number == "450" && number1 == "600") {
            assertTrue(price.isDisplayed());
            assertTrue(price2.isDisplayed());
        } else if (number == "400" && number1 == "450") {
            assertTrue(price.isDisplayed());
            assertTrue(price2.isDisplayed());
        }
    }

    public void addToBasket(int num) {
        WebElement addToBasket = Driver.getDriver().findElement(By.xpath("//a[@rel='nofollow']/../..//li[" + num + "]//a[2]"));
        ReusableMethods.waitAndClick(addToBasket, 6);
        ReusableMethods.wait(4);
    }

    public void itemMenu(){
        itemMenu.click();
        assertTrue(product.isDisplayed());
        assertTrue(prodctPrice.isDisplayed());

    }

    public void viewBasket(int num) {
        WebElement viewBasket = Driver.getDriver().findElement(By.xpath("//a[@title='View Basket']/../..//li[" + num + "]/a[3]"));
        ReusableMethods.waitAndClick(viewBasket, 2);
    }

    public void subTotalAndTotal() {
        List<WebElement> subTotalAndTotal = Driver.getDriver().findElements(By.xpath("//tr[@class='cart-subtotal']/..//tr/th"));
        for (int i = 0; i < subTotalAndTotal.size(); i++) {
            subTotalAndTotal.get(i).isDisplayed();
            ReusableMethods.wait(2);
        }
    }

    public void always() {
        String totalPrice = total.getText();
        String totalSubstring = totalPrice.substring(1);
        double v = Double.parseDouble(totalSubstring);
        String subTotalPrice = subTotal.getText();
        String subTotalSubstring = subTotalPrice.substring(1);
        double v1 = Double.parseDouble(subTotalSubstring);
        ReusableMethods.wait(3);
        assertTrue(v > v1);
    }

    public void verifyAssertions() {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(billingDetails);
        webElementList.add(orderDetails);
        webElementList.add(paymentGateway);
        webElementList.add(additionalInformation);
        for (WebElement element : webElementList) {
            assertTrue(element.isDisplayed());
        }
    }

    public void addBillingInformation() {
        inputFirstName.sendKeys("ali");
        inputLastName.sendKeys("yılmaz");
        inputEmailAddress.sendKeys("ali@gmail.com");
        inputPhoneNumber.sendKeys("01234567891");
        ReusableMethods.waitAndClick(inputCountry, 4);
        searchCountryBox.sendKeys("Hungary", Keys.ENTER);
        inputAddress.sendKeys("23 sokak ");
        inputTown.sendKeys("az");
        county.click();
        countyInputBox.sendKeys("Zala", Keys.ENTER);
        inputPostCode.sendKeys("46000");
    }

    public void paymentControl() {
        ReusableMethods.clickWithJS(paymentRadioBtn);
        ReusableMethods.scrollIntoViewJS(bankTransfer);
        ReusableMethods.waitAndClick(placeOrderButton, 4);
        assertTrue(orderDetailTable.isDisplayed());

    }


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


            assertTrue(Double.parseDouble(sPrice) >= 150 && Double.parseDouble(sPrice) <= 450);


        }
    }

    public void clickOnProductCategories(String category) {

        Driver.getDriver().findElement(By.xpath("//li/a[text()='"+category+"']")).click();


    }
    public void verifyParticularProductCategory(String category){
        assertTrue(Driver.getDriver().getTitle().contains(category));
    }
}
