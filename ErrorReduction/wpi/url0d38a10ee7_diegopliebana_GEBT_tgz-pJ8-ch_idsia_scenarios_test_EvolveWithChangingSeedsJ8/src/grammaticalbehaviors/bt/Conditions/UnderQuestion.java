/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.Conditions;

import grammaticalbehaviors.GEBT_Mario.Map;
import grammaticalbehaviors.GEBT_Mario.Node;
import grammaticalbehaviors.GEBT_Mario.Graph;
import grammaticalbehaviors.GEBT_Mario.GEBT_MarioAgent;
import grammaticalbehaviors.bt.behaviortree.BTConstants;
import grammaticalbehaviors.bt.behaviortree.BTLeafNode;
import grammaticalbehaviors.bt.behaviortree.BTNode;
import grammaticalbehaviors.bt.behaviortree.IncorrectNodeException;
import java.util.Vector;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class UnderQuestion extends BTLeafNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public UnderQuestion(BTNode a_parent) {
        super(a_parent);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull UnderQuestion this) throws IncorrectNodeException {
        super.step();
        m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        int marioNodeId = mario.getMarioNodeInMap();
        Graph levelGraph = mario.getMap().getGraph();
        if (marioNodeId != -1) {
            Node marioNode = levelGraph.getNode(marioNodeId);
            if (marioNode.getMetadata() == Map.MAP_QUESTION_BRICK) {
                m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
            }
        }
        //report
        m_parent.update(m_nodeStatus);
    }
}
