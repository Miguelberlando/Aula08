package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class AutenticacaoSteps {

    private String usuarioCadastrado;
    private String senhaCadastrada;
    private boolean loginSucesso = false;

    @Dado("que o usuário {string} com senha {string} está cadastrado")
    public void que_o_usuário_com_senha_está_cadastrado(String usuario, String senha) {
        this.usuarioCadastrado = usuario;
        this.senhaCadastrada = senha;
    }

    @Quando("eu faço login com {string} e {string}")
    public void eu_faço_login_com_e(String usuario, String senha) {
        this.loginSucesso = usuario.equals(usuarioCadastrado) && senha.equals(senhaCadastrada);
    }

    @Então("o acesso é concedido")
    public void o_acesso_é_concedido() {
        Assert.assertTrue("O acesso deveria ter sido concedido", loginSucesso);
    }

    @Então("o acesso é negado")
    public void o_acesso_é_negado() {
        Assert.assertFalse("O acesso deveria ter sido negado, mas foi concedido!", loginSucesso);
    }
}
