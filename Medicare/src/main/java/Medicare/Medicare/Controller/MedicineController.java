package Medicare.Medicare.Controller;

import Medicare.Medicare.Entity.Medicine;
import Medicare.Medicare.Services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/search")
    public ModelAndView searchMedicine(@RequestParam(name = "query") String query){
        // Logic to search for medicines based on the query
        // Call the service method to fetch medicines from the database

        List<Medicine> medicines = medicineService.searchMedicines(query);
        ModelAndView modelAndView = new ModelAndView("searchResults");
        modelAndView.addObject("medicines", medicines);
        modelAndView.addObject("query", query);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine != null) {
            return ResponseEntity.ok(medicine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        if (medicineService.getMedicineById(id) != null) {
            //medicine.setId(id);
            medicineService.updateMedicine(medicine);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        if (medicineService.getMedicineById(id) != null) {
            medicineService.deleteMedicine(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

