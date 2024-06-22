package Validation;

import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.GenericPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidation {

    private WebDriver driver;
    private GenericPage genericPage;
    public GenericValidation(WebDriver driver){

        this.driver = driver;
        genericPage = new GenericPage(this.driver);
    }

    public void validationPageProducts(){
        // exemplo metodo unico para cada validacao de texto da pagina
        String label = genericPage.getTextSpan().getText();
        Assertions.assertEquals("Products",label);
    }

    public void validationPages(String texto){
        try{
        String label = genericPage.getTextSpan().getText();
        Assertions.assertEquals(texto,label);
        Report.log(Status.PASS, "Acessou a pagina" + texto + " foi acessada com sucesso", Screenshot.capture(driver));

    }catch (Exception e){
        Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }

    public void validationProduto(){
        try{

            Assertions.assertTrue(genericPage.getTextProdutoLabel().isDisplayed());
            Report.log(Status.PASS, "O produto selecionado esta correto", Screenshot.capture(driver));
    }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }


}
