package com.exemplo.projeto; // Mantenha o package original do seu arquivo

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
        } else if ("NOVO".equalsIgnoreCase(tipoCliente)) {
            desconto = valorCompra * 0.05;
        } else {
            desconto = valorCompra * 0.02;
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

        if ("SUL".equalsIgnoreCase(regiao) && valorCompra >= 150.0) {
            return true;
        }

        return false;
    }

    public double calcularImposto(double valor, String categoria) {
        if (valor <= 0) {
            return 0.0;
        }

        if ("ELETRONICOS".equalsIgnoreCase(categoria)) {
            return valor * 0.18;
        } else if ("LIVROS".equalsIgnoreCase(categoria)) {
            return 0.0;
        } else if ("ALIMENTOS".equalsIgnoreCase(categoria)) {
            return valor * 0.07;
        }

        return valor * 0.12;
    }
    public void testarErro() {
        String texto = null;
        System.out.println(texto.length());
    }

}

