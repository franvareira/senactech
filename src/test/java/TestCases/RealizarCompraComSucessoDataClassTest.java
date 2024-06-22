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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucessoDataClassTest extends TestBase {

    private final WebDriver driver = getDriverManager();
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(this.driver);

    @ParameterizedTest
    @MethodSource("Framework.Utils.DataClass#loginTestData")
    public void realizarCompra(String user,String password){
        try {
            Report.createTest("Realizar compra com sucesso parametrizado com dataclass", ReportType.GROUP);
            Report.createStep("Realizar Login");
            loginTask.efetuarLoginCSV(user,password);
            Report.createStep("Selecionar Produto");
            produtoTask.selecionarProduto();
            Report.createStep("Realizar Checkout");
            checkoutTask.realizarCheckout();
            Report.createStep("Finalizar Compra");
            finishTask.finalizarCompra();
        }catch (Exception e){

            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }

    }


}
