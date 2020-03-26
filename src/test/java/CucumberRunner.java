import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = { "src/test/" },
        glue = {"ru.appline.autotest.glue"},
        plugin = {"ru.appline.autotest.glue.AllureListener"}

)
public class CucumberRunner {
}

