package Medicare.Medicare.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private long medicineId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "seller")
    private String seller;
    @Column(name = "description")
    private String description;
    @Column(name = "is_enabled")
    private boolean isEnabled;

    public Medicine() {
    }

    public Medicine(long medicineId, String name, BigDecimal price, String seller, String description, boolean isEnabled) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.description = description;
        this.isEnabled = isEnabled;
    }

    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setId(long medicineId) {}

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", description='" + description + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
