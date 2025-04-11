/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

import net.suetholz.pos.Product;

/**
 * @author wsuetholz
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface LineItemStrategy {

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Product getProduct();

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getProductId();

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getProductDesc();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getQuantity();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getUnitCost();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getDiscountAmount();

    @org.checkerframework.dataflow.qual.Pure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double getExtendedAmount();
}
