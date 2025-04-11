/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.customer;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.DiscountStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * This is a custom Customer Strategy defining a Corporate Customer
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PreferredCustomer implements CustomerStrategy {

    private final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String DEFAULT_CCLASTFOUR = "";

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int CCLASTFOUR_MIN_LENGTH = 4;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String id;

    // For our purposes, we just do not need this split into First, Middle, and Last
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String name;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String ccLastFour;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable DiscountStrategy discount;

    @org.checkerframework.dataflow.qual.Impure
    public PreferredCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String name) {
        setId(id);
        setName(name);
        ccLastFour = DEFAULT_CCLASTFOUR;
        discount = null;
    }

    /**
     * Get the last 4 of the credit card number
     *
     * @return last 4 of credit card number
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCcLastFour() {
        return ccLastFour;
    }

    /**
     * Set the last 4 of the credit card number
     *
     * @param ccLastFour
     * @throws IllegalArgumentException when ccLastFour length < 4
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setCcLastFour(String ccLastFour) {
        if (ccLastFour == null || ccLastFour.length() < CCLASTFOUR_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.ccLastFour = ccLastFour;
    }

    /**
     * Set the Preferred Customer ID
     *
     * @param id
     * @throws IllegalArgumentException if Id is null.
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setId(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    /**
     * Get the Preferred Customer ID
     *
     * @return customer ID
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getId() {
        return id;
    }

    /**
     * Set the Customer Name
     *
     * @param name
     * @throws IllegalArgumentException when name is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    /**
     * Set the Preferred Customer Discount Strategy
     *
     * @param discount
     * @throws IllegalArgumentException when discount is null
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setDiscount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

    /**
     * Get the Preferred Customer Discount
     *
     * @return discount
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable DiscountStrategy getDiscount() {
        return discount;
    }

    /**
     * Get the customer's name
     *
     * @return
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PreferredCustomer this) {
        return this.name;
    }

    /**
     * Get the last 4 of the credit card number
     *
     * @return last 4 of the credit card number
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCreditCardLastFour(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PreferredCustomer this) {
        return this.ccLastFour;
    }

    /**
     * Get the customer greeting message
     *
     * @param store
     * @return customer greeting
     */
    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PreferredCustomer this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        StringBuilder str = new StringBuilder("");
        if (store != null) {
            str.append(store.getGreeting());
            str.append(" ");
        }
        if (this.name.length() > 0) {
            str.append(this.name);
        }
        return str.toString();
    }

    /**
     * get the customer thank you message
     * @param store
     * @return customer thank you message
     */
    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PreferredCustomer this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        StringBuilder str = new StringBuilder("");
        if (store != null) {
            str.append(store.getThankYou());
            str.append(" ");
        }
        return str.toString();
    }
}
