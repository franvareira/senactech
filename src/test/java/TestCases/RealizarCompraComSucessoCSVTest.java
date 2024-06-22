package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.TestBase;
import Tasks.CheckoutTask;
import Tasks.FinishTask;
import Tasks.LoginTask;
import Tasks.ProdutoTask;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucessoCSVTest extends TestBase {

    private final WebDriver driver = getDriverManager();
    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(this.driver);

    @ParameterizedTest
    @CsvFileSource(resources = "/CSV/loginCSV.csv", numLinesToSkip = 1)
    @Tag("positivo")
    public void realizarCompra(String user,String password){

        Report.createTest("Realizar compra com sucesso parametrizado com CSV", ReportType.GROUP);
        Report.createStep("Realizar Login");
        loginTask.efetuarLoginCSV(user,password);
        Report.createStep("Selecionar Produto");
        produtoTask.selecionarProduto();
        Report.createStep("Realizar Checkout");
        checkoutTask.realizarCheckout();
        Report.createStep("Finalizar Compra");
        finishTask.finalizarCompra();
    }


}
