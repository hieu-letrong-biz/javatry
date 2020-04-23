package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class PluralDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // done hieu TWO_DAY なのに7400円？ (TicketBoothのONE_DAYの値段と同じになっている) by jflute (2020/04/23)
    //  fixed at TicketType file
    // done hieu TWO_DAY が unused warning になっています (デフォルトが 2 だから？) by jflute (2020/04/23)
    // そうなんですね！自分の考えですが、switchを使うことが好きじゃないです、、
    // しばしばプログラムのフローとデータが変更させたということです！
    // 仕方ないので、一旦消します！
    private static final int THREE_DAY = 3;
    private static final int FOUR_DAY = 4;
    private static final int FIVE_DAY = 5;

    // done hieu [Challenge] ENUMの中に、上の定数値を持つようにして、TwoDayの情報、FourDayの情報をまとめよう by jflute (2020/04/23)
    //  fixed at file TicketType.java
    // (enumはコンストラクタで受け取った値をインスタンス変数(属性)として保持することができます)
    // https://github.com/lastaflute/lastaflute-example-harbor/blob/master/src/main/java/org/docksidestage/mylasta/appcls/AppCDef.java#L38

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int displayPrice;
    private boolean alreadyIn;
    private TicketType ticketType;
    private int remainDays;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public PluralDayTicket(int numberOfDay) {
        // done hieu Unsupported な numberOfDay (e.g. 3, 5) が来たときの対応があると良いです by jflute (2020/04/23)
        //  fixed for more flexible code
        this.ticketType = initTicketType(numberOfDay);
        this.displayPrice = ticketType.getPrice();
        this.remainDays = ticketType.getRemainDays();
    }

    public TicketType initTicketType(int numberOfDay) {
        switch (numberOfDay) {
        case THREE_DAY:
            return TicketType.ThreeDayTicket;
        case FOUR_DAY:
            return TicketType.FourDayTicket;
        case FIVE_DAY:
            return TicketType.FiveDayTicket;
        default:
            return TicketType.TwoDayTicket;
        }
    }

    // ===================================================================================
    //                                                                         Method
    //                                                                         ===========
    //NOTE doInPark() of plural days can execute defined times
    @Override
    public void doInPark() {
        if (alreadyIn && remainDays == 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        } else if (alreadyIn && remainDays > 0) {
            --remainDays;
        } else {
            alreadyIn = true;
            --remainDays;
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    public int getDisplayPrice() {
        return displayPrice;
    }

    @Override
    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    // done hieu 文字列じゃなくても良いです (enum型をそのまま戻すでもOKです) by jflute (2020/04/23)
    //  added getter return enum TicketType at line 93-95
    // 使う側のプログラムからしたら、文字列よりも、type-safeなenum型の方が嬉しいです
    // done hieu interfaceに定義するメソッドの方を、TicketType getTicketType() にしてはどうでしょう？ by jflute (2020/04/23)
    @Override
    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public int getRemainDays() {
        return remainDays;
    }
}
