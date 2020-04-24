package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
//NOTE make class for one-day and class for plural days (called implementation class)
public class OneDayTicket implements Ticket {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // done hieu unusedですよー by jflute (2020/04/23)
    private static int ONE_DAY = 1;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // done hieu finalが付けられるインスタンス変数には、できるだけ付けていきましょう by jflute (2020/04/23)
    // done その方が、安全だし、読む方も「この値は、変わらないんだ」と判断が早くなります
    private final int displayPrice = TicketType.OneDayTicket.getPrice();
    private boolean alreadyIn;
    private TicketType ticketType;
    private int remainDays;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public OneDayTicket() {
        ticketType = TicketType.OneDayTicket;
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
    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public int getRemainDays() {
        return remainDays;
    }
}
