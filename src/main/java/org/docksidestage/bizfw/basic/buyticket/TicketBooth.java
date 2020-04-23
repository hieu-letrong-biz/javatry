/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author Hieu Le Trong (ヒエウ)
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    // done hieu unusedの警告が出ています (たぶん、途中から要らなくなったんだと思いますが^^) by jflute (2020/04/23)
    // 　IntellIJのProblems表示している機能を見つけません、、＞”＜
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        doBuyPassport(handedMoney, ONE_DAY_PRICE, 1);

        int change = handedMoney - ONE_DAY_PRICE;
        Ticket ticket = new OneDayTicket();
        // TODO hieu 細かいですが、直接 return しちゃってOKですよ by jflute (2020/04/23)
        //  e.g. return new TicketBuyResult(ticket, change);
        TicketBuyResult ticketBuyResult = new TicketBuyResult(ticket, change);
        return ticketBuyResult;
    }

    public TicketBuyResult buyPluralDayPassport(int handedMoney, int numberOfDay) {
        Ticket ticket = new PluralDayTicket(numberOfDay);
        int change = handedMoney - ticket.getDisplayPrice();
        TicketBuyResult ticketBuyResult = new TicketBuyResult(ticket, change);
        // done hieu [質問]引数のquantityが1固定ですが、これは何か意味がありますか？ by jflute (2020/04/23)
        //  最初から誤解したので、1DayPassportは固定1になるし、2DayPassportは固定が2になるという状態です。
        //  消したほうがいいでしょうか？教えてもらえると幸いです！
        // TODO hieu [返事]なるほど。checkQuantity()などで判定基準値として使われているようなので... by jflute (2020/04/23)
        //  e.g. doBuyPassport(handedMoney, ticket.getDisplayPrice(), numberOfDay);
        // というように、numberOfDay をそのまま指定すると良いんじゃないかと思いました。
        doBuyPassport(handedMoney, ticket.getDisplayPrice(), 1);
        return ticketBuyResult;
    }

    // done hieu Slackのtipsスレッドで書きましたが、doBuyPassport() にしてみましょう by jflute (2020/04/23)
    // IntelliJ の Rename 機能を使うと良いです
    // オススメありがとうございます〜！
    private void doBuyPassport(int handedMoney, int price, int quantity) {
        // done hieu [いいね] 意味のある単位で綺麗にprivateメソッドに切り出されていてGoodです！ by jflute (2020/04/23)
        checkQuantity(quantity);
        handleQuantity(handedMoney, price, quantity);
        updateSalesProceeds(price);
    }

    private void checkQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void handleQuantity(int handedMoney, int price, int quantity) {
        if (handedMoney >= price) {
            this.quantity -= quantity;
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    private void updateSalesProceeds(int price) {
        if (this.salesProceeds != null) {
            this.salesProceeds = this.salesProceeds + price;
        } else {
            this.salesProceeds = price;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
