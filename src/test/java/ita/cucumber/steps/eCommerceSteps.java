package ita.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ita.DBEntry;
import ita.StoreEngine;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by miguel on 7/1/17.
 */
public class eCommerceSteps {
    private StoreEngine sys;
    private boolean isInDB;

    @Given("^this book database$")
    public void thisBookDatabase(List<DBEntry> entries) throws Throwable {
        sys = new StoreEngine(entries);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String arg0) throws Throwable {
        isInDB = sys.checkStockFor(arg0);
    }

    @Then("^I should see it's on stock$")
    public void iShouldSeeItSOnStock() throws Throwable {
        assertThat(isInDB, is(true));
    }

    @Then("^I should see it's not on stock$")
    public void iShouldSeeItSNotOnStock() throws Throwable {
        assertThat(isInDB, is(false));
    }

}
