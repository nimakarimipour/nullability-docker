/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.store;

import net.suetholz.pos.api.SaleStrategy;
import net.suetholz.pos.api.StoreStrategy;
import net.suetholz.pos.sales.BasicSale;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BasicStore implements StoreStrategy {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String greeting;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String thankYou;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String name;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String location;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double taxRate;

    @org.checkerframework.dataflow.qual.Impure
    public BasicStore(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String name, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String location, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String greeting, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String thankYou,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double taxRate) {
        setName(name);
        setLocation(location);
        setGreeting(greeting);
        setThankYou(thankYou);
        setTaxRate(taxRate);
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String greeting) {
        if (greeting == null) {
            throw new IllegalArgumentException();
        }
        this.greeting = greeting;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String thankYou) {
        if (thankYou == null) {
            throw new IllegalArgumentException();
        }
        this.thankYou = thankYou;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setLocation(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String location) {
        if (location == null) {
            throw new IllegalArgumentException();
        }
        this.location = location;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void setTaxRate( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double taxRate) {
        if (taxRate < 0.0) {
            throw new IllegalArgumentException();
        }
        this.taxRate = taxRate;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getGreeting(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        return greeting;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getThankYou(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        return thankYou;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        return name;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getLocation(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        return location;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getTaxRate(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        return taxRate;
    }

    @org.checkerframework.dataflow.qual.Pure
    public final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy allocateSale(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this) {
        BasicSale newSale = new BasicSale();
        return newSale;
    }

    @org.checkerframework.dataflow.qual.Impure
    public final void newSale(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
        sale.clearSale();
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public final void saveSale(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public final void voidSale(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BasicStore this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale) {
        if (sale == null) {
            throw new IllegalArgumentException();
        }
    }
}
