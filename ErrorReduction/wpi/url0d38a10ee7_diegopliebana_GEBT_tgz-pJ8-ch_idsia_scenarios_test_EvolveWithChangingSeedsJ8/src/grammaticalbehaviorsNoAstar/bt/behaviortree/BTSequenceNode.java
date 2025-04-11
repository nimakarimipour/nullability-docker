/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BTSequenceNode extends BTNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    BTSequenceNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parentNode) {
        super(a_parentNode);
    }

    //Function to notify the parent about my result.
    @org.checkerframework.dataflow.qual.Impure
    public void update(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTSequenceNode this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_nodeStatus) throws IncorrectNodeException {
        if (a_nodeStatus != BTConstants.NODE_STATUS_EXECUTING)
            ++m_curNode;
        if (a_nodeStatus == BTConstants.NODE_STATUS_SUCCESS) {
            if (m_curNode < m_nodeCount) {
                m_children.get(m_curNode).step();
            } else {
                m_curNode = 0;
                m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
                m_parent.update(m_nodeStatus);
            }
        } else if (a_nodeStatus == BTConstants.NODE_STATUS_FAILURE) {
            m_curNode = 0;
            m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
            m_parent.update(m_nodeStatus);
        }
    }

    //Function to execute this node.
    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTSequenceNode this) throws IncorrectNodeException {
        super.step();
        if (m_nodeCount == 0)
            throw new IncorrectNodeException("BT Syntax error: Sequence node must have at least 1 child.");
        m_curNode = 0;
        m_children.get(m_curNode).step();
    }
}
