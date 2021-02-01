package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.ValidateTotalPrice;
import tasks.EnterDataForSearchHotel;
import tasks.OpenPage;
import tasks.ValidatePrice;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ChooseHotelStepdefinitions {
    @Managed(driver = "firefox")
    private WebDriver herBrowser;
    private Actor user = Actor.named("usuario");
    private HomePage homePage;

    @Before
    @Given("^that user enter to page$")
    public void thatUserEnterToPage() {
        user.can(BrowseTheWeb.with(herBrowser));
        user.attemptsTo(OpenPage.at(homePage));
    }

    @When("^she choose options location, (.*) and start date \"([^\"]*)\" end date \"([^\"]*)\"$")
    public void sheChoseOptionsLocationLasVegasAndStarDateEndDate(String location,String checkIn, String checkOut){
    user.attemptsTo(EnterDataForSearchHotel.of(location,checkIn,checkOut),
            ValidatePrice.with(checkIn,checkOut));
    }

    @Then("^she verify the total price is (.*)$")
    public void sheVerifyThePriceInPage(float totalPrice){
       user.should(seeThat(ValidateTotalPrice.is(totalPrice)));


    }

}