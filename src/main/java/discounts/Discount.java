package discounts;

import entities.Product;

public interface Discount {
    boolean isApplicable(Product product);
    double apply(Product product);
    String getDescription(Product product);
}