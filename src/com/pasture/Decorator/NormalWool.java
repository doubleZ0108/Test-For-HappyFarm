package com.pasture.Decorator;

public class NormalWool implements Wool {
    private int quantity;
    public NormalWool(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getDescription() {
        return String.format("This is %d normal wool ", this.quantity);
    }
}