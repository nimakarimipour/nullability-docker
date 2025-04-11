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
public interface PersistantStorageStrategy {

    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CustomerStrategy lookupCustomer(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String customerId);

    @org.checkerframework.dataflow.qual.Impure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Product lookupProduct(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String productId);
}
