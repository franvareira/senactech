package Tasks;

import Framework.Browser.Waits;
import PageObjects.FinishPage;
import Validation.FinishValidation;
import Validation.LoginValidation;
import org.openqa.selenium.WebDriver;

public class FinishTask {

    private WebDriver driver;
    private FinishPage finishPage;
    private FinishValidation finishValidation;
    private LoginValidation loginValidation;
    private Waits waits;
    public FinishTask(WebDriver driver){
        this.driver=driver;
        waits = new Waits(this.driver);
        finishPage = new FinishPage(this.driver);
        finishValidation = new FinishValidation(this.driver);
        loginValidation = new LoginValidation(this.driver);
    }

    public void finalizarCompra(){

        finishPage.getFinishButton().click();
        finishValidation.validationMessagemCompraConcluida();
        finishPage.getMenuButton().click();
        waits.loadElement(finishPage.getMenuLogoutLink());
        finishPage.getMenuLogoutLink().click();
        loginValidation.loginValidation();

    }
}
