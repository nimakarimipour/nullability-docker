/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.entries;

import net.suetholz.pos.api.LineItemStrategy;
import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PosEntryProductNQuantity implements PosEntryStrategy {

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable LineItemStrategy lineItem;

    @org.checkerframework.dataflow.qual.Impure
    public PosEntryProductNQuantity(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull LineItemStrategy lineItem) {
        setLineItem(lineItem);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable LineItemStrategy getLineItem() {
        return lineItem;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setLineItem(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull LineItemStrategy lineItem) {
        if (lineItem == null) {
            throw new IllegalArgumentException();
        }
        this.lineItem = lineItem;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void processEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryProductNQuantity this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
        sale.addLineItem(lineItem);
    }
}
