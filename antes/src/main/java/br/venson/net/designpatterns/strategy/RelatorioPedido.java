package br.venson.net.designpatterns.strategy;

// ANTI-PATTERN: além de repetir o switch para a formatação, o relatório
// instancia as calculadoras concretas (não dá para substituí-las em teste).
public class RelatorioPedido {

    private final CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();
    private final CalculadoraFrete calculadoraFrete = new CalculadoraFrete();

    public String gerar(Pedido pedido) {
        double desconto = calculadoraDesconto.calcular(pedido);
        double frete = calculadoraFrete.calcular(pedido);
        double total = pedido.getValor() - desconto + frete;

        String cabecalho;
        switch (pedido.getCliente().getTipo()) {
            case COMUM:
                cabecalho = "Pedido de " + pedido.getCliente().getNome();
                break;
            case VIP:
                cabecalho = "*** Pedido VIP de " + pedido.getCliente().getNome() + " ***";
                break;
            case CORPORATIVO:
                cabecalho = "[CORPORATIVO] " + pedido.getCliente().getNome().toUpperCase()
                        + " - faturamento em 30 dias";
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }

        return String.format("%s%n  Valor:    R$ %8.2f%n  Desconto: R$ %8.2f%n  Frete:    R$ %8.2f%n  Total:    R$ %8.2f%n",
                cabecalho, pedido.getValor(), desconto, frete, total);
    }
}
