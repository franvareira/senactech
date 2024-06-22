package Validation;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidation {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginValidation(WebDriver driver){
        this.driver=driver;
        loginPage = new LoginPage(this.driver);

    }

    public void loginValidation(){
        try{
        Assertions.assertTrue(loginPage.getUserNameInput().isDisplayed());
        Report.log(Status.PASS, "Acessou a pagina de Login com sucesso", Screenshot.captureBase64(driver));
    }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }
}
