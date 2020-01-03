package main;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductFactory {

    public Product getProduct(String sku){

        Product product = null ;
        switch(sku){
            //This will be read at runtime and offer datastore
            case "A":
                product = new Product("A", BigDecimal.valueOf(50),
                        Optional.of(new MultiBuyOffer(3, BigDecimal.valueOf(130))));
                break;
            case "B":
                product = new Product("B", BigDecimal.valueOf(30),
                        Optional.of(new MultiBuyOffer(2, BigDecimal.valueOf(45))));
                break;

            case "C":
                product = new Product("C", BigDecimal.valueOf(20));
                break;
            default:
                throw new IllegalArgumentException("Invalid SKU code");

        }
        return product;
    }
}
