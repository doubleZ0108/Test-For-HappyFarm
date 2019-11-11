package com.pasture.Decorator;

public class GreenWoolDecorator extends WoolDecorator {
    public GreenWoolDecorator(Wool decoratedWool) {
        super(decoratedWool);
    }

    @Override
    public String getDescription() {
        return decoratedWool.getDescription() + "\n____And it has been set to green now.";
    }
}