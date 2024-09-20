package entities;

import java.time.LocalDate;

public record Product(String id, String name, double price, int quantity, LocalDate createdDate, LocalDate modifiedDate) {
    public Product {
        if (id == null || name == null || createdDate == null || modifiedDate == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
    }
}
