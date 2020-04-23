package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class PluralDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int TWO_DAY_PRICE = 7400;
    private static final String TYPE = "TwoDayTicket";
    private static int REMAIN_DAYS = 2;
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
    public PluralDayTicket() {
        this.displayPrice = TWO_DAY_PRICE;
        this.type = TYPE;
        this.remainDays = REMAIN_DAYS;
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

    @Override
    public String getType() {
        return type;
    }

    public int getRemainDays() {
        return remainDays;
    }
}
