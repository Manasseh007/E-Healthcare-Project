package Medicare.Medicare.Controller;

import Medicare.Medicare.Entity.*;
import Medicare.Medicare.Services.CartService;
import Medicare.Medicare.Services.PaymentService;
import Medicare.Medicare.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserController medicineService;
    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchMedicines(@RequestParam("keyword") String keyword) {
        List<Medicine> searchResults = (List<Medicine>) medicineService.searchMedicines(keyword);
        return ResponseEntity.ok(searchResults);
    }

    // Add more methods for cart, payment, etc.

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestBody CartItem cartItem) {
        // Add item to user's cart
        cartService.addToCart(cartItem);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getCart() {
        // Get user's cart
        Cart cart = cartService.getCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody PaymentInfo paymentInfo) {
        // Perform payment
        PaymentResult paymentResult = paymentService.processPayment(paymentInfo);
        if (paymentResult.isSuccess()) {
            // Clear user's cart if payment is successful
            cartService.clearCart();
            return ResponseEntity.ok("Payment successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed: " + paymentResult.getMessage());
        }
    }
}

