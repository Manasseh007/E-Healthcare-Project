package Medicare.Medicare.Services;

import Medicare.Medicare.Entity.PaymentInfo;
import Medicare.Medicare.Entity.PaymentResult;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentResult processPayment(PaymentInfo paymentInfo) {
        // Dummy implementation for demonstration purposes
        if (paymentInfo.getAmount() <= 0) {
            return new PaymentResult(false, "Invalid payment amount");
        }

        // Perform payment processing logic here
        // For demonstration, assume payment is always successful
        return new PaymentResult(true, "Payment successful");
    }
}
