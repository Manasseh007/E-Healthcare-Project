package Medicare.Medicare.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // return the name of the HTML file
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";  // return registration HTML page file
    }

    @GetMapping("/search")
    public String showSearch() {
        return "search";
    }
    @GetMapping("/showMedicine")
    public String displayMedicine() {
        return "display";
    }

    @GetMapping("/Cart")
    public String showCart() {
        return "cart";
    }

    @GetMapping("/paymentForm")
    public String paymentForm() {
        return "payment-form";
    }
}
