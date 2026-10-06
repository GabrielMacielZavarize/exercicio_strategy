package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoComum;
import br.venson.net.designpatterns.strategy.desconto.DescontoCorporativo;
import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import br.venson.net.designpatterns.strategy.desconto.DescontoVip;
import br.venson.net.designpatterns.strategy.formatacao.FormatacaoVip;
import br.venson.net.designpatterns.strategy.frete.FreteFixo;
import br.venson.net.designpatterns.strategy.frete.FreteGratis;
import br.venson.net.designpatterns.strategy.frete.FretePorPeso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Cada regra é testada isoladamente, sem switch e sem depender das outras. */
class EstrategiasTest {

    private static Pedido pedido(double valor, double peso) {
        return new Pedido(new Cliente("Teste", TipoCliente.COMUM), valor, peso);
    }

    @Test
    void descontos() {
        assertEquals(0.0, new DescontoComum().calcular(pedido(200, 1)), 0.001);
        assertEquals(50.0, new DescontoVip().calcular(pedido(500, 1)), 0.001);
        assertEquals(225.0, new DescontoCorporativo().calcular(pedido(1500, 1)), 0.001);
        assertEquals(25.0, new DescontoCorporativo().calcular(pedido(500, 1)), 0.001);
        assertEquals(60.0, new DescontoPromocional(30).calcular(pedido(200, 1)), 0.001);
    }

    @Test
    void descontoPromocionalRejeitaPercentualInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new DescontoPromocional(150));
    }

    @Test
    void fretes() {
        assertEquals(21.0, new FretePorPeso().calcular(pedido(200, 3)), 0.001);
        assertEquals(0.0, new FreteGratis().calcular(pedido(200, 3)), 0.001);
        assertEquals(25.0, new FreteFixo(25).calcular(pedido(200, 40)), 0.001);
    }

    @Test
    void formatacao() {
        assertEquals("*** Pedido VIP de Teste ***", new FormatacaoVip().cabecalho(pedido(1, 1)));
    }
}
