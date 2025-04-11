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
import java.util.Vector;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class IsGapOnRight extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public IsGapOnRight(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IsGapOnRight this) throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        Vector<Integer> gaps = mario.getGaps();
        int marioPos = mario.getCellsRun();
        boolean thereIsGap = false;
        for (int i = 0; !thereIsGap && i < gaps.size(); ++i) {
            int thisGap = gaps.get(i);
            if (thisGap > marioPos) {
                boolean isForbidden = mario.isGapForbidden(thisGap);
                if (!isForbidden)
                    thereIsGap = true;
            }
        }
        m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        if (thereIsGap) {
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        }
        //report
        m_parent.update(m_nodeStatus);
    }
}
