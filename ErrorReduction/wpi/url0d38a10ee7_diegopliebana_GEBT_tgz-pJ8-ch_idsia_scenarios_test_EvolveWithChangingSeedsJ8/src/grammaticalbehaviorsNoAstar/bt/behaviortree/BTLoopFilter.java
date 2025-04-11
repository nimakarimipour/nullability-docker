/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BTLoopFilter extends BTNode {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_times;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_limit;

    @org.checkerframework.dataflow.qual.SideEffectFree
    BTLoopFilter(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parentNode,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_limit) {
        super(a_parentNode);
        m_times = 0;
        m_limit = a_limit;
    }

    //Function to notify the parent about my result.
    @org.checkerframework.dataflow.qual.Impure
    public void update(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTLoopFilter this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_nodeStatus) throws IncorrectNodeException {
        //Does not matter, just execute it again until loop counter expires
        if (m_times == m_limit) {
            m_nodeStatus = BTConstants.NODE_STATUS_SUCCESS;
            m_parent.update(m_nodeStatus);
        } else {
            m_times++;
            m_curNode = 0;
            m_children.get(m_curNode).step();
        }
    }

    //Function to execute this node.
    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTLoopFilter this) throws IncorrectNodeException {
        super.step();
        if (m_nodeCount != 1)
            throw new IncorrectNodeException("BT Syntax error: Non Filter must have one and just one child.");
        m_times = 1;
        m_curNode = 0;
        m_children.get(m_curNode).step();
    }
}
