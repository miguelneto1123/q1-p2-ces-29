package ita.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by miguel on 7/1/17.
 */
public class test1steps {
    private int result;

    @Given("^I have a calculator$")
    public void iHaveACalculator() throws Throwable {
        result = 0;
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void iAddAnd(int arg0, int arg1) throws Throwable {
        result = arg0 + arg1;
    }

    @Then("^the result should be (\\d+)$")
    public void theResultShouldBe(int arg0) throws Throwable {
        assertThat(result, is(arg0));
    }
}
