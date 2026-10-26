package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import org.example.Calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Classe de implementação dos steps (passos) do Gherkin
public class CalculadoraSteps {
    // Variáveis para armazenar estado entre os steps
    private int num1, num2
    private int resultado;
    private Exception exception;

    // Step para definir os números (usa parâmetros do cenário)
    @Dado("que eu tenho os números {int} e {int}")
    public void definir_numeros(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    // Step para executar a soma
    @Quando("eu peço para somar")
    public void somar() {
        this.resultado = Calculadora.somar(num1, num2);
    }

    // Step para verificar o resultado
    @Então("o resultado tem que ser {int}")
    public void verificar_resultado(int esperado) {
        assertEquals(esperado, resultado);  // Asserção JUnit
    }

    // Step para executar a divisão (com tratamento de erro)
    @Quando("eu peço para dividir")
    public void dividir() {
        try {
            this.resultado = Calculadora.dividir(num1, num2);
        } catch (Exception e) {
            this.exception = e;  // Captura a exceção para verificação posterior
        }
    }

    // Step para verificar mensagem de erro
    @Então("o sistema deve informar {string}")
    public void verificar_mensagem(String mensagem) {
        assertNotNull(exception);  // Verifica se houve exceção
        assertEquals(mensagem, exception.getMessage());  // Verifica a mensagem
    }
}
