/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * Provide a Flat Dollar Amount Discount
 *
 * @author wsuetholz
 * @version 1.0
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class DiscountByFlatRate implements DiscountStrategy {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double discountAmount;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String description;

    /**
     * Constructor for DiscountByFlatRate
     *
     * @param description
     * @param discountAmount
     */
    @org.checkerframework.dataflow.qual.Impure
    public DiscountByFlatRate(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double discountAmount) {
        setDiscountAmount(discountAmount);
        setDescription(description);
    }

    /**
     * Get the Flat Discount Amount
     *
     * @return discount amount
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Set the flat discount amount
     *
     * Validate discount amount >= 0.0, set to 0.0 if invalid
     *
     * @param discountAmount
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDiscountAmount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double discountAmount) {
        if (discountAmount < 0.0) {
            discountAmount = 0.0;
        }
        this.discountAmount = discountAmount;
    }

    /**
     * Return the description of the discount
     *
     * @return discount description
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByFlatRate this) {
        return description;
    }

    /**
     * Set the description of the discount
     *
     * @param description
     * @throws IllegalArgumentException if description is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description) {
        if (description == null) {
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    /**
     * Calculate and return the total discount amount for this discount
     *
     * @param quantityPurchased
     * @param unitCost
     * @return total calculated discount amount
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByFlatRate this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantityPurchased,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitCost) {
        if (quantityPurchased < 0) {
            throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
        }
        if (unitCost < 0.0) {
            throw new IllegalArgumentException("UnitCost must be greater then 0.0");
        }
        return discountAmount;
    }
}
