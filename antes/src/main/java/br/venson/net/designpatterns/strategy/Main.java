package br.venson.net.designpatterns.strategy;

public class Main {

    public static void main(String[] args) {
        RelatorioPedido relatorio = new RelatorioPedido();

        Pedido[] pedidos = {
                new Pedido(new Cliente("Ana", TipoCliente.COMUM), 200.0, 3.0),
                new Pedido(new Cliente("Bruno", TipoCliente.VIP), 500.0, 5.0),
                new Pedido(new Cliente("Acme Ltda", TipoCliente.CORPORATIVO), 1500.0, 40.0)
        };

        for (Pedido pedido : pedidos) {
            System.out.println(relatorio.gerar(pedido));
        }
    }
}
