package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class PluralDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int TWO_DAY_PRICE = 7400;
    private static final int FOUR_DAY_PRICE = 22400;
    private static int TWO_DAY = 2;
    private static int FOUR_DAY = 4;
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

    @Override
    public String getType() {
        return type;
    }

    public int getRemainDays() {
        return remainDays;
    }
}
