package Medicare.Medicare.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_detail_id")
    private long itemId;
    private Medicine medicine;
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "medicine_id")
    private long medicineId;
    @Column(name = "quantity")
    private int quantity;

    public CartItem(){

    }

    public CartItem(long itemId, Medicine medicine, int quantity, long orderId, long medicineId) {
        this.itemId = itemId;
        this.medicine = medicine;
        this.orderId = orderId;
        this.medicineId = medicineId;
        this.quantity = quantity;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "itemId=" + itemId +
                ", medicine=" + medicine +
                ", orderId=" + orderId +
                ", medicineId=" + medicineId +
                ", quantity=" + quantity +
                '}';
    }
}
