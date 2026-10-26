package org.example;

public class Calculadora {

    public static int somar(int a, int b) {
        return a + b;
    }

    public static int dividir(int a, int b) {
        if (b == 0) {
            // Lança a exceção com a mensagem exata que o seu .feature espera
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return a / b;
    }
}
