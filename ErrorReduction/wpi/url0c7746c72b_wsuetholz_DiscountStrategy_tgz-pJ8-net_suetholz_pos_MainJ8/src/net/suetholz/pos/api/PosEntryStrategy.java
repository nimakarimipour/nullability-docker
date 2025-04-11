/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;

/**
 * Point of Sale Entry Strategy
 *
 * @author wsuetholz
 * @version 1.00
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface PosEntryStrategy {

    @org.checkerframework.dataflow.qual.Impure
    public abstract void processEntry(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable StoreStrategy store, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SaleStrategy sale, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable SaleOutputStrategy receiptOutput);
}
