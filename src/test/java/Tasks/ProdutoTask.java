package Tasks;

import PageObjects.CartPage;
import PageObjects.ProdutoPage;
import Validation.GenericValidation;
import org.openqa.selenium.WebDriver;

public class ProdutoTask {
    private WebDriver driver;
    private ProdutoPage produtoPage;
    private CartPage cartPage;
    private GenericValidation genericValidation;
     public ProdutoTask(WebDriver driver){
         this.driver=driver;
         produtoPage = new ProdutoPage(this.driver);
         cartPage = new CartPage(this.driver);
         genericValidation = new GenericValidation(this.driver);

     }

     public void selecionarProduto(){

         produtoPage.getProdutoLink().click();
         produtoPage.getAddCartButton().click();
         produtoPage.getCartButton().click();
         genericValidation.validationPages("Your Cart");
         cartPage.getCheckoutButton().click();
     }
}
