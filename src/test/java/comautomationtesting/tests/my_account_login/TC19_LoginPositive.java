package comautomationtesting.tests.my_account_login;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC19_LoginPositive {

    @Test
    public void Login() {
        LoginPage loginPage = new LoginPage();

        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //   3) Click on My Account Menu
        loginPage.myAccountBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(loginPage.myAccountBtn, 3);

        //   4) Enter registered username in username text box
        loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("email"));

        //   5) Enter password in password text box
        loginPage.passInputBox.sendKeys(ConfigurationReader.getProperty("password"));

        //   6) Click on login button
        loginPage.loginBtn.click();

        //   7) User must successfully log in to the web page
        Assert.assertTrue(loginPage.dashboardBtn.isDisplayed());
    }
}
