package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraPedidoTest {

    private final Pedido pedido = new Pedido(TipoCliente.COMUM, 200.0, 2.0, "sul");

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
        assertEquals(231.0, calculadora.total(pedido), 0.001);

        calculadora.setEstrategiaDesconto(new DescontoPromocional(30));
        assertEquals(171.0, calculadora.total(pedido), 0.001);

        calculadora.setEstrategiaDesconto(perfil.desconto());
        assertEquals(231.0, calculadora.total(pedido), 0.001);
    }

    @Test
    void relatorioDependeApenasDasAbstracoes() {
        RelatorioPedido relatorio = new RelatorioPedido(new CalculadoraPedido(p -> 0.0, p -> 0.0), p -> "ETIQUETA");
        assertEquals("ETIQUETA | valor: 200.00 | desconto: 0.00 | frete: 0.00 | total: 200.00",
                relatorio.formatar(pedido).replace(',', '.'));
    }

    @Test
    void mesmoResultadoQueOProjetoOriginal() {
        Pedido corporativo = new Pedido(TipoCliente.CORPORATIVO, 200.0, 2.0, "norte");
        PerfilCliente perfil = PerfilCliente.para(TipoCliente.CORPORATIVO);
        assertEquals(196.0, CalculadoraPedido.para(perfil).total(corporativo), 0.001);
    }
}
