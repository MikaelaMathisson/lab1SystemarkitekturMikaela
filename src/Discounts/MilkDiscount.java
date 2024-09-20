package Discounts;

import entities.Product;

public class MilkDiscount extends BaseDiscount {
    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getName().equals("Milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * 0.05;
    }

    @Override
    protected String getDescriptionText() {
        return "5% discount on Milk";
    }
}
