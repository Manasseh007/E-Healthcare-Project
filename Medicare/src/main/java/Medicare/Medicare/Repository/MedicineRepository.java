package Medicare.Medicare.Repository;

import Medicare.Medicare.Entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // Find medicines by name
    List<Medicine> findByName(String name);

    // Find medicines by seller
    List<Medicine> findBySeller(String seller);

    // Find enabled medicines
    List<Medicine> findByIsEnabledTrue();

    // Find disabled medicines
    List<Medicine> findByIsEnabledFalse();

    // Find medicines by name containing a keyword (case-insensitive)
    List<Medicine> findByNameContainingIgnoreCase(String query);

    // Find medicines by price less than the specified value
    List<Medicine> findByPriceLessThan(double price);

    // Find medicines by price greater than the specified value
    List<Medicine> findByPriceGreaterThan(double price);

    // Find medicines by price between the specified range
    List<Medicine> findByPriceBetween(double minPrice, double maxPrice);

    // Find medicines by seller and enabled status
    List<Medicine> findBySellerAndIsEnabledTrue(String seller);

    // Find medicines by seller or enabled status
    List<Medicine> findBySellerOrIsEnabledTrue(String seller);

    // Find medicines by seller and name containing a keyword (case-insensitive)
    List<Medicine> findBySellerAndNameContainingIgnoreCase(String seller, String query);

    // Find medicines by seller or name containing a keyword (case-insensitive)
    List<Medicine> findBySellerOrNameContainingIgnoreCase(String seller, String query);

    // Find medicines by seller and price less than the specified value
    List<Medicine> findBySellerAndPriceLessThan(String seller, double price);

    // Find medicines by seller and price greater than the specified value
    List<Medicine> findBySellerAndPriceGreaterThan(String seller, double price);

    // Find medicines by seller and price between the specified range
    List<Medicine> findBySellerAndPriceBetween(String seller, double minPrice, double maxPrice);

    List<Medicine> findByNameContaining(String query);


}

