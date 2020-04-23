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
    private QuantityType oneDayQuantity = new QuantityType(MAX_QUANTITY);
    private QuantityType twoDayQuantity = new QuantityType(MAX_QUANTITY);
    private QuantityType threeDayQuantity = new QuantityType(MAX_QUANTITY);
    private QuantityType fourDayQuantity = new QuantityType(MAX_QUANTITY);
    private QuantityType fiveDayQuantity = new QuantityType(MAX_QUANTITY);
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
        // done hieu 細かいですが、直接 return しちゃってOKですよ by jflute (2020/04/23)
        //  e.g. return new TicketBuyResult(ticket, change);

        Ticket ticket = new OneDayTicket();
        doBuyPassport(handedMoney, ticket.getDisplayPrice(), oneDayQuantity);

        int change = handedMoney - ticket.getDisplayPrice();
        return new TicketBuyResult(ticket, change);
    }

    public TicketBuyResult buyPluralDayPassport(int handedMoney, int numberOfDay) {
        // done hieu [質問]引数のquantityが1固定ですが、これは何か意味がありますか？ by jflute (2020/04/23)
        //  最初から誤解したので、1DayPassportは固定1になるし、2DayPassportは固定が2になるという状態です。
        //  消したほうがいいでしょうか？教えてもらえると幸いです！
        // done hieu [返事]なるほど。checkQuantity()などで判定基準値として使われているようなので... by jflute (2020/04/23)
        //  e.g. doBuyPassport(handedMoney, ticket.getDisplayPrice(), numberOfDay);
        // というように、numberOfDay をそのまま指定すると良いんじゃないかと思いました。
        // NOTE HIEU I've fixed some logic

        Ticket ticket = new PluralDayTicket(numberOfDay);
        QuantityType anyDayQuantity = getQuantityType(ticket.getTicketType().name());
        doBuyPassport(handedMoney, ticket.getDisplayPrice(), anyDayQuantity);

        int change = handedMoney - ticket.getDisplayPrice();
        return new TicketBuyResult(ticket, change);
    }

    // done hieu Slackのtipsスレッドで書きましたが、doBuyPassport() にしてみましょう by jflute (2020/04/23)
    // IntelliJ の Rename 機能を使うと良いです
    // オススメありがとうございます〜！
    private void doBuyPassport(int handedMoney, int price, QuantityType quantityType) {
        // done hieu [いいね] 意味のある単位で綺麗にprivateメソッドに切り出されていてGoodです！ by jflute (2020/04/23)
        checkQuantity(quantityType);
        handleQuantity(handedMoney, price, quantityType);
        updateSalesProceeds(price);
    }

    private void checkQuantity(QuantityType quantityType) {
        if (quantityType.getStock() <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void handleQuantity(int handedMoney, int price, QuantityType quantityType) {
        if (handedMoney >= price) {
            quantityType.decreaseStock();
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
    public QuantityType getQuantityType(String ticketType) {
        switch (ticketType) {
        case "ThreeDayTicket":
            return threeDayQuantity;
        case "FourDayTicket":
            return fourDayQuantity;
        case "FiveDayTicket":
            return fiveDayQuantity;
        default:
            return twoDayQuantity;
        }
    }

    public int getQuantity(QuantityType quantityType) {
        return quantityType.getStock();
    }

    //NOTE Overload for previous test: E.g test_class_howToUse_basic
    public int getQuantity() {
        return oneDayQuantity.getStock();
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
