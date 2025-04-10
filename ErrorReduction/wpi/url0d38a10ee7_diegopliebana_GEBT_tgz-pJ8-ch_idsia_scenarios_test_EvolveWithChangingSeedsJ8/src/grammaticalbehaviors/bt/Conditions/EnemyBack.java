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
public class EnemyBack extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public EnemyBack(BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull EnemyBack this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        int aheadStartPos = GEBT_MarioAgent.MARIO_Y - 3;
        int aheadEndPos = GEBT_MarioAgent.MARIO_Y - 1;
        boolean enemyBack = mario.isEnemy(GEBT_MarioAgent.MARIO_X - 1, GEBT_MarioAgent.MARIO_X, aheadStartPos, aheadEndPos);
        if (enemyBack)
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        else
            m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        //report
        m_parent.update(m_nodeStatus);
    }
}
