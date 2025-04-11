/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BTRootNode extends BTNode {

    @org.checkerframework.dataflow.qual.SideEffectFree
    BTRootNode() {
        super();
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void resetNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTRootNode this) {
    }

    //Function to notify the parent about my result.
    @org.checkerframework.dataflow.qual.Impure
    public void update(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTRootNode this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_nodeStatus) throws IncorrectNodeException {
        //In this case update current node
        m_tree.setCurrentNode(this);
        long lastTick = m_tree.getCurTick();
        if (m_lastTick == lastTick) {
            //The whole tree has been evaluated in 1 cycle, but no action was executed.
            //We cannot call step() again (StackOverflow), so just no action this time.
            return;
        }
        //No action was executed this cycle: re-run the tree.
        try {
            step();
        } catch (IncorrectNodeException e) {
            System.out.println("Error executing root node after bailing out.");
            e.printStackTrace();
        }
    }

    //Function to execute this node.
    @org.checkerframework.dataflow.qual.Impure
    public void step(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTRootNode this) throws IncorrectNodeException {
        super.step();
        if (m_nodeCount == 0 || m_nodeCount > 1)
            throw new IncorrectNodeException("BT Syntax error: Root node must have 1 and only 1 child.");
        m_curNode = 0;
        m_children.get(m_curNode).step();
    }
}
