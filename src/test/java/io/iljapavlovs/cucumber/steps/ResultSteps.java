package io.iljapavlovs.cucumber.steps;

import io.cucumber.java.en.Then;
import io.iljapavlovs.cucumber.state.ScenarioState;
import org.junit.jupiter.api.Assertions;

public class ResultSteps {

  private final ScenarioState state;

  public ResultSteps(ScenarioState state) {
    this.state = state;
  }

  @Then("some result will be calculated")
  public void result() {
    Assertions.assertTrue(state.getResult() > 0);
  }

  @Then("no result can be calculated")
  public void noResult() {
    Assertions.assertFalse(state.getResult() > 0);
  }

}
