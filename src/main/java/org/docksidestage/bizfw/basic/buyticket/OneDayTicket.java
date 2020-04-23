package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class OneDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int ONE_DAY_PRICE = 7400;
    private static final String ONE_DAY_TYPE = "OneDayTicket";
    private static int ONE_DAY = 1;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO hieu finalが付けられるインスタンス変数には、できるだけ付けていきましょう by jflute (2020/04/23)
    // その方が、安全だし、読む方も「この値は、変わらないんだ」と判断が早くなります
    private int displayPrice;
    private boolean alreadyIn;
    private String type;
    private int remainDays;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public OneDayTicket() {
        this.displayPrice = ONE_DAY_PRICE;
        this.type = ONE_DAY_TYPE;
        this.remainDays = ONE_DAY;
    }

    // ===================================================================================
    //                                                                         Method
    //                                                                         ===========
    @Override
    public void doInPark() {
        if (alreadyIn || remainDays == 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
        --remainDays;
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

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getRemainDays() {
        return remainDays;
    }
}
