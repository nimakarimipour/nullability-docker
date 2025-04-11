/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.Actions;

import ch.idsia.mario.engine.sprites.Mario;
import grammaticalbehaviorsNoAstar.GEBT_Mario.GEBT_MarioAgent;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTConstants;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTLeafNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.IncorrectNodeException;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class JumpRightRun extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public JumpRightRun(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull JumpRightRun this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        mario.setAction(Mario.KEY_RIGHT, true);
        mario.setAction(Mario.KEY_JUMP, true);
        mario.setAction(Mario.KEY_SPEED, true);
        //report a success
        m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        //m_parent.update(m_nodeStatus);
    }
}
