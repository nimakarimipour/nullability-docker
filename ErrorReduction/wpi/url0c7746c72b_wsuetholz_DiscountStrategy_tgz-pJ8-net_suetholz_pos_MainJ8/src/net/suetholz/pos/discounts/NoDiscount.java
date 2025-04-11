/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.discounts;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class NoDiscount implements DiscountStrategy {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String description;

    @org.checkerframework.dataflow.qual.Impure
    public NoDiscount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description) {
        setDescription(description);
    }

    /**
     * Return the description of the discount
     *
     * @return discount description
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull NoDiscount this) {
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
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull NoDiscount this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantityPurchased,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitCost) {
        return 0.0;
    }
}
