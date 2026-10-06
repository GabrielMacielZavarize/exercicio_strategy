package br.venson.net.designpatterns.strategy.frete;

public class FreteVip extends FretePorTipo {

    @Override
    protected double freteBase() {
        return 12.0;
    }
}
