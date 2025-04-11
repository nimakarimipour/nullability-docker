/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

/**
 * @author wsuetholz
 */
public interface SaleStrategy {

    public abstract CustomerStrategy getCustomer();

    public abstract void setCustomer(@javax.annotation.Nullable CustomerStrategy customer);

    public abstract LineItemStrategy[] getLineItems();

    public abstract void addLineItem(LineItemStrategy lineItem);

    public abstract int getLineItemsLength();

    public abstract String getLineItemId(@javax.annotation.Nullable int index);

    public abstract String getLineItemDesc(@javax.annotation.Nullable int index);

    public abstract double getLineItemUnitPrice(@javax.annotation.Nullable int index);

    public abstract int getLineItemQuantity(@javax.annotation.Nullable int index);

    public abstract double getLineItemExtendedAmount(@javax.annotation.Nullable int index);

    public abstract double getLineItemDiscountAmount(@javax.annotation.Nullable int index);

    public abstract String getGreeting(@javax.annotation.Nullable StoreStrategy store);

    public abstract String getThankYou(@javax.annotation.Nullable StoreStrategy store);

    public abstract double getSubTotalAmount();

    public abstract double getTotalTaxAmount(@javax.annotation.Nullable StoreStrategy store);

    public abstract double getTotalDiscountAmount();

    public abstract double getTotalSaleAmount();

    public abstract double getTotalAmountDue(@javax.annotation.Nullable StoreStrategy store);

    public abstract void setAmountTendered(double amountTendered);

    public abstract double getAmountTenderd();

    public abstract double getChangeAmount(@javax.annotation.Nullable StoreStrategy store);

    public abstract boolean isComplete();

    public abstract void clearSale();
}
