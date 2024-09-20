package Discounts;

import entities.Product;

public abstract class BaseDiscount implements Discount{
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        double discount = 0;
        if(isApplicable(product)) {
            discount = calculateDiscount(product);
        }
        if(nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }
        return discount;
    }



}
