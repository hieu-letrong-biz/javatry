package org.docksidestage.bizfw.basic.buyticket;

public class QuantityType {
    private int stock;

    public QuantityType(int stock) {
        this.stock = stock;
    }

    public void decreaseStock() {
        --this.stock;
    }

    public int getStock() {
        return stock;
    }
}
