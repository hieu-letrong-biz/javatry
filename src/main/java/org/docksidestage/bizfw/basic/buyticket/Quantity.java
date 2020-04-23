package org.docksidestage.bizfw.basic.buyticket;

// done hieu javadoc忘れずに〜 by jflute (2020/04/23)
// done hieu QuantityType の Type ですが、Typeと付けると種類・種別を表す「定義」的なクラスの印象を受けます by jflute (2020/04/23)
// でも、stockの実際値を保持してMutableなクラスなので少し違和感があります。Quantityクラスで良いかなとは思います。
// さあ、ここでも、IntelliJ の Rename 機能を使うと良いですよ（＾＾
/**
 * Quantity
 * For defining & handling ticket's quantity remaining
 * @author hieu.letrong (2020/04/23)
 */
public class Quantity {
    private int value;

    public Quantity(int value) {
        this.value = value;
    }

    public void decreaseValue() {
        --this.value;
    }

    public int getValue() {
        return value;
    }
}
