package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Tasks.CheckoutTask;
import Tasks.FinishTask;
import Tasks.LoginTask;
import Tasks.ProdutoTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucessoPropriedadesTest extends TestBase {

    private final WebDriver driver = getDriverManager();
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(this.driver);

   @Test
   @Tag("regressao")
    public void realizarCompra(){
        try{
            Report.createTest("Realizar compra com sucesso parametrizado com propriedades", ReportType.GROUP);
            Report.createStep("Realizar Login");
            loginTask.efetuarLoginProperties();
            Report.createStep("Selecionar Produto");
            produtoTask.selecionarProduto();
            Report.createStep("Realizar Checkout");
            checkoutTask.realizarCheckout2();
            Report.createStep("Finalizar Compra");
            finishTask.finalizarCompra();
    }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
   }


}
