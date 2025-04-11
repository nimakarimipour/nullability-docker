/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 employee/clerk
 store id
 register id
 sale id
 total sales by store and by customer
 daily sales by store and customer
 buy 3 get 1 discount
 special discounts by customer
 special store discounts
 */
package net.suetholz.pos;

import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleInputStrategy;
import net.suetholz.pos.api.SaleOutputStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * This class encapsulates the Point of Sale Register Information
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class PosRegister {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int registerId;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy currentSale;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleInputStrategy lineInput;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean keepRunning;

    @org.checkerframework.dataflow.qual.Impure
    public PosRegister( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int registerId, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleInputStrategy lineInput, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleOutputStrategy receiptOutput) {
        setRegisterId(registerId);
        setStore(store);
        setLineInput(lineInput);
        setReceiptOutput(receiptOutput);
        // The Store object knows the proper way to allocate a sale object.
        currentSale = store.allocateSale();
        keepRunning = true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getRegisterId() {
        return registerId;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setRegisterId( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int registerId) {
        if (registerId <= 0) {
            throw new IllegalArgumentException();
        }
        this.registerId = registerId;
    }

    /**
     * Returns the current value of what store this register is assigned to
     *
     * @return store
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy getStore() {
        return store;
    }

    /**
     * Sets the current store this register is assigned to.
     *
     * Validates store to be non-null
     *
     * @param store
     *
     * @throws IllegalArgumentException if store is null.
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setStore(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull StoreStrategy store) {
        if (store == null) {
            throw new IllegalArgumentException();
        }
        this.store = store;
    }

    /**
     * Gets the sale being currently rung up.
     *
     * @return current sale
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy getCurrentSale() {
        return currentSale;
    }

    /**
     * Get the current input strategy for a sale line item for this register.
     *
     * @return Current Line Item Input Strategy
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleInputStrategy getLineInput() {
        return lineInput;
    }

    /**
     * Sets the input strategy for a sale line item for this register.
     *
     * Validates lineInput to be non-null
     *
     * @param lineInput
     * @throws IllegalArgumentException if lineInput is null.
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setLineInput(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleInputStrategy lineInput) {
        if (lineInput == null) {
            throw new IllegalArgumentException();
        }
        this.lineInput = lineInput;
    }

    /**
     * Gets the receipt output strategy
     *
     * @return current receipt output strategy
     */
    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy getReceiptOutput() {
        return receiptOutput;
    }

    /**
     * Sets the current receipt output strategy for this register
     *
     * @param receiptOutput
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setReceiptOutput(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleOutputStrategy receiptOutput) {
        if (receiptOutput == null) {
            throw new IllegalArgumentException();
        }
        this.receiptOutput = receiptOutput;
    }

    /**
     * Set the flag that indicates that the register should keep running or not
     *
     * @param keepRunning
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }

    /**
     * Drive the POS Register Terminal
     *
     * This is ready to be run as a thread...
     */
    @org.checkerframework.dataflow.qual.Impure
    public final void run() {
        while (keepRunning) {
            PosEntryStrategy posEntry = lineInput.getInput();
            if (posEntry != null) {
                posEntry.processEntry(store, currentSale, receiptOutput);
            }
        }
    }
}
