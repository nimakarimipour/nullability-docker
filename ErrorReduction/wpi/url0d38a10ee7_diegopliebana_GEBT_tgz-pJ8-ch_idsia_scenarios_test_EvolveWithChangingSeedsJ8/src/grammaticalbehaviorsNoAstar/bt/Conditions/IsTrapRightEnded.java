/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.Conditions;

import grammaticalbehaviorsNoAstar.GEBT_Mario.GEBT_MarioAgent;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTConstants;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTLeafNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTNode;
import grammaticalbehaviorsNoAstar.bt.behaviortree.IncorrectNodeException;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class IsTrapRightEnded extends BTLeafNode {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_detectedTrapPos;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public IsTrapRightEnded(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        super(a_parent);
        m_detectedTrapPos = -1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IsTrapRightEnded this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        int marioPos = mario.getCellsRun();
        m_detectedTrapPos = (mario.inTrap() && mario.isRightTrap()) ? mario.trapPos() : m_detectedTrapPos;
        int trapHeight = mario.heightTrapRight();
        boolean marioOnGround = mario.amIOnGround();
        boolean trapIsThere = mario.isObstacle(trapHeight, trapHeight, GEBT_MarioAgent.MARIO_Y, GEBT_MarioAgent.MARIO_Y);
        m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        if (!trapIsThere && marioOnGround) {
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
            boolean isForbidden = mario.isGapForbidden(marioPos);
            if (isForbidden) {
                mario.deleteForbiddenGap(marioPos);
                m_detectedTrapPos = marioPos + 1;
            }
        } else if (trapIsThere && marioOnGround) {
            m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
            mario.addForbiddenGap(marioPos, m_detectedTrapPos);
        }
        //report
        m_parent.update(m_nodeStatus);
    }
}
