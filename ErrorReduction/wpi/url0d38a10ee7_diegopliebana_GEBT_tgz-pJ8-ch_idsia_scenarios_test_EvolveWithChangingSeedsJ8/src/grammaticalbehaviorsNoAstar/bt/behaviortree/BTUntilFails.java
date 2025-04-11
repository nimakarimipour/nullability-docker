/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BTUntilFails extends BTNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    BTUntilFails(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parentNode) {
        super(a_parentNode);
    }

    //Function to notify the parent about my result.
    @org.checkerframework.dataflow.qual.Impure
    public void update(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTUntilFails this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_nodeStatus) throws IncorrectNodeException {
        if (a_nodeStatus == BTConstants.NODE_STATUS_FAILURE) {
            //FAIL: This node fails.
            m_nodeStatus = BTConstants.NODE_STATUS_FAILURE;
            m_parent.update(m_nodeStatus);
        } else if (a_nodeStatus == BTConstants.NODE_STATUS_SUCCESS) {
            //Execute again.
            m_curNode = 0;
            m_children.get(m_curNode).step();
        }
    }

    //Function to execute this node.
    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTUntilFails this) throws IncorrectNodeException {
        super.step();
        if (m_nodeCount != 1)
            throw new IncorrectNodeException("BT Syntax error: UntilFail Filter must have one and just one child.");
        m_curNode = 0;
        m_children.get(m_curNode).step();
    }
}
