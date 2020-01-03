package main;

import java.math.BigDecimal;

public interface Offer {

    BigDecimal calculatePrice(final int quantity, final BigDecimal basePrice);
}
