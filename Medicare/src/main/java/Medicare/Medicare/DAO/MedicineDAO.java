package Medicare.Medicare.DAO;

import Medicare.Medicare.Entity.Medicine;
import Medicare.Medicare.Repository.MedicineRepository;

import java.util.List;

public interface MedicineDAO {
    void AddMedicine(Medicine medicine);

    void addMedicine(Medicine medicine);

    void updateMedicine(long medicineId, Medicine updateMedicine);
    void deleteMedicine(long medicineId);
    List<Medicine> searchMedicines(String keyword);

    // Add more methods are needed
}
