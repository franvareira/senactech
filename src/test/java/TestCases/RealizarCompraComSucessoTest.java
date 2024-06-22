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
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucessoTest extends TestBase {

    private final WebDriver driver = getDriverManager();
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(this.driver);

    @Test
    public void realizarCompra(){
        try{

        Report.createTest("Realizar compra com sucesso", ReportType.SINGLE);
        loginTask.efetuarLogin();
       // Thread.sleep(5000);
        produtoTask.selecionarProduto();
       //     Thread.sleep(5000);
        checkoutTask.realizarCheckout();
        //    Thread.sleep(5000);
        finishTask.finalizarCompra();

        }catch (Exception e){

          Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }

}
