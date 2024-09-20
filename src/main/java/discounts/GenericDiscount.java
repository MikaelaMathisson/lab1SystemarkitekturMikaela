package discounts;

import discounts.Discount;
import entities.Product;
import java.util.function.BiFunction;

public class GenericDiscount implements Discount {
    private BiFunction<Product, GenericDiscount, Double> discountFunction;
    private BiFunction<Product, GenericDiscount, String> descriptionFunction;

    public GenericDiscount(BiFunction<Product, GenericDiscount, Double> discountFunction,
                           BiFunction<Product, GenericDiscount, String> descriptionFunction) {
        this.discountFunction = discountFunction;
        this.descriptionFunction = descriptionFunction;
    }

    @Override
    public double apply(Product product) {
        return discountFunction.apply(product, this);
    }

    @Override
    public String getDescription(Product product) {
        return descriptionFunction.apply(product, this);
    }

    @Override
    public boolean isApplicable(Product product) {
        // Använd discountFunction för att avgöra om rabatten är tillämplig
        return discountFunction.apply(product, this) > 0;
    }
}
