package Discounts;

import entities.Product;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        double discount = 0;
        if (isApplicable(product)) {
            discount = calculateDiscount(product);
        }
        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }
        return discount;
    }

    @Override
    public String getDescription(Product product) {
        StringBuilder description = new StringBuilder();
        if (isApplicable(product)) {
            description.append(getDescriptionText());
        }
        if (nextDiscount != null) {
            description.append(" ").append(nextDiscount.getDescription(product));
        }
        return description.toString();
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
    protected abstract String getDescriptionText();
}