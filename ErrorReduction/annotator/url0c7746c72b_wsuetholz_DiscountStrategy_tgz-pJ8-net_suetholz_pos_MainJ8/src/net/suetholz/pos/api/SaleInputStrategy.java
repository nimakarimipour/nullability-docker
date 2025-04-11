/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.suetholz.pos.api;
import javax.annotation.Nullable;

/**
 *
 * @author wsuetholz
 */
public interface SaleInputStrategy {
    @Nullable public abstract PosEntryStrategy getInput();
}
