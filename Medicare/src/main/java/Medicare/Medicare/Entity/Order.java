package Medicare.Medicare.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long orderId;
    @Id
    @Column(name = "user_id")
    private long userId;
    private List<Medicine> medicines;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "is_payment_complete")
    private boolean isPaymentComplete;

    public Order() {

    }

    public Order(long orderId, long userId, List<Medicine> medicines, BigDecimal totalAmount, boolean isPaymentComplete) {
        this.orderId = orderId;
        this.userId = userId;
        this.medicines = medicines;
        this.totalAmount = totalAmount;
        this.isPaymentComplete = isPaymentComplete;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaymentComplete() {
        return isPaymentComplete;
    }

    public void setPaymentComplete(boolean paymentComplete) {
        isPaymentComplete = paymentComplete;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", medicines=" + medicines +
                ", totalAmount=" + totalAmount +
                ", isPaymentComplete=" + isPaymentComplete +
                '}';
    }
}
