/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.entries;

import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * Point of Sale Clear Key Pressed
 *
 * Sets up the register for starting a new sale.
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PosEntryClearKey implements PosEntryStrategy {

    @org.checkerframework.dataflow.qual.Impure
    public final void processEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryClearKey this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
        // If there is an existing sale, then have the store object either
        // save it or void it depending on if it was completed.  The Store
        // will want to keep a history of sales.
        if (sale.isComplete()) {
            store.saveSale(sale);
        } else {
            store.voidSale(sale);
        }
        // The Store object knows the proper way to start a new sale.
        store.newSale(sale);
    }
}
