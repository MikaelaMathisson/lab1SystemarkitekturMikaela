package discounts;

import entities.Product;
import java.util.function.BiFunction;

public class GenericDiscount {
    private final BiFunction<Product, GenericDiscount, Double> discountFunction;
    private final BiFunction<Product, GenericDiscount, String> descriptionFunction;

    public GenericDiscount(BiFunction<Product, GenericDiscount, Double> discountFunction,
                           BiFunction<Product, GenericDiscount, String> descriptionFunction) {
        this.discountFunction = discountFunction;
        this.descriptionFunction = descriptionFunction;
    }

    public double apply(Product product) {
        return discountFunction.apply(product, this);
    }

    public String getDescription(Product product) {
        double discount = apply(product);
        return discount > 0 ? descriptionFunction.apply(product, this) : "";
    }
}