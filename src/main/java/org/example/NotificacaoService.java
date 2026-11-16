package org.example;


import java.util.regex.Pattern;

public class NotificacaoService {

    // Regex simples de email (com um erro proposital: aceita qualquer texto sem @)
    private static final String EMAIL_REGEX = ".*";

    public boolean enviarEmail(String email, String mensagem) {
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Email inválido!");
        }

        // Simula o envio
        System.out.println("Email enviado para: " + email);
        return true;
    }
}
