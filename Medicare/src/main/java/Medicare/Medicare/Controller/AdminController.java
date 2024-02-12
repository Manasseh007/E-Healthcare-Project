package Medicare.Medicare.Controller;

import Medicare.Medicare.Entity.Medicine;
import Medicare.Medicare.Entity.User;
import Medicare.Medicare.Services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MedicineService medicineService;

    public AdminController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public MedicineService getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/medicine")
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
        return ResponseEntity.ok("Medicine added successfully.");
    }

    @PutMapping("/medicine/{medicineId}")
    public ResponseEntity<?> updateMedicine(@PathVariable long medicineId, @RequestBody Medicine medicine) {
        medicineService.updateMedicine(medicineId, medicine);
        return ResponseEntity.ok("Medicine updated successfully.");
    }

    @DeleteMapping("/medicine/{medicineId}")
    public ResponseEntity<?> deleteMedicine(@PathVariable long medicineId) {
        medicineService.deleteMedicine(medicineId);
        return ResponseEntity.ok("Medicine deleted successfully.");
    }
}

