package comautomationtesting.tests.myaccount;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_45_MyAccounts {

    @Test
    public void Orders() {

        MyAccountPage myAccountPage = new MyAccountPage();

        //45. My Accounts - Orders
        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //   3) Click on My Account Menu
        myAccountPage.myAccountBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(myAccountPage.myAccountBtn, 3);

        //   4) Enter registered username in username text box
        myAccountPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("email"));

        //   5) Enter password in password text box
        myAccountPage.passInputBox.sendKeys(ConfigurationReader.getProperty("password"));

        //   6) Click on login button
        myAccountPage.loginBtn.click();

        //7) User must successfully login to the web page
        Assert.assertTrue(myAccountPage.myAccountContent.isDisplayed());

        //8) Click on Myaccount link which leads to Dashboard
        //9) Click on Orders link
        myAccountPage.ordersBtn.click();
        Driver.getDriver().navigate().refresh();

        //10) User must view their orders on clicking orders link
        Assert.assertTrue(myAccountPage.orderTable.isDisplayed());
        assert Driver.getDriver().getCurrentUrl().contains("orders");

        Driver.closeDriver();

    }
}
