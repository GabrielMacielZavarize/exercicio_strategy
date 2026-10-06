package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.DescontoComum;
import br.venson.net.designpatterns.strategy.desconto.DescontoCorporativo;
import br.venson.net.designpatterns.strategy.desconto.DescontoVip;
import br.venson.net.designpatterns.strategy.desconto.EstrategiaDesconto;
import br.venson.net.designpatterns.strategy.formatacao.EstrategiaFormatacao;
import br.venson.net.designpatterns.strategy.formatacao.FormatacaoComum;
import br.venson.net.designpatterns.strategy.formatacao.FormatacaoCorporativa;
import br.venson.net.designpatterns.strategy.formatacao.FormatacaoVip;
import br.venson.net.designpatterns.strategy.frete.EstrategiaFrete;
import br.venson.net.designpatterns.strategy.frete.FreteFixo;
import br.venson.net.designpatterns.strategy.frete.FreteGratis;
import br.venson.net.designpatterns.strategy.frete.FretePorPeso;

/**
 * Agrupa as estratégias padrão de um tipo de cliente. É o ÚNICO ponto do sistema
 * que conhece o mapeamento TipoCliente -> comportamento.
 */
public record PerfilCliente(EstrategiaDesconto desconto,
                            EstrategiaFrete frete,
                            EstrategiaFormatacao formatacao) {

    public static PerfilCliente para(TipoCliente tipo) {
        return switch (tipo) {
            case COMUM -> new PerfilCliente(new DescontoComum(), new FretePorPeso(), new FormatacaoComum());
            case VIP -> new PerfilCliente(new DescontoVip(), new FreteGratis(), new FormatacaoVip());
            case CORPORATIVO -> new PerfilCliente(new DescontoCorporativo(), new FreteFixo(25.0), new FormatacaoCorporativa());
        };
    }
}
