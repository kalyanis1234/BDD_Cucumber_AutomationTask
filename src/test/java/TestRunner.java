import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:feature/mars_rovers.feature",
        glue = "MarsRoversStepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner {
    // This class will act as a test runner for executing Cucumber tests.
}
