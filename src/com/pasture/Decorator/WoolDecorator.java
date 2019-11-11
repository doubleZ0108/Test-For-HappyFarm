package com.pasture.Decorator;

public abstract class WoolDecorator implements Wool {
    protected Wool decoratedWool;

    public WoolDecorator(Wool decoratedWool) {
        this.decoratedWool = decoratedWool;
    }

    public String getDescription(){
        return decoratedWool.getDescription();
    }
}