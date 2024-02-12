package Medicare.Medicare.Services;

import Medicare.Medicare.Entity.Cart;
import Medicare.Medicare.Entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public Cart getCart() {
        return new Cart(cartItems);
    }

    public void clearCart() {
        cartItems.clear();
    }
}
