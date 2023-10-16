package test.technical.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class error500PageStepDefinitions {

    private WebDriver driver;
    @Given("Que el usuario accede a la Pagina Sahi Tests")
    public void accesoWeb(){

        System.setProperty("webdriver.chrome.driver", "/Users/johnrodriguez/chromedriver/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://sahitest.com/demo/");

    }

    @And("Presiona la opcion Error Page")
    public void accesoErrorPage(){

        driver.findElement(By.cssSelector("a[href='errorPages.htm']")).click();

    }

    @When("Selecciona la opcion 500 Page")
    public void seleccionarOpcion500(){

        driver.findElement(By.cssSelector("a[href='/demo/php/500.php']")).click();

    }

    @Then("Debe ingresar a la pagina 500 Page")
    public void paginaError(){

        String response = "500";
        String url = driver.getCurrentUrl();
        Assert.assertTrue("El URL no contiene el valor esperado.", url.contains(response));

        WebElement mensajeURL = driver.findElement(By.xpath("//div[contains(text(),'HTTP ERROR 500')]"));
        String msjURL = mensajeURL.getText();
        Assert.assertTrue("El URL no contiene el valor esperado.", url.contains(response));


    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.close();
        }
    }

}
