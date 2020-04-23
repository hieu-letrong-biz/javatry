package org.docksidestage.bizfw.basic.buyticket;

// done hieu javadocをお願いしますー by jflute (2020/04/23)
// Q: クラスなら、どんな情報をjavadocに書いた方がいいでしょうか？調べてよくわかんないので、教えてもらえると幸いです！
// done hieu [返事] まずは、タイトル・概要 (overview) ですね。例えば... by jflute (2020/04/23)
//
// /**
//  * チケットの種類 (1Dayパスワード、2Dayパスワードなど)
//  * @author hieu.letrong
//  */
//
// あとは、ソースコードを読む人に対して、何か伝えておいたほうが良い特記事項があれば、それを書くと良いです。
// このくらい小さなクラスであれば、あまり特記事項はないかもしれませんが。

/**
 * TickeType
 * For defining Ticket's type
 * @author hieu.letrong (2020/04/23)
 */
public enum TicketType {
    // done hieu OneDayの情報も、TicketTypeに入ってたほうが良いですね by jflute (2020/04/23)
    // (クラス名が、PluralDaysTicketType じゃなくて TicketType なので)
    OneDayTicket("OneDayTicket",7400,1),
    TwoDayTicket("TwoDayTicket",13200,2),
    ThreeDayTicket("ThreeDayTicket",18000,3),
    FourDayTicket("FourDayTicket",22400,4),
    FiveDayTicket("FiveDayTicket",26000,5);

    // done hieu ここも final を付けてしまいましょう (Immutableに) by jflute (2020/04/23)
    private final String type;
    private final int price;
    private final int remainDays;

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
