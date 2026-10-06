package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoComum;
import br.venson.net.designpatterns.strategy.desconto.DescontoCorporativo;
import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import br.venson.net.designpatterns.strategy.desconto.DescontoVip;
import br.venson.net.designpatterns.strategy.formatacao.FormatacaoVip;
import br.venson.net.designpatterns.strategy.frete.FreteComum;
import br.venson.net.designpatterns.strategy.frete.FreteCorporativo;
import br.venson.net.designpatterns.strategy.frete.FreteGratis;
import br.venson.net.designpatterns.strategy.frete.FreteVip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Cada regra é testada isoladamente, sem switch e sem depender das outras. */
class EstrategiasTest {

    private static Pedido pedido(double valor, double peso, String regiao) {
        // O tipo do pedido é irrelevante aqui: a estratégia é escolhida pelo teste.
        return new Pedido(TipoCliente.COMUM, valor, peso, regiao);
    }

    @Test
    void descontos() {
        assertEquals(0.0, new DescontoComum().calcular(pedido(200, 2, "sul")), 0.001);
        assertEquals(20.0, new DescontoVip().calcular(pedido(200, 2, "sul")), 0.001);
        assertEquals(40.0, new DescontoCorporativo().calcular(pedido(200, 2, "sul")), 0.001);
        assertEquals(60.0, new DescontoPromocional(30).calcular(pedido(200, 2, "sul")), 0.001);
    }

    @Test
    void descontoPromocionalRejeitaPercentualInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new DescontoPromocional(150));
    }

    @Test
    void fretesSomamBasePesoERegiao() {
        assertEquals(31.0, new FreteComum().calcular(pedido(200, 2, "sul")), 0.001);
        assertEquals(18.0, new FreteVip().calcular(pedido(200, 2, "sul")), 0.001);
        assertEquals(36.0, new FreteCorporativo().calcular(pedido(200, 2, "norte")), 0.001);
        assertEquals(36.0, new FreteCorporativo().calcular(pedido(200, 2, "NORTE")), 0.001);
        assertEquals(0.0, new FreteGratis().calcular(pedido(200, 2, "norte")), 0.001);
    }

    @Test
    void formatacao() {
        assertEquals("Cliente VIP (10% de desconto)", new FormatacaoVip().etiqueta(pedido(1, 1, "sul")));
    }
}
