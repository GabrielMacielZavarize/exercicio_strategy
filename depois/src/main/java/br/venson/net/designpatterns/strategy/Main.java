package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;

public class Main {

    public static void main(String[] args) {
        Pedido[] pedidos = {
                new Pedido(new Cliente("Ana", TipoCliente.COMUM), 200.0, 3.0),
                new Pedido(new Cliente("Bruno", TipoCliente.VIP), 500.0, 5.0),
                new Pedido(new Cliente("Acme Ltda", TipoCliente.CORPORATIVO), 1500.0, 40.0)
        };

        System.out.println("=== Regras padrão por tipo de cliente ===\n");
        for (Pedido pedido : pedidos) {
            PerfilCliente perfil = PerfilCliente.para(pedido.getCliente().getTipo());
            RelatorioPedido relatorio = new RelatorioPedido(CalculadoraPedido.para(perfil), perfil.formatacao());
            System.out.println(relatorio.gerar(pedido));
        }

        System.out.println("=== Troca de estratégia em runtime ===\n");
        Pedido pedidoAna = pedidos[0];
        PerfilCliente perfilAna = PerfilCliente.para(pedidoAna.getCliente().getTipo());
        CalculadoraPedido calculadora = CalculadoraPedido.para(perfilAna);
        RelatorioPedido relatorio = new RelatorioPedido(calculadora, perfilAna.formatacao());

        calculadora.setEstrategiaDesconto(new DescontoPromocional(30));
        System.out.println("Black Friday (30% para todos):");
        System.out.println(relatorio.gerar(pedidoAna));

        calculadora.setEstrategiaDesconto(perfilAna.desconto());
        System.out.println("Fim da promoção (volta à regra padrão):");
        System.out.println(relatorio.gerar(pedidoAna));
    }
}
