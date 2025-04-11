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
public class EnemyAhead extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public EnemyAhead(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull EnemyAhead this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        int aheadStartPos = GEBT_MarioAgent.MARIO_Y + 1;
        int aheadEndPos = GEBT_MarioAgent.MARIO_Y + 5;
        boolean enemyAhead = mario.isEnemy(GEBT_MarioAgent.MARIO_X - 1, GEBT_MarioAgent.MARIO_X, aheadStartPos, aheadEndPos);
        if (enemyAhead)
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        else
            m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        //report
        m_parent.update(m_nodeStatus);
    }
}
