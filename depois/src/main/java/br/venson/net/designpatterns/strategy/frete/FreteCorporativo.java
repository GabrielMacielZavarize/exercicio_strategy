package br.venson.net.designpatterns.strategy.frete;

public class FreteCorporativo extends FretePorTipo {

    @Override
    protected double freteBase() {
        return 0.0;
    }
}
