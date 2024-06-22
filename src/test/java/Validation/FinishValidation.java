package Validation;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.FinishPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FinishValidation {

    private WebDriver driver;
    private FinishPage finishPage;

    public FinishValidation(WebDriver driver){
        this.driver=driver;
        finishPage= new FinishPage(this.driver);
    }

    public void validationMessagemCompraConcluida(){
       try{
        Assertions.assertEquals("Thank you for your order!",finishPage.getFinishTextLabel().getText());
        Report.log(Status.PASS, "Compra foi realizada com Sucesso", Screenshot.capture(driver));
    }catch (Exception e){
         Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
       }
    }
}
