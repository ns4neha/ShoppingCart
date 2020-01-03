package main;

import java.math.BigDecimal;

public class MultiBuyOffer implements Offer {

    int quantity ;
    BigDecimal multiBuyPrice;

    public MultiBuyOffer(final int quantity, final BigDecimal multiBuyPrice) {
        this.quantity = quantity;
        this.multiBuyPrice = multiBuyPrice;
    }

    @Override
    public BigDecimal calculatePrice(final int quantity, final BigDecimal basePrice) {
        int eligibleMultiBuys = quantity / this.quantity ;
        int remainingQty = quantity - (eligibleMultiBuys *
                 this.quantity);


        return this.multiBuyPrice.multiply(BigDecimal.valueOf(eligibleMultiBuys)).add(
                basePrice.multiply(BigDecimal.valueOf(remainingQty)));

    }
}
