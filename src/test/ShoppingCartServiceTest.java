package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import main.ShoppingCartService;
import org.junit.Test;

public class ShoppingCartServiceTest {


    ShoppingCartService shoppingCartService = new ShoppingCartService();

    @Test
    public void testToAddItemsToShoppingCart(){

        String itemNames[] = {"A", "A", "B", "A"};
        for(String itemName : itemNames){
            shoppingCartService.addProductsToCart(itemName);
        }
        assertThat(shoppingCartService.getProductQuantity("A"), is(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShoppingCartShouldReturnExceptionForInvalidItem(){

        String itemName = "D";
        shoppingCartService.addProductsToCart(itemName);
    }

    @Test
    public void calculateBasketTotal(){

        String itemNames[] = {"A", "A", "B", "A"};
        for(String itemName : itemNames){
            shoppingCartService.addProductsToCart(itemName);
        }
        BigDecimal total = shoppingCartService.getTotalCartValue();
        assertThat(total, is(BigDecimal.valueOf(180)));
    }

    @Test
    public void testShoppingBasketForMultipricedItemsShouldReturnAppropriateTotal(){

        String itemNames[] = {"A", "A", "B", "A"};
        for(String itemName : itemNames){
            shoppingCartService.addProductsToCart(itemName);
        }

        assertThat(shoppingCartService.getProductQuantity("A"), is(3));
        assertThat(shoppingCartService.getProductQuantity("B"), is(1));
        assertThat(shoppingCartService.getTotalCartValue(), is(BigDecimal.valueOf(160)));
    }

    @Test
    public void testIfMoreThanOneItemIsEligibleForMultiprice(){
        String itemNames[] = {"A", "A", "B", "A", "A", "B", "A", "A", "A", "B"};
        for(String itemName : itemNames){
            shoppingCartService.addProductsToCart(itemName);
        }
        assertThat(shoppingCartService.getProductQuantity("A"), is(7));
        assertThat(shoppingCartService.getProductQuantity("B"), is(3));
        assertThat(shoppingCartService.getTotalCartValue(), is(BigDecimal.valueOf(385)));

    }

    @Test
    public void testShoppingCartForValidAndInvalidItems(){

        String itemNames[] = {"A", "A", "B", "A", "E"};

        for(String itemName : itemNames){

            try{
                shoppingCartService.addProductsToCart(itemName);
            }catch (IllegalArgumentException e){

            }
        }

        assertThat(shoppingCartService.getProductQuantity(itemNames[0]), is(3));

    }
}
