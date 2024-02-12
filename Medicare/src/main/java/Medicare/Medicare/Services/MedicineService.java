package Medicare.Medicare.Services;

import Medicare.Medicare.Entity.Medicine;
import Medicare.Medicare.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MedicineRepository medicineRepository;

    /*
    public List<Medicine> searchMedicines(String query) {
        return medicineRepository.findByNameContaining(query);
    }
    */
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public void updateMedicine(long medicineId, Medicine updatedMedicine) {
        Medicine existingMedicine = medicineRepository.findById(medicineId)
                .orElseThrow();

        // Update existingMedicine with properties of updatedMedicine
        existingMedicine.setName(updatedMedicine.getName());
        existingMedicine.setPrice(updatedMedicine.getPrice());
        existingMedicine.setSeller(updatedMedicine.getSeller());
        existingMedicine.setDescription(updatedMedicine.getDescription());
        existingMedicine.setEnabled(updatedMedicine.isEnabled());
        medicineRepository.save(existingMedicine);
    }

    public void deleteMedicine(long medicineId) {
        medicineRepository.deleteById(medicineId);
    }

    public List<Medicine> searchMedicines(String query) {
        return medicineRepository.findByNameContaining(query);
    }

    // Add more methods for fetching medicines

    // Method to fetch all medicines
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // Method to fetch medicine by ID
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    // Method to fetch medicines by name
    public List<Medicine> getMedicinesByName(String name) {
        return medicineRepository.findByName(name);
    }

    // Method to fetch medicines by seller
    public List<Medicine> getMedicinesBySeller(String seller) {
        return medicineRepository.findBySeller(seller);
    }

    // Method to fetch enabled medicines
    public List<Medicine> getEnabledMedicines() {
        return medicineRepository.findByIsEnabledTrue();
    }

    // Method to fetch disabled medicines
    public List<Medicine> getDisabledMedicines() {
        return medicineRepository.findByIsEnabledFalse();
    }

    public void updateMedicine(Medicine medicine) {
    }

    // Add more methods as needed...
}
