package comautomationtesting.tests.my_account_login;
import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC20_LoginNegative {

    @Test
    public void loginNegative(){
        LoginPage loginPage = new LoginPage();

        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //   3) Click on My Account Menu
       loginPage.myAccountBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(loginPage.myAccountBtn,3);

        //   4) Enter incorrect username in username textbox
       loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("wrongEmail"));

        //   5) Enter incorrect password in password textbox.
        ReusableMethods.wait(5);
       loginPage.passInputBox.sendKeys(ConfigurationReader.getProperty("wrongPassword"));
        ReusableMethods.wait(5);

        //   6) Click on login button
       loginPage.loginBtn.click();

        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("The password you entered for the username "+ConfigurationReader.getProperty("wrongEmail")+" is incorrect."));

        Driver.closeDriver();
    }
}
