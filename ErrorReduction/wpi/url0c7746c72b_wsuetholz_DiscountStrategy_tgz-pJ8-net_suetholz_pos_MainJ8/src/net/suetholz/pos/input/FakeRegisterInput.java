/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.input;

import net.suetholz.pos.Product;
import net.suetholz.pos.api.CustomerStrategy;
import net.suetholz.pos.api.PersistantStorageStrategy;
import net.suetholz.pos.api.PosEntryStrategy;
import net.suetholz.pos.api.SaleInputStrategy;
import net.suetholz.pos.entries.PosEntryAmountTendered;
import net.suetholz.pos.entries.PosEntryClearKey;
import net.suetholz.pos.entries.PosEntryCustomer;
import net.suetholz.pos.entries.PosEntryProductNQuantity;
import net.suetholz.pos.lineitem.BasicLineItem;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class FakeRegisterInput implements SaleInputStrategy {

    private static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ENTRY_INCREMENT = 10;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PersistantStorageStrategy storage;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryStrategy @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] posEntries;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int posNumEntries;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int posIndex;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public FakeRegisterInput(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PersistantStorageStrategy storage) {
        if (storage == null) {
            throw new IllegalArgumentException();
        }
        this.storage = storage;
        posEntries = new PosEntryStrategy[ENTRY_INCREMENT];
        posNumEntries = 0;
        posIndex = 0;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull PosEntryStrategy entry) {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        // See if there is enough room in the array and if not expand the array by INCREMENT slots.
        if (posNumEntries >= posEntries.length) {
            PosEntryStrategy[] posTempEntries = new PosEntryStrategy[posEntries.length + ENTRY_INCREMENT];
            for (int i = 0; i < posNumEntries; i++) {
                posTempEntries[i] = posEntries[i];
            }
            posEntries = posTempEntries;
        }
        posEntries[posNumEntries++] = entry;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addClearKey() {
        addEntry(new PosEntryClearKey());
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addAmountTendered( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double amountTendered) {
        addEntry(new PosEntryAmountTendered(amountTendered));
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException();
        }
        CustomerStrategy customer = storage.lookupCustomer(customerId);
        if (customer != null) {
            addEntry(new PosEntryCustomer(customer));
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void addProductNQuantity(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String productId,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int quantity) {
        if (productId == null) {
            throw new IllegalArgumentException();
        }
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }
        Product product = storage.lookupProduct(productId);
        if (product != null) {
            addEntry(new PosEntryProductNQuantity(new BasicLineItem(product, quantity)));
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable PosEntryStrategy getInput(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull FakeRegisterInput this) {
        if (posIndex >= posNumEntries) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            }
            return null;
        }
        return (posEntries[posIndex++]);
    }
}
