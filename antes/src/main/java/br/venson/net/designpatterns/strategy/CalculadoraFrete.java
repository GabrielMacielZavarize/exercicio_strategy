package br.venson.net.designpatterns.strategy;

// ANTI-PATTERN: o mesmo switch em TipoCliente, agora para o frete.
public class CalculadoraFrete {

    public double calcular(Pedido pedido) {
        switch (pedido.getCliente().getTipo()) {
            case COMUM:
                return 15.0 + pedido.getPesoKg() * 2.0;
            case VIP:
                return 0.0;
            case CORPORATIVO:
                return 25.0;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }
    }
}
