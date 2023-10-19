package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("chckout page saucedemo")
    public void chckoutPageSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert,"Checkout: Your Information");
    }

    @When("input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("standard");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("user");
    }

    @And("input zip postal code")
    public void inputZipPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user in checkout overview page")
    public void userInCheckoutOverviewPage() {
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert,"Checkout: Overview");
        driver.close();
    }


    @Then("user get checkout error message")
    public void userGetCheckoutErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(),\"Error: Postal Code is required\")]")).getText();
        Assert.assertEquals(errorLogin, "Error: Postal Code is required");
        driver.close();
    }
}
