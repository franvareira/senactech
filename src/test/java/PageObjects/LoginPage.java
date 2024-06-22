package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUserNameInput(){

      /*  WebElement name = driver.findElement(By.id("user-name"));
        return name; */

        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordInput(){

        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton(){

        return driver.findElement(By.id("login-button"));
    }

}
