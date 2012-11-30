package ui.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Search {
    WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I visit Google Home Page")
    public void visit() {
        driver.get("http://www.google.com");
    }

    @When("I search for \"$term\"")
    public void searchForTerm(String term) {
        driver.findElement(By.name("q")).sendKeys(term);
        driver.findElement(By.name("btnG")).submit();
    }

    @Then("I should see search results for \"$term\"")
    public void verifyTermResults(String term) {
//        String searchTerm = driver.findElement(By.cssSelector(".content .box h2")).getText();
//        assertThat(searchTerm, is(equalTo("Search results for: " + term)));
    }

}
