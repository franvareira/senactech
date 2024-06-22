package Validation;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FileOperation;
import PageObjects.CheckoutPage;
import PageObjects.FinishPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutValidation {
    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutValidation(WebDriver driver){
        this.driver=driver;
        checkoutPage= new CheckoutPage(this.driver);
    }

    public void validationForm(){
    try{
        Assertions.assertFalse(checkoutPage.getFirstNameInput().getAttribute("value").equalsIgnoreCase(" "));
        Report.log(Status.PASS, "Os campos foram preenchidos com Sucesso", Screenshot.capture(driver));
    }catch (Exception e){
        Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
    }
    }

    public void validationCamposForm(){
  try{
        String name = FileOperation.getProperties("form").getProperty("name");
        String lastName = FileOperation.getProperties("form").getProperty("lastname");
        String zipCode = FileOperation.getProperties("form").getProperty("zip");

        Assertions.assertEquals(name,checkoutPage.getFirstNameInput().getAttribute("value"));
        Assertions.assertEquals(lastName,checkoutPage.getLastNameInput().getAttribute("value"));
        Assertions.assertEquals(zipCode,checkoutPage.getZipCodeInput().getAttribute("value"));
        Report.log(Status.PASS, "Os campos foram preenchidos com Sucesso", Screenshot.capture(driver));
    }catch (Exception e){
      Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
    }
    }
}
