/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.Conditions;

import grammaticalbehaviorsNoAstar.bt.behaviortree.BTConstants;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTLeafNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.IncorrectNodeException;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Failure extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Failure(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Failure this) throws IncorrectNodeException {
        super.step();
        //This is easy;
        //report
        m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        m_parent.update(m_nodeStatus);
    }
}
