-- Create database
CREATE DATABASE e_healthcare;

-- Use the database
USE e_healthcare;

-- Create the users table
CREATE TABLE users (
    user_id long AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the medicines table
CREATE TABLE medicines (
    medicine_id long AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    seller VARCHAR(255) NOT NULL,
    description TEXT,
    is_enabled BOOLEAN NOT NULL DEFAULT true
);

-- Create the orders table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id long,
    total_amount DECIMAL(10, 2) NOT NULL,
    is_payment_complete BOOLEAN NOT NULL DEFAULT false,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Create the order_details table
CREATE TABLE order_details (
    order_detail_id long AUTO_INCREMENT PRIMARY KEY,
    order_id long,
    medicine_id long,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (medicine_id) REFERENCES medicines(medicine_id)
);

-- Sample data for testing purposes
INSERT INTO users (username, password) VALUES ('user1', 'password1'), ('user2', 'password2');

INSERT INTO medicines (name, price, seller, description) VALUES
('Paracetamol', 5.99, 'ABC Pharmacy', 'For fever and pain relief'),
('Amoxicillin', 10.50, 'XYZ Pharmacy', 'Antibiotic for bacterial infections'),
('Ibuprofen', 7.49, 'DEF Pharmacy', 'For pain relief and inflammation');
('Paracetamol', 5.99, 'ABC Pharmacy', 'For fever and pain relief'),
('Amoxicillin', 10.50, 'XYZ Pharmacy', 'Antibiotic for bacterial infections'),
('Ibuprofen', 7.49, 'DEF Pharmacy', 'For pain relief and inflammation');
('Paracetamol', 5.99, 'ABC Pharmacy', 'For fever and pain relief'),
('Amoxicillin', 10.50, 'XYZ Pharmacy', 'Antibiotic for bacterial infections'),
('Ibuprofen', 7.49, 'DEF Pharmacy', 'For pain relief and inflammation');

