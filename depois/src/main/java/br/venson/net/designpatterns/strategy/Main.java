package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import br.venson.net.designpatterns.strategy.frete.FreteGratis;

public class Main {

    public static void main(String[] args) {
        Pedido comum = new Pedido(TipoCliente.COMUM, 200.0, 2.0, "sul");
        Pedido vip = new Pedido(TipoCliente.VIP, 200.0, 2.0, "sul");
        Pedido corporativo = new Pedido(TipoCliente.CORPORATIVO, 200.0, 2.0, "norte");

        System.out.println("=== Regras padrão por tipo de cliente ===");
        for (Pedido pedido : new Pedido[]{comum, vip, corporativo}) {
            System.out.println(relatorioPara(pedido.getTipoCliente()).formatar(pedido));
        }

        System.out.println();
        System.out.println("=== Troca de estratégia em runtime (cliente comum) ===");
        PerfilCliente perfil = PerfilCliente.para(TipoCliente.COMUM);
        CalculadoraPedido calculadora = CalculadoraPedido.para(perfil);
        RelatorioPedido relatorio = new RelatorioPedido(calculadora, perfil.formatacao());

        calculadora.setEstrategiaDesconto(new DescontoPromocional(30));
        calculadora.setEstrategiaFrete(new FreteGratis());
        System.out.println("Black Friday (30% + frete grátis): " + relatorio.formatar(comum));

        calculadora.setEstrategiaDesconto(perfil.desconto());
        calculadora.setEstrategiaFrete(perfil.frete());
        System.out.println("Fim da promoção (regra padrão):    " + relatorio.formatar(comum));
    }

    private static RelatorioPedido relatorioPara(TipoCliente tipo) {
        PerfilCliente perfil = PerfilCliente.para(tipo);
        return new RelatorioPedido(CalculadoraPedido.para(perfil), perfil.formatacao());
    }
}
