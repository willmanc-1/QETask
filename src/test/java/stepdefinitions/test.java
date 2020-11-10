package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static utils.BrowserFactory.driver;


    public class test{
        // Navigating to Google Home Page
        @Given("I navigate to Google home page")
        public void Google_homepage() {
            driver.get("https://www.google.com");
        }

        // Entering String into Google to Search
        @When("I search for {string}")
        public void Google_search(String text) {
            WebElement x = driver.findElement(By.name("q"));
            x.sendKeys(text);
            x.submit();
        }

        // Navigating to flooid
        @Then("I navigate to {string}")
        public void google_Navigate(String Text) {
            driver.navigate().to(Text);
        }

        // Validating URL
        @And("the URL is flooid.com")
        public void url_Validation() {
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "https://www.flooid.com/";
            Assert.assertEquals(currentURL,expectedURL);
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, expectedURL);
            if (!url.equals(expectedURL)) System.out.println("URL's do not match");
            System.out.println("URL's match");
        }

        // Validating Logo
        @And("I confirm the Flooid Logo is displayed")
        public void logo_Validation() {
            String expectedImage = "https://www.flooid.com/static/fc94747ad2c6944914d518ce2ff4d808/a54c6/bg-blob.png";
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            String image = driver.findElement(By.cssSelector("img")).getAttribute("src");
            System.out.println(image);
            Assert.assertEquals(image,expectedImage);
        }
        @After()
        public void closeBrowser() {
            driver.quit();
        }
    }



