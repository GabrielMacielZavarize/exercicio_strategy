package br.venson.net.designpatterns.strategy;

public class RelatorioPedido {

    public String formatar(Pedido pedido) {
        String etiqueta;
        switch (pedido.getTipoCliente()) {
            case COMUM:
                etiqueta = "Cliente comum";
                break;
            case VIP:
                etiqueta = "Cliente VIP (10% de desconto)";
                break;
            case CORPORATIVO:
                etiqueta = "Cliente corporativo (20% de desconto)";
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }

        CalculadoraDesconto desconto = new CalculadoraDesconto();
        CalculadoraFrete frete = new CalculadoraFrete();

        double valorDesconto = desconto.calcular(pedido);
        double valorFrete = frete.calcular(pedido);
        double total = pedido.getValor() - valorDesconto + valorFrete;

        return String.format(
                "%s | valor: %.2f | desconto: %.2f | frete: %.2f | total: %.2f",
                etiqueta, pedido.getValor(), valorDesconto, valorFrete, total);
    }
}
