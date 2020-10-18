package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static utils.BrowserFactory.driver;

public class test {

    // Navigating to Google Home Page
    @Given("I navigate to Google home page")
    public void Google_homepage() {
        driver.get("https://www.google.com");
    }

    //Entering String into Google to Search
    @When("I search for {string}")
    public void Google_search_for(String text) {
        driver.findElement(By.name("q")).sendKeys(text);
        driver.findElement(By.name("q")).submit();
    }

    //Print search string to confirm google search
    @Then("The page should contain {string}")
    public void Google_page_contains(String text) {
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.findElements(By.tagName("a"));
        System.out.println(driver.getTitle());
    }

    //Return top ten website links and info. from search string
    @Then("I return the top ten website for {string}")
    public void Google_page_websites(String text) {
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement x : links) {
            System.out.println(x.getText());
        }
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}



