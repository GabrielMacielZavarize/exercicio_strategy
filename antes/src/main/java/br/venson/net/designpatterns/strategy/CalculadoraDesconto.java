package br.venson.net.designpatterns.strategy;

// ANTI-PATTERN: a regra de desconto é escolhida por um switch em TipoCliente.
public class CalculadoraDesconto {

    public double calcular(Pedido pedido) {
        switch (pedido.getCliente().getTipo()) {
            case COMUM:
                return 0.0;
            case VIP:
                return pedido.getValor() * 0.10;
            case CORPORATIVO:
                return pedido.getValor() >= 1000 ? pedido.getValor() * 0.15 : pedido.getValor() * 0.05;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }
    }
}
