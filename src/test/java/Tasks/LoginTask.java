package Tasks;

import Framework.Utils.FileOperation;
import PageObjects.LoginPage;
import Validation.GenericValidation;
import org.openqa.selenium.WebDriver;

public class LoginTask {
    private WebDriver driver;
    private LoginPage loginPage;
    private GenericValidation genericValidation;

    public LoginTask(WebDriver driver){
        this.driver=driver;
        loginPage = new LoginPage(this.driver);
        genericValidation = new GenericValidation(this.driver);
    }

    public void efetuarLogin(){
        loginPage.getUserNameInput().sendKeys("standard_user");
        loginPage.getPasswordInput().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        genericValidation.validationPages("Products");

    }

    public void efetuarLoginCSV(String user, String password){
        loginPage.getUserNameInput().sendKeys(user);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        genericValidation.validationPages("Products");

    }

    public void efetuarLoginProperties(){
        loginPage.getUserNameInput().sendKeys(FileOperation.getProperties("user").getProperty("user"));
        loginPage.getPasswordInput().sendKeys(FileOperation.getProperties("user").getProperty("password"));
        loginPage.getLoginButton().click();
        genericValidation.validationPages("Products");


    }
}
