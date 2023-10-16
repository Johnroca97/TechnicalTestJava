package test.technical.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class comprarLibrosStepDefinitions {

    private WebDriver driver;
    @Given("Que el usuario realizo inicio de sesion con sus credenciales")
    public void realizarLogin(){

        System.setProperty("webdriver.chrome.driver", "/Users/johnrodriguez/chromedriver/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://sahitest.com/demo/training/login.htm");
        driver.findElement(By.cssSelector("input[name='user']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("secret");
        driver.findElement(By.className("button")).click();

    }

    @When("Agregue a la canasta de libros: 3 core Java, 5 ruby for rail y 2 Python cookbook")
    public void agregarItems(){

        WebElement java = driver.findElement(By.xpath("(//input[@name='q'])[1]"));
        java.clear();
        java.sendKeys("3");

        WebElement ruby = driver.findElement(By.xpath("(//input[@name='q'])[2]"));
        ruby.clear();
        ruby.sendKeys("5");

        WebElement python = driver.findElement(By.xpath("(//input[@name='q'])[3]"));
        python.clear();
        python.sendKeys("2");

        driver.findElement(By.cssSelector("input[value='Add']")).click();

    }

    @Then("La suma total a pagar debe ser correcta")
    public void validarValorAPagar(){

        //total Core Java
        WebElement coreJava = driver.findElement(By.xpath("(//table[@id='added']//td)[8]"));
        String textoJava = coreJava.getText();
        String valorJava = textoJava.replaceAll("\\D+", "");
        int numJava = Integer.parseInt(valorJava);

        //total ruby for rails
        WebElement rubyRail = driver.findElement(By.xpath("(//table[@id='added']//td)[12]"));
        String textoRuby = rubyRail.getText();
        String valorRuby = textoRuby.replaceAll("\\D+", "");
        int numRuby = Integer.parseInt(valorRuby);

        //total Python Cookbook
        WebElement pythonCookbook = driver.findElement(By.xpath("(//table[@id='added']//td)[16]"));
        String textoPython = pythonCookbook.getText();
        String valorPython = textoPython.replaceAll("\\D+", "");
        int numPython = Integer.parseInt(valorPython);

        //suma total
        int valorTotal = numJava + numRuby + numPython;
        WebElement grandTotal = driver.findElement(By.id("total"));
        String gTotal = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].value;", grandTotal);
        int numGtotal = Integer.parseInt(gTotal);
        Assert.assertEquals(valorTotal, numGtotal);

    }
    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.close();
        }
    }
}
