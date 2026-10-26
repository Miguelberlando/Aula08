package runner;

// Classe runner para executar os testes do Cucumber
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  // Usa o executor do Cucumber
@CucumberOptions(
        features = "src/test/resources/features",  // Local das features
        glue = "steps",  // Pacote com as classes de steps
        plugin = {"pretty", "html:target/cucumber-reports.html"}  // Plugins de relatório
)
public class TestRunner {}  // Runner vazio - configuração via anotações
