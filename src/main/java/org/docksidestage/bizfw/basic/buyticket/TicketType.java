package org.docksidestage.bizfw.basic.buyticket;

public enum TicketType {
    TwoDayTicket("TwoDayTicket",13200,2),
    ThreeDayTicket("ThreeDayTicket",18000,3),
    FourDayTicket("FourDayTicket",22400,4),
    FiveDayTicket("FiveDayTicket",26000,5);

    private String type;
    private int price;
    private int remainDays;

    TicketType(String type, int price, int remainDays) {
        this.type = type;
        this.price = price;
        this.remainDays = remainDays;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getRemainDays() {
        return remainDays;
    }
    public void setRemainDays(int remainDays) {
        this.remainDays = remainDays;
    }
}
