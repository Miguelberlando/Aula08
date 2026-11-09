package runner;


import org.example.NotificacaoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificacaoServiceTest {

    @Test
    public void testeEmailInvalido() {
        NotificacaoService service = new NotificacaoService();

        // Isso deveria lançar erro, mas vai passar direto por causa do bug no Regex!
        assertThrows(IllegalArgumentException.class, () -> {
            service.enviarEmail("email_invalido_sem_arroba", "Olá");
        });
    }
}
