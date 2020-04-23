package org.docksidestage.bizfw.basic.buyticket;

// TODO hieu javadocをお願いしますー by jflute (2020/04/23)
public enum TicketType {
    // TODO hieu OneDayの情報も、TicketTypeに入ってたほうが良いですね by jflute (2020/04/23)
    // (クラス名が、PluralDaysTicketType じゃなくて TicketType なので)
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

    // TODO hieu 固定的な定数値を管理しているので、set はできない方が良いと思いました by jflute (2020/04/23)
    // (つまり、TicketType は Immutable であった方が良いと。getだけならImmutableになります)
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
