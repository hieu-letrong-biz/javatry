package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class PluralDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // TODO hieu TWO_DAY なのに7400円？ (TicketBoothのONE_DAYの値段と同じになっている) by jflute (2020/04/23)
    private static final int TWO_DAY_PRICE = 7400;
    private static final int FOUR_DAY_PRICE = 22400;
    private static int TWO_DAY = 2;
    private static int FOUR_DAY = 4;
    
    // TODO hieu [Challenge] ENUMの中に、上の定数値を持つようにして、TwoDayの情報、FourDayの情報をまとめよう by jflute (2020/04/23)
    // (enumはコンストラクタで受け取った値をインスタンス変数(属性)として保持することができます)
    // https://github.com/lastaflute/lastaflute-example-harbor/blob/master/src/main/java/org/docksidestage/mylasta/appcls/AppCDef.java#L38
    private static enum TYPE {
        TwoDayTicket,FourDayTicket
    }
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int displayPrice;
    private boolean alreadyIn;
    private String type;
    private int remainDays;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public PluralDayTicket(int numberOfDay) {
        // TODO hieu Unsupported な numberOfDay (e.g. 3, 5) が来たときの対応があると良いです by jflute (2020/04/23)
        if (numberOfDay == FOUR_DAY) {
            this.displayPrice = FOUR_DAY_PRICE;
            this.type = String.valueOf(TYPE.FourDayTicket);
            this.remainDays = FOUR_DAY;
        }
        else if (numberOfDay == TWO_DAY) {
            this.displayPrice = TWO_DAY_PRICE;
            this.type = String.valueOf(TYPE.TwoDayTicket);
            this.remainDays = TWO_DAY;
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

    // TODO hieu 文字列じゃなくても良いです (enum型をそのまま戻すでもOKです) by jflute (2020/04/23)
    // 使う側のプログラムからしたら、文字列よりも、type-safeなenum型の方が嬉しいです
    @Override
    public String getType() {
        return type;
    }

    public int getRemainDays() {
        return remainDays;
    }
}
