package org.example;


public class CalculadoraDesconto {

    public double calcularDesconto(double valorCompra, String tipoCliente, boolean cupomAtivo) {
        if (valorCompra <= 0) {
            return 0.0;
        }

        double desconto = 0.0;

        if ("VIP".equalsIgnoreCase(tipoCliente)) {
            desconto = valorCompra * 0.20;
        } else if ("REGULAR".equalsIgnoreCase(tipoCliente)) {
            desconto = valorCompra * 0.10;
        } else {
            desconto = valorCompra * 0.05;
        }

        if (cupomAtivo) {
            desconto += 15.0;
        }

        if (desconto > valorCompra) {
            return valorCompra;
        }

        return desconto;
    }

    public boolean elegivelFreteGratis(double valorCompra, String regiao) {
        if (valorCompra >= 200.0) {
            return true;
        }

        if ("SUDESTE".equalsIgnoreCase(regiao) && valorCompra >= 100.0) {
            return true;
        }

        return false;
    }
}
