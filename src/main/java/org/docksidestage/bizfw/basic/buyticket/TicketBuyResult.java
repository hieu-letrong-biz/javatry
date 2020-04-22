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
        setTicket(ticket);
        setChange(change);
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return this.ticket;
    }
    public int getChange() {
        return this.change;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void setChange(int change) {
        this.change = change;
    }
}
