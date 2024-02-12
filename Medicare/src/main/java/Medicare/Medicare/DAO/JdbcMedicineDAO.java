package Medicare.Medicare.DAO;

import Medicare.Medicare.Entity.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMedicineDAO implements MedicineDAO {

    private String JDBC_URL = "jdbc:mysql://localhost:3306/e_healthcare";
    private static final String JDBC_USERNAME = "springstudent";
    private static final String JDBC_PASSWORD = "springstudent";

    private static final String ADD_MEDICINE_QUERY = "INSERT INTO medicines (name, price, seller, description, enabled) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_MEDICINE_QUERY = "UPDATE medicines SET name=?, price=?, seller=?, description=?, enabled=? WHERE id=?";
    private static final String DELETE_MEDICINE_QUERY = "DELETE FROM medicines WHERE id=?";
    private static final String SEARCH_MEDICINES_QUERY = "SELECT * FROM medicines WHERE name LIKE ?";

    @Override
    public void addMedicine(Medicine medicine) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(ADD_MEDICINE_QUERY)) {
            statement.setString(1, medicine.getName());
            statement.setBigDecimal(2, medicine.getPrice());
            statement.setString(3, medicine.getSeller());
            statement.setString(4, medicine.getDescription());
            statement.setBoolean(5, medicine.isEnabled());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicine(long medicineId, Medicine updatedMedicine) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_MEDICINE_QUERY)) {
            statement.setString(1, updatedMedicine.getName());
            statement.setBigDecimal(2, updatedMedicine.getPrice());
            statement.setString(3, updatedMedicine.getSeller());
            statement.setString(4, updatedMedicine.getDescription());
            statement.setBoolean(5, updatedMedicine.isEnabled());
            statement.setLong(6, medicineId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddMedicine(Medicine medicine) {

    }

    @Override
    public void deleteMedicine(long medicineId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_MEDICINE_QUERY)) {
            statement.setLong(1, medicineId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> searchMedicines(String keyword) {
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SEARCH_MEDICINES_QUERY)) {
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(resultSet.getLong("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getBigDecimal("price"));
                medicine.setSeller(resultSet.getString("seller"));
                medicine.setDescription(resultSet.getString("description"));
                medicine.setEnabled(resultSet.getBoolean("enabled"));
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}

