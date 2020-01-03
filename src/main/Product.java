package main;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Product {

    private String sku ;

    public Product(final String sku, final BigDecimal price) {
        this.sku = sku;
        this.price = price;
    }

    private BigDecimal price ;

    public Product(final String sku, final BigDecimal price, final Optional<Offer> offer) {
        this.sku = sku;
        this.price = price;
        this.offer = offer;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Optional<Offer> getOffer() {
        return offer;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Product product = (Product) o;
        return Objects.equals(getSku(), product.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku());
    }

    private Optional<Offer> offer;

    public BigDecimal calculatePrice(int quantity){

        if(offer.isPresent()){
            return offer.get().calculatePrice(quantity, price);
        }
        else {
            return price.multiply(BigDecimal.valueOf(quantity));
        }

    }
}
