package main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {

    ProductFactory productFactory = new ProductFactory();
    private Map<Product, Integer> items ;
    private BigDecimal totalCartValue ;

    public ShoppingCartService() {

        this.items = new HashMap<>();
    }

    public void addProductsToCart(String itemName) throws IllegalArgumentException{

        Product product = productFactory.getProduct(itemName);
        int count = items.getOrDefault(product, 0);
        items.put(product, ++count);
        calculateTotalOfProducts();
    }

    public Integer getProductQuantity(String itemName) throws IllegalArgumentException{
        Product product = productFactory.getProduct(itemName);
        return items.get(product);
    }

    private BigDecimal calculateTotalOfProducts(){

        totalCartValue = items.entrySet().stream().map(entry -> entry.getKey().calculatePrice(entry.getValue()))
                .reduce((a, b) -> a.add(b)).orElse(BigDecimal.ZERO);

        return totalCartValue ;
    }

    public BigDecimal getTotalCartValue(){
        return this.totalCartValue;
    }
}
