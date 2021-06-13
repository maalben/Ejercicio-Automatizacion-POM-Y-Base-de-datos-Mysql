package co.com.example.runners;

import co.com.example.utilitiesExcel.BeforeSuite;
import co.com.example.utilitiesExcel.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

//@RunWith(CucumberWithSerenity.class)
@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/registro.feature",
        glue = "co.com.example.definitions",
        snippets = SnippetType.UNDERSCORE
)

public class RunnerTags {
    @BeforeSuite
    public static void test() throws IOException, InvalidFormatException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/registro.feature");
    }
}
