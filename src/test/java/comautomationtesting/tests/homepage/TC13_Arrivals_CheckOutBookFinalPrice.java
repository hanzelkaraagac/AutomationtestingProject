package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_Arrivals_CheckOutBookFinalPrice {

    @Test
    public void Arrivals_CheckOutBookFinalPrice() {

        Homepage homepage = new Homepage();
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        String imageText;

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //4) Now click on Home menu button
        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.homeButton, 3);

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        jsexecutor.executeScript("window.scrollBy(0,1000)");
        int actualArrivals = homepage.threeArrivalOnly.size();
        int expectedArrivals = 3;
        Assert.assertEquals(actualArrivals, expectedArrivals);


        //7) Now click the image in the Arrivals
        imageText = homepage.itemInImage1.getText().toLowerCase();
        homepage.image1.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.image1, 5);


        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and should navigate to next page where user can add that book to his basket
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(imageText));
        assert homepage.addToBasketButton.isDisplayed();

        //10) Click on the Add To Basket button which adds that book to your basket
        homepage.addToBasketButton.click();
        String expectedAddedMessage = "“Selenium Ruby” has been added to your basket.";
        String actualAddedMessage = homepage.messageText.getText();
        System.out.println("actualAddedMessage = " + actualAddedMessage);
        Assert.assertTrue(actualAddedMessage.contains(expectedAddedMessage));

        //11) User can view that Book in the Menu item with price.
        homepage.viewBasketButton.click();
        Assert.assertEquals(homepage.productName.getText().toLowerCase(), imageText);
        Assert.assertTrue(homepage.productPrice.isDisplayed());

        //12) Now click on Item link which navigates to proceed to check out page.
        homepage.itemLink.click();
        Assert.assertTrue(homepage.proceedToCheckout.isDisplayed());

        //13) Now User can find the Total price of the book in the Check out grid.
        Assert.assertTrue(homepage.totalPriceOfSelectedBook.isDisplayed());

        //14) User has the feasibility to find the total price of the books at  the time of check out
        Assert.assertTrue(homepage.finalTotalPrice.isDisplayed());

        Driver.closeDriver();
    }
}
