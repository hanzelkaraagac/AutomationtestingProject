package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_AddToBasket {
    @Test
    public void addToBasket() {

        Homepage homepage = new Homepage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //4) Now click on Home menu button
        ReusableMethods.clickWithJS(homepage.homePageButton);
        ReusableMethods.waitAndClick(homepage.homePageButton, 2);


        //5) Test whether the Home page has Three Sliders only
        Driver.getDriver().navigate().refresh();
        Assert.assertEquals(homepage.threeArrivals.size(), 3);

        //6) The Home page must contains only three Arrivals

        //7) Now click the image in the Arrivals
        homepage.firstArrivals.click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://practice.automationtesting.in/product/selenium-ruby/");

        //9) Image should be clickable and should navigate to next page where user can add that book to his basket
        // Driver.getDriver().navigate().back();
        //Assert.assertTrue(homepage.firstArrivals.isEnabled());

        //10) Click on the Add To Basket button which adds that book to your basket
        homepage.addToBasketBtn.click();

        //11) User can view that Book in the Menu item with price.
        String itemText = homepage.itemText.getText();
        Assert.assertEquals(itemText, "1 Item");
        String priceText = homepage.priceText.getText();
        Assert.assertEquals(priceText, "₹500.00");

        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket



    }
}
