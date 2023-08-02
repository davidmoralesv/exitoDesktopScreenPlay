package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/seleccionarProductos.feature",
        plugin = {"pretty", "html:target/cucumber-html-report/report.js"},
        glue = "stepdefinitions",
        snippets = CAMELCASE,
        useFileNameCompatibleName = true)
public class SeleccionarProductos {
}

