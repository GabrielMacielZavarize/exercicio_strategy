package br.venson.net.designpatterns.strategy;

public class Pedido {

    private final Cliente cliente;
    private final double valor;
    private final double pesoKg;

    public Pedido(Cliente cliente, double valor, double pesoKg) {
        this.cliente = cliente;
        this.valor = valor;
        this.pesoKg = pesoKg;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public double getPesoKg() {
        return pesoKg;
    }
}
