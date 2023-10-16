package test.technical.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginStepDefinitions {
    private WebDriver driver;
    @Given("Que el usuario accede a la pagina de inicio de sesion")
    public void accesoAPaginaLogin(){

        System.setProperty("webdriver.chrome.driver", "/Users/johnrodriguez/chromedriver/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://sahitest.com/demo/training/login.htm");

    }

    @When("Ingresa Username, Password correcto y presiona el boton Login")
    public void realizarLogin(){

        driver.findElement(By.cssSelector("input[name='user']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("secret");
        driver.findElement(By.className("button")).click();

    }

    @Then("accede a la pagina de libros disponibles para seleccionar")
    public void loginExitoso(){

        WebElement accessLogin = driver.findElement(By.cssSelector("div[id='available'] h2"));
        String textLogin = accessLogin.getText();

        Assert.assertEquals("All available books", textLogin);

    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.close();
        }
    }
}
