/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.Conditions;

import grammaticalbehaviors.GEBT_Mario.GEBT_MarioAgent;
import grammaticalbehaviors.bt.behaviortree.BTConstants;
import grammaticalbehaviors.bt.behaviortree.BTLeafNode;
import grammaticalbehaviors.bt.behaviortree.BTNode;
import grammaticalbehaviors.bt.behaviortree.IncorrectNodeException;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class CanIFire extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public CanIFire(BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CanIFire this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        if (mario.canIFire()) {
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        }
        //report
        m_parent.update(m_nodeStatus);
    }
}
