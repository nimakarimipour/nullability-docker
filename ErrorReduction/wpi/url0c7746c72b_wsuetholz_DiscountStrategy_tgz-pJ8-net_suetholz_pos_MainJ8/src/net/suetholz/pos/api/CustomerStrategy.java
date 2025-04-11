/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

/**
 * CustomerStrategy defines what has to be implemented to be a Customer
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface CustomerStrategy {

    /**
     * Get the customer's name
     *
     * @return Customer Name
     */
    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getName();

    /**
     * Get the last 4 of the credit card number
     *
     * @return last 4 of credit card number
     */
    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCreditCardLastFour();

    /**
     * Get the customer greeting message
     *
     * @param store
     * @return customer greeting
     */
    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    /**
     * get the customer thank you message
     *
     * @param store
     * @return customer thank you message
     */
    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);
}
