package org.docksidestage.bizfw.basic.buyticket;

// TODO hieu javadoc忘れずに〜 by jflute (2020/04/23)
// TODO hieu QuantityType の Type ですが、Typeと付けると種類・種別を表す「定義」的なクラスの印象を受けます by jflute (2020/04/23)
// でも、stockの実際値を保持してMutableなクラスなので少し違和感があります。Quantityクラスで良いかなとは思います。
// さあ、ここでも、IntelliJ の Rename 機能を使うと良いですよ（＾＾
public class QuantityType {
    private int stock;

    public QuantityType(int stock) {
        this.stock = stock;
    }

    public void decreaseStock() {
        --this.stock;
    }

    public int getStock() {
        return stock;
    }
}
