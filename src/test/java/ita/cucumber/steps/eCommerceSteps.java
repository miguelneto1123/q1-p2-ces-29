package ita.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ita.DBEntry;
import ita.StoreEngine;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by miguel on 7/1/17.
 */
public class eCommerceSteps {
    private StoreEngine sys;
    private boolean isInDB;
    private String title;

    @Given("^this book database$")
    public void thisBookDatabase(List<DBEntry> entries) throws Throwable {
        sys = new StoreEngine(entries);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String arg0) throws Throwable {
        isInDB = sys.checkStockFor(arg0);
        title = arg0;
    }

    @Then("^I should see it's on stock$")
    public void iShouldSeeItSOnStock() throws Throwable {
        assertThat(isInDB, is(true));
    }

    @Then("^I should see it's not on stock$")
    public void iShouldSeeItSNotOnStock() throws Throwable {
        assertThat(isInDB, is(false));
    }

    @Then("^I should see suggestions$")
    public void iShouldSeeSuggestions() throws Throwable {
        List<String> suggestions = sys.getSuggestions(title);
        assertThat(suggestions.size(), not(0));
    }

    @Then("^I should see no suggestions$")
    public void iShouldSeeNoSuggestions() throws Throwable {
        List<String> suggestions = sys.getSuggestions(title);
        assertThat(suggestions.size(), is(0));
    }

    @Then("^I should get books on this topic$")
    public void iShouldGetBooksOnThisTopic() throws Throwable {
        List<String> suggestions = sys.getSuggestionsForTopic(title);
        assertThat(suggestions.size(), not(0));
    }

    @Then("^I should get no books on this topic$")
    public void iShouldGetNoBooksOnThisTopic() throws Throwable {
        List<String> suggestions = sys.getSuggestionsForTopic(title);
        assertThat(suggestions.size(), is(0));
    }

    @When("^I try to buy \"([^\"]*)\"$")
    public void iTryToBuy(String arg0) throws Throwable {
        title = arg0;
    }

    @Then("^I must be able to buy it$")
    public void iMustBeAbleToBuyIt() throws Throwable {
        assertThat(sys.buyBook(title), is(
                "You just bought \"" + title + "\"."
        ));
    }

    @Then("^Its quantity should now be (\\d+)$")
    public void itsQuantityShouldNowBe(int arg0) throws Throwable {
        assertThat(arg0, is(sys.getStockQuantity(title)));
    }

    @Then("^I must not be able to buy it$")
    public void iMustNotBeAbleToBuyIt() throws Throwable {
        assertThat(sys.buyBook(title), is(
                "Sorry, \"" + title + "\"is not on stock."
        ));
    }

    @Then("^I should see it doesn't exist in the database$")
    public void iShouldSeeItDoesnTExistInTheDatabase() throws Throwable {
        assertThat(sys.buyBook(title), is(
                "We don't have \""+title+"\" on our database."
        ));
    }
}
