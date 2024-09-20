package discounts;

import Discounts.BaseDiscount;
import Discounts.Discount;
import entities.Product;

public class QuantityDiscount extends BaseDiscount {
    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getQuantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10.0 * product.getQuantity();
    }

    @Override
    protected String getDescriptionText() {
        return "10 SEK per product if quantity is 5 or more";
    }
}
