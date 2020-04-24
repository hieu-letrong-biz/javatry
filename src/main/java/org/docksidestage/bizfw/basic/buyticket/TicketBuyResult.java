package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Hieu Le Trong (ヒエウ)
 */
public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private Ticket ticket;
    private int change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(Ticket ticket, int change) {
        this.ticket = ticket;
        this.change = change;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // done hieu ここも、Resultを書き換える必要があることはほとんどないと思うので、setは無しでもいいかなと by jflute (2020/04/23)
    public Ticket getTicket() {
        return this.ticket;
    }
    public int getChange() {
        return this.change;
    }
}
