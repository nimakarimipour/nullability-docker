/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.entries;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PosEntryCustomer implements PosEntryStrategy {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy customer;

    @org.checkerframework.dataflow.qual.Impure
    public PosEntryCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CustomerStrategy customer) {
        setCustomer(customer);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy getCustomer() {
        return customer;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CustomerStrategy customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }
        this.customer = customer;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void processEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryCustomer this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
        sale.setCustomer(customer);
    }
}
