package discounts;

import entities.Product;

public class QuantityDiscount extends BaseDiscount {
    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicableInternal(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10.0 * product.quantity();
    }

    @Override
    protected String getDescriptionText() {
        return "10 SEK per product if quantity is 5 or more";
    }
}