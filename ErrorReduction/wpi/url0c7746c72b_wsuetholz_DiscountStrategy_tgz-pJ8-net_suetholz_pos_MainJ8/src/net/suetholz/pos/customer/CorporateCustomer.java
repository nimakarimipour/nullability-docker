/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.customer;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * This is a custom Customer Strategy defining a Corporate Customer
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class CorporateCustomer implements CustomerStrategy {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String companyName;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String creditCardLastFour;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public CorporateCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String id, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String companyName) {
        this.id = id;
        this.companyName = companyName;
        this.creditCardLastFour = "";
    }

    /**
     * Get the customer's name
     *
     * @return Customer Name
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CorporateCustomer this) {
        return companyName;
    }

    /**
     * Get the last 4 of the credit card number
     *
     * @return last 4 of the credit card number
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCreditCardLastFour(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CorporateCustomer this) {
        return creditCardLastFour;
    }

    /**
     * Get the customer greeting message
     *
     * @param store
     * @return customer greeting
     */
    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CorporateCustomer this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        StringBuilder str = new StringBuilder("");
        if (store != null) {
            str.append(store.getGreeting());
            str.append(" ");
        }
        if (this.companyName.length() > 0) {
            str.append(this.companyName);
        }
        return str.toString();
    }

    /**
     * get the customer thank you message
     * @param store
     * @return customer thank you message
     */
    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CorporateCustomer this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        StringBuilder str = new StringBuilder("");
        if (store != null) {
            str.append(store.getThankYou());
            str.append(" ");
        }
        return str.toString();
    }
}
