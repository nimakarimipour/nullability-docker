/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.sales;

import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.LineItemStrategy;
import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BasicSale implements SaleStrategy {

    private static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ARRAY_ELEMENTS = 10;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy customer;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull LineItemStrategy @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] lineItems;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int numItems;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean complete;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public BasicSale() {
        complete = false;
        lineItems = new LineItemStrategy[ARRAY_ELEMENTS];
        numItems = 0;
        customer = null;
        amountTendered = 0.0;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy getCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return customer;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable CustomerStrategy customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }
        this.customer = customer;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull LineItemStrategy @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getLineItems(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return lineItems;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addLineItem(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable LineItemStrategy lineItem) {
        if (lineItem == null) {
            throw new IllegalArgumentException();
        }
        if (numItems >= lineItems.length) {
            LineItemStrategy[] tempLineItems = new LineItemStrategy[lineItems.length + ARRAY_ELEMENTS];
            for (int i = 0; i < numItems; i++) {
                tempLineItems[i] = lineItems[i];
            }
            lineItems = tempLineItems;
        }
        lineItems[numItems++] = lineItem;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        return customer.getGreeting(store);
    }

    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        return customer.getThankYou(store);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLineItemsLength(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return numItems;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getLineItemId(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getProductId();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getLineItemDesc(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getProductDesc();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemUnitPrice(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getUnitCost();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLineItemQuantity(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getQuantity();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemExtendedAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getExtendedAmount();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getLineItemDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int index) {
        if (index < 0 || index >= numItems) {
            throw new IllegalArgumentException();
        }
        return lineItems[index].getDiscountAmount();
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getSubTotalAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        double subTotal = 0.0;
        for (int i = 0; i < numItems; i++) {
            subTotal += lineItems[i].getExtendedAmount();
        }
        return subTotal;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalTaxAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        if (store == null) {
            throw new IllegalArgumentException();
        }
        return ((getTotalSaleAmount() * store.getTaxRate()) / 100.0);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalDiscountAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        double discountAmount = 0.0;
        for (int i = 0; i < numItems; i++) {
            discountAmount += lineItems[i].getDiscountAmount();
        }
        return discountAmount;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalSaleAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return (getSubTotalAmount() - getTotalDiscountAmount());
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTotalAmountDue(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        if (store == null) {
            throw new IllegalArgumentException();
        }
        return (getTotalSaleAmount() + getTotalTaxAmount(store));
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setAmountTendered(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered) {
        if (amountTendered < 0.0) {
            throw new IllegalArgumentException();
        }
        this.amountTendered = amountTendered;
        this.complete = true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getAmountTenderd(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return amountTendered;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getChangeAmount(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store) {
        if (store == null) {
            throw new IllegalArgumentException();
        }
        double amountDue = getTotalAmountDue(store);
        if (amountTendered < amountDue) {
            throw new IllegalArgumentException();
        }
        return (amountDue - amountTendered);
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isComplete(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        return complete;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void clearSale(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicSale this) {
        complete = false;
        amountTendered = 0.0;
        for (int i = 0; i < numItems; i++) {
            lineItems[i] = null;
        }
        numItems = 0;
    }
}
