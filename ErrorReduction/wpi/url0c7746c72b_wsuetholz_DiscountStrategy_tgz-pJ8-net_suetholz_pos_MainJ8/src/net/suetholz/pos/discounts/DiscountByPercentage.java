/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * By Item Percentage Discount
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class DiscountByPercentage implements DiscountStrategy {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double pctgDiscountPerItem;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String description;

    /**
     * Constructor for DiscountByPercentage
     *
     * @param pctgDiscountPerItem
     */
    @org.checkerframework.dataflow.qual.Impure
    public DiscountByPercentage(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double pctgDiscountPerItem) {
        setPctgDiscountPerItem(pctgDiscountPerItem);
        setDescription(description);
    }

    /**
     * Get the per item discount percentage
     *
     * @return per item discount percentage
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getPctgDiscountPerItem() {
        return pctgDiscountPerItem;
    }

    /**
     * Set the per item discount percentage
     *
     * Validate discount percent >= 0.0, set to 0.0 if invalid
     *
     * @param pctgDiscountPerItem
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setPctgDiscountPerItem( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double pctgDiscountPerItem) {
        if (pctgDiscountPerItem < 0.0) {
            pctgDiscountPerItem = 0.0;
        }
        this.pctgDiscountPerItem = pctgDiscountPerItem;
    }

    /**
     * Return the description of the discount
     *
     * @return discount description
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByPercentage this) {
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
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountByPercentage this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantityPurchased,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitCost) {
        if (quantityPurchased < 0) {
            throw new IllegalArgumentException("QuantityPurchased must be greater then 0");
        }
        if (unitCost < 0.0) {
            throw new IllegalArgumentException("UnitCost must be greater then 0.0");
        }
        return (((unitCost * pctgDiscountPerItem) * quantityPurchased) / 100);
    }
}
