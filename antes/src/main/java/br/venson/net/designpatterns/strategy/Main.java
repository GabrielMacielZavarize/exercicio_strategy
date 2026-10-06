package br.venson.net.designpatterns.strategy;

public class Main {

    public static void main(String[] args) {
        RelatorioPedido relatorio = new RelatorioPedido();

        Pedido comum = new Pedido(TipoCliente.COMUM, 200.0, 2.0, "sul");
        Pedido vip = new Pedido(TipoCliente.VIP, 200.0, 2.0, "sul");
        Pedido corporativo = new Pedido(TipoCliente.CORPORATIVO, 200.0, 2.0, "norte");

        System.out.println(relatorio.formatar(comum));
        System.out.println(relatorio.formatar(vip));
        System.out.println(relatorio.formatar(corporativo));

        // Tente responder: o que muda aqui ao adicionar um novo TipoCliente?
        // Quantas classes precisam ser editadas? Dá para trocar a regra em runtime?
    }
}
