/**
 * Created by Hunter on 2015-04-08.
 */

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class TelemanSteps {

    private final Pages pages;

    public TelemanSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Home page")
    public void userIsOnHomePage(){
        pages.home().openHome();
    }

    @When("user search")
    public void userSearchSomething() throws InterruptedException {
        pages.home().findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).sendKeys("Polsat");
        pages.home().findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).submit();
    }

    @When("user opens Sport link")
    public void userClicksOnSportLink(){
        pages.home().findElement(By.linkText("SPORT")).click();
    }

    @When("Channels page is shown")
    public void channelsPageIsShow(){
        pages.home().findElement(By.linkText("STACJE")).click();
        pages.home().findElement(By.linkText("Discovery Channel")).click();

    }
    @When("user login on page")
    public void loginOnPage(){
        pages.home().findElement(By.cssSelector("a[href*='/account']")).click();
        pages.home().findElement(By.id("id_username")).sendKeys("login");
        pages.home().findElement(By.id("id_password")).sendKeys("password");
        pages.home().findElement(By.xpath(".//*[@id='loginForm']/div[1]/input")).click();
    }

    @Then("Sport page is shown")
    public void sportPageIsShown(){
        assertEquals("Sport w Programie TV - Program telewizyjny Teleman.pl", pages.sport().getTitle());
    }



    @Then("results page is shown")
    public void resultsPageIsShown() {
        assertTrue(pages.home().getTitle().startsWith("Wyniki wyszukiwania"));
    }
    @Then("Discovery Channel page is shown")
    public void discoveryChannelPageIsShown(){
        assertTrue(pages.home().getTitle().startsWith("Discovery Channel - Aktualny Program TV"));
    }

    @Then("error is shown")
    public void errorShow(){
        assertTrue(pages.home().findElement(By.className("errorlist")).isDisplayed());
    }
}

