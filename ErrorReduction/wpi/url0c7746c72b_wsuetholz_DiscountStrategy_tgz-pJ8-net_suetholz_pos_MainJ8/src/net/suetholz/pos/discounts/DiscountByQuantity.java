/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * Provide a discount strategy which requires a specific quantity purchased,
 * and then gives a flat discount amount.
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class DiscountByQuantity implements DiscountStrategy {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int minQuantity;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double discountAmount;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String description;

    /**
     * Constructor for Discount by Quantity
     *
     * @param minQuantity
     * @param discountAmount
     */
    @org.checkerframework.dataflow.qual.Impure
    public DiscountByQuantity(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int minQuantity,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double discountAmount) {
        setMinQuantity(minQuantity);
        setDiscountAmount(discountAmount);
        setDescription(description);
    }

    /**
     * Get the current minimum quantity required before discount is applied
     *
     * @return minimum quantity required
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getMinQuantity() {
        return minQuantity;
    }

    /**
     * Set the current minimum quantity required before discount is active
     *
     * Validates minQuantity >= 0 and if not sets to 0.
     *
     * @param minQuantity
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setMinQuantity( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int minQuantity) {
        if (minQuantity < 0) {
            minQuantity = 0;
        }
        this.minQuantity = minQuantity;
    }

    /**
     * Gets the current discount amount
     *
     * @return discount amount
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Set the current discount amount
     *
     * Validates discountAmount >= 0.0 and if not set to 0.0.
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
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByQuantity this) {
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
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByQuantity this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantityPurchased,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitCost) {
        if (quantityPurchased < 0) {
            throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
        }
        if (unitCost < 0.0) {
            throw new IllegalArgumentException("UnitCost must be greater then 0.0");
        }
        double result = 0.0;
        if (quantityPurchased < minQuantity) {
            return result;
        }
        result = discountAmount;
        return result;
    }
}
