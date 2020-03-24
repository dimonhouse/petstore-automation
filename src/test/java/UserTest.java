import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", plugin = {"pretty", "html:build/cucumber-report"})
public class UserTest extends AbstractTestNGCucumberTests {
}
