package Medicare.Medicare.Entity;

import java.util.List;

public class Cart {
    private List<CartItem> items;

    // Constructor, getter, and setter
    public Cart(){}
    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
