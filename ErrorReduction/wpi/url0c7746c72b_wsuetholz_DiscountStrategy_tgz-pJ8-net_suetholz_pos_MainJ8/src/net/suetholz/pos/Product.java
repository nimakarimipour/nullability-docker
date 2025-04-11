package net.suetholz.pos;

import net.suetholz.pos.api.DiscountStrategy;

/**
 * This is a product that can be sold via the point of sale system.
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Product {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String description;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String department;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitPrice;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable DiscountStrategy discount;

    /**
     * Create an instance of the Product.
     *
     * @param id
     * @param description
     * @param department
     * @param unitPrice
     */
    @org.checkerframework.dataflow.qual.Impure
    public Product(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String department,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitPrice) {
        setId(id);
        setDescription(description);
        setDepartment(department);
        setUnitPrice(unitPrice);
        this.discount = null;
    }

    /**
     * Get the product identification string
     *
     * @return product id
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getId() {
        return id;
    }

    /**
     * Set the product identification string.
     *
     * Validate not null
     *
     * @param id
     * @throws IllegalArgumentException if id string parameter is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setId(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    /**
     * Get the product description
     *
     * @return product description
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDescription() {
        return description;
    }

    /**
     * Set the product description
     *
     * Validate not null
     *
     * @param description
     * @throws IllegalArgumentExecption if description parameter is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDescription(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description) {
        if (description == null) {
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    /**
     * Get the product department
     *
     * @return the department the product is part of
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDepartment() {
        return department;
    }

    /**
     * Set the department that the product is part of
     *
     * Validate not null
     *
     * @param department
     * @throws IllegalArgumentException if department parameter is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDepartment(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        this.department = department;
    }

    /**
     * Get the unit price of the product
     *
     * @return unit price
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set the unit price of the product
     *
     * Validate >= 0.0
     *
     * @param unitPrice
     * @throws IllegalArgumentException if unitPrice < 0.0
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setUnitPrice( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double unitPrice) {
        if (unitPrice < 0.0) {
            throw new IllegalArgumentException();
        }
        this.unitPrice = unitPrice;
    }

    /**
     * Return the current discount strategy in use for this product.
     *
     * @return current discount strategy. Can be null.
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable DiscountStrategy getDiscount() {
        return discount;
    }

    /**
     * Sets the current discount strategy used for this product.
     *
     * @param discount which can be null for no discount strategy.
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDiscount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountStrategy discount) {
        this.discount = discount;
    }

    /**
     * Get the total discount amount for this product.
     *
     * @param quantityPurchased
     * @return the current discount amount.
     */
    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantityPurchased) {
        double discountAmount = 0.0;
        if (discount != null) {
            discountAmount = discount.getDiscountAmount(quantityPurchased, unitPrice);
        }
        return discountAmount;
    }
}
