package br.venson.net.designpatterns.strategy.frete;

public class FreteComum extends FretePorTipo {

    @Override
    protected double freteBase() {
        return 25.0;
    }
}
