/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface SaleStrategy {

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy getCustomer();

    @org.checkerframework.dataflow.qual.Impure
    public abstract void setCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy customer);

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull LineItemStrategy @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getLineItems();

    @org.checkerframework.dataflow.qual.Impure
    public abstract void addLineItem(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable LineItemStrategy lineItem);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLineItemsLength();

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getLineItemId( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getLineItemDesc( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemUnitPrice( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLineItemQuantity( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemExtendedAmount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemDiscountAmount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index);

    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getSubTotalAmount();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalTaxAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalDiscountAmount();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalSaleAmount();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalAmountDue(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    @org.checkerframework.dataflow.qual.Impure
    public abstract void setAmountTendered( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getAmountTenderd();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getChangeAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store);

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isComplete();

    @org.checkerframework.dataflow.qual.Impure
    public abstract void clearSale();
}
