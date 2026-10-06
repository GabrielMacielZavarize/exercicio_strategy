package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.formatacao.EstrategiaFormatacao;

/**
 * Não conhece TipoCliente nem nenhuma regra concreta: recebe o contexto
 * (que só depende das interfaces de estratégia) e a estratégia de formatação.
 */
public class RelatorioPedido {

    private final CalculadoraPedido calculadora;
    private final EstrategiaFormatacao formatacao;

    public RelatorioPedido(CalculadoraPedido calculadora, EstrategiaFormatacao formatacao) {
        this.calculadora = calculadora;
        this.formatacao = formatacao;
    }

    public String gerar(Pedido pedido) {
        return String.format("%s%n  Valor:    R$ %8.2f%n  Desconto: R$ %8.2f%n  Frete:    R$ %8.2f%n  Total:    R$ %8.2f%n",
                formatacao.cabecalho(pedido),
                pedido.getValor(),
                calculadora.desconto(pedido),
                calculadora.frete(pedido),
                calculadora.total(pedido));
    }
}
