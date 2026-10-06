package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculadoraPedidoTest {

    private final Pedido pedido = new Pedido(new Cliente("Ana", TipoCliente.COMUM), 200.0, 3.0);

    @Test
    void delegaParaAsEstrategias() {
        // Estratégias falsas via lambda: nenhuma regra real envolvida.
        CalculadoraPedido calculadora = new CalculadoraPedido(p -> 10.0, p -> 5.0);
        assertEquals(195.0, calculadora.total(pedido), 0.001);
    }

    @Test
    void trocaEstrategiaEmRuntime() {
        PerfilCliente perfil = PerfilCliente.para(TipoCliente.COMUM);
        CalculadoraPedido calculadora = CalculadoraPedido.para(perfil);
        assertEquals(221.0, calculadora.total(pedido), 0.001);

        calculadora.setEstrategiaDesconto(new DescontoPromocional(30));
        assertEquals(161.0, calculadora.total(pedido), 0.001);

        calculadora.setEstrategiaDesconto(perfil.desconto());
        assertEquals(221.0, calculadora.total(pedido), 0.001);
    }

    @Test
    void relatorioDependeApenasDasAbstracoes() {
        RelatorioPedido relatorio = new RelatorioPedido(new CalculadoraPedido(p -> 0.0, p -> 0.0), p -> "CABECALHO");
        assertTrue(relatorio.gerar(pedido).startsWith("CABECALHO"));
    }
}
