package ui.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Search {
    WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I view an item order \"$term\" status")
    public void visit(String term) {
        driver.get("http://localhost:9000/getStatus/"+term);
    }

    @When("I update the status")
    public void searchForTerm() {
        driver.findElement(By.name("ChangeStatus")).submit();
    }

    @Then("I should see successful update message" )
    public void verifyTermResults() {
        String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println("******************" + message);
        assertEquals(message,"Your order has been successfully updated.");
    }

}
