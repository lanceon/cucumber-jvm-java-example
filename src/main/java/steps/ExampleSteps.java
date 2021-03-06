package steps;

import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TestContext;

public class ExampleSteps implements En {
    private static final Logger log = LoggerFactory.getLogger(ExampleSteps.class);
    TestContext testContext;

    @Inject
    public ExampleSteps(TestContext testContext) {
        this.testContext = testContext;
        configureSteps();
    }

    private void configureSteps() {
        Before((Scenario scenario) -> {
            log.info("Before scenario : " + scenario.getName());
        });

        After((Scenario scenario) -> {
            log.info("After scenario : " + scenario.getName());
        });

        Given("^this pre condition$", () -> {
            testContext.put("some-key", "some-value");
        });

        When("^I do this$", () -> {
        });

        When("^I do that$", () -> {
        });

        Then("^I can verify that$", () -> {
            assert (testContext.get("some-key").get().equals("some-value"));
        });

        Then("^I can also verify that$", () -> {
        });

    }

}
