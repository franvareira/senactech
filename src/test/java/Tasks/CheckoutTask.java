package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import PageObjects.CheckoutPage;
import Validation.CheckoutValidation;
import Validation.GenericValidation;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private GenericValidation genericValidation;
    private CheckoutValidation checkoutValidation;

    private FakersGeneration fakers;
    public CheckoutTask(WebDriver driver){
        this.driver=driver;
        checkoutPage = new CheckoutPage(this.driver);
        genericValidation = new GenericValidation(this.driver);
        checkoutValidation = new CheckoutValidation(this.driver);
        fakers = new FakersGeneration();
    }

    public void realizarCheckout(){

        genericValidation.validationPages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys("Francielle");
        checkoutPage.getLastNameInput().sendKeys("Vareira");
        checkoutPage.getZipCodeInput().sendKeys("99999999");
        checkoutValidation.validationForm();
        checkoutPage.getContinueButton().click();
        genericValidation.validationPages("Checkout: Overview");
        genericValidation.validationProduto();

    }

    public void realizarCheckout2(){

        String name = fakers.getFirstName();
        String lastName = fakers.getLastName();
        String zipCode = fakers.getZipCode();
        FileOperation.setProperties("form","name",name);
        FileOperation.setProperties("form","lastname",lastName);
        FileOperation.setProperties("form","zip",zipCode);

        genericValidation.validationPages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys(name);
        checkoutPage.getLastNameInput().sendKeys(lastName);
        checkoutPage.getZipCodeInput().sendKeys(zipCode);
        checkoutValidation.validationCamposForm();
        checkoutPage.getContinueButton().click();
        genericValidation.validationPages("Checkout: Overview");
        genericValidation.validationProduto();

    }
}
