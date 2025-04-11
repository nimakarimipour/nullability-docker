/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class IncorrectNodeException extends Exception {

    @org.checkerframework.dataflow.qual.SideEffectFree
    IncorrectNodeException() {
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    IncorrectNodeException(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String a_message) {
        super(a_message);
    }
}
