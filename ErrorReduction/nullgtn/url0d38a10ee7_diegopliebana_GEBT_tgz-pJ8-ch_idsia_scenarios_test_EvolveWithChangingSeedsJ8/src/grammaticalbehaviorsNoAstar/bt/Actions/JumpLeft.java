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
public class JumpLeft extends BTLeafNode {

    public JumpLeft(BTNode a_parent) {
        super(a_parent);
    }

    public void step() throws IncorrectNodeException {
        super.step();
        //Get the agent
        Object agent = m_tree.getAgent();
        GEBT_MarioAgent mario = (GEBT_MarioAgent) agent;
        mario.setAction(Mario.KEY_LEFT, true);
        mario.setAction(Mario.KEY_JUMP, true);
        //report a success
        m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
        //m_parent.update(m_nodeStatus);
    }
}
