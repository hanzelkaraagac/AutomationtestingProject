package comautomationtesting.tests.my_account_login;

import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC23_LoginWithEmptyUsernameAndPW {

    @Test
    public void loginWithEmptyUsernameAndPW() {

        LoginPage loginPage = new LoginPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter empty username in username textbox
        loginPage.inputUsername.sendKeys("");

        //5) Now enter ( valid ) empty password in the password textbox
        loginPage.inputPassword.sendKeys("");

        //6) Click on login button.
        loginPage.loginButton.click();

        //7) Proper error must be displayed(ie required username) and prompt to enter login again
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Username is required."));
        Assert.assertTrue(loginPage.loginForm.isDisplayed());

        Driver.closeDriver();

    }
}
