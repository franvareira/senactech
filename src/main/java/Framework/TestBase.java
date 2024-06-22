package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import Framework.Report.Report;
import Framework.Utils.FileOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase extends DriverManager {

    private static WebDriver driver;
  //private static String URL = "https://www.saucedemo.com/";
    //esta lendo a url do arquivo url.properties e
  // pegando o valor que esta dentro da variavel index
    private static String URL = FileOperation.getProperties("url").getProperty("index");

    public static WebDriver getDriverManager(){

        driver = getDriver(TypeBrowser.CHROME);
        return driver;
    }

    @BeforeEach
    public void setUp(){

        getDriverManager().get(URL);
    }

    @AfterEach
    public void finish(){
        Report.close();
        quitDriver();
    }


}
