package net.suetholz.pos.entries;

import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * Point of Sale Enter the Amount Tendered by Customer
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PosEntryAmountTendered implements PosEntryStrategy {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered;

    @org.checkerframework.dataflow.qual.Impure
    public PosEntryAmountTendered( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered) {
        setAmountTendered(amountTendered);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getAmountTendered() {
        return amountTendered;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setAmountTendered( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered) {
        if (amountTendered < 0.0) {
            throw new IllegalArgumentException();
        }
        this.amountTendered = amountTendered;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void processEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryAmountTendered this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
        sale.setAmountTendered(amountTendered);
        if (receiptOutput == null) {
            throw new IllegalArgumentException();
        }
        receiptOutput.outputReceipt(store, sale);
    }
}
