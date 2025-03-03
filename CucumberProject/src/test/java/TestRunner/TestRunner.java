package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Cucumber ile JUnit'i entegre eder.
@CucumberOptions(features = "src/test/resources/Features", // Feature dosyalarının yolu
		glue = { "Hooks", "StepDefinitions" }, // Step Definitions dosyanın olduğu paket
		plugin = { "pretty",  
				"html:target/cucumber-reports.html",  // HTML raporu
		        "json:target/cucumber.json",  // JSON raporu
		        "junit:target/cucumber.xml"   }, //JUnit raporu Raporlama eklentisi
		
		monochrome = true, // Konsolda çıktıyı daha okunaklı hale getirir
		dryRun = false // Eğer true yaparsan eksik step definition'ları bulur ama testleri çalıştırmaz
)

public class TestRunner {

}
