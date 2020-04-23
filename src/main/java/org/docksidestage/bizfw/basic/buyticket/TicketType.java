package org.docksidestage.bizfw.basic.buyticket;

// TODO hieu javadocをお願いしますー by jflute (2020/04/23)
// Q: クラスなら、どんな情報をjavadocに書いた方がいいでしょうか？調べてよくわかんないので、教えてもらえると幸いです！

/**
 * @author hieu.letrong
 * @class TicketType
 */
public enum TicketType {
    // done hieu OneDayの情報も、TicketTypeに入ってたほうが良いですね by jflute (2020/04/23)
    // (クラス名が、PluralDaysTicketType じゃなくて TicketType なので)
    OneDayTicket("OneDayTicket",7400,1),
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

    // done hieu 固定的な定数値を管理しているので、set はできない方が良いと思いました by jflute (2020/04/23)
    // (つまり、TicketType は Immutable であった方が良いと。getだけならImmutableになります)
    public String getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }
    public int getRemainDays() {
        return remainDays;
    }
}
