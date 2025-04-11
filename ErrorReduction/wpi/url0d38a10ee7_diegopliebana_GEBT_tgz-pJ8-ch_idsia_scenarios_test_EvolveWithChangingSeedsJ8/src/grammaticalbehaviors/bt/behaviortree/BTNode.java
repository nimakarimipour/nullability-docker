/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

import java.util.Vector;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public abstract class BTNode {

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_nodeId;

    //Status of this node
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_nodeStatus;

    //Children of this node
    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<BTNode> m_children;

    //Parent of this node
    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BTNode m_parent;

    //Current child node
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_curNode;

    //Child node count
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_nodeCount;

    //Reference to the behavior tree that owns this node
    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BehaviorTree m_tree;

    //Last cycle id when this node was executed. This value must be updated in the
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long m_lastTick;

    //Default constructor
    @org.checkerframework.dataflow.qual.SideEffectFree
    public BTNode() {
        m_nodeStatus = BTConstants.NODE_STATUS_IDLE;
        m_children = new Vector<BTNode>();
        m_parent = null;
        m_curNode = 0;
        m_nodeCount = 0;
        m_tree = null;
        m_lastTick = -1;
        m_nodeId = -1;
    }

    //Constructor specifying parent.
    @org.checkerframework.dataflow.qual.SideEffectFree
    public BTNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        m_nodeStatus = BTConstants.NODE_STATUS_IDLE;
        m_children = new Vector<BTNode>();
        m_parent = a_parent;
        m_curNode = 0;
        m_nodeCount = 0;
        m_tree = null;
        m_lastTick = -1;
        m_nodeId = -1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setParent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) {
        m_parent = a_parent;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BTNode getParent() {
        return m_parent;
    }

    //Adds a new node to the list of children, in the given index
    @org.checkerframework.dataflow.qual.Impure
    public void add(BTNode a_node, int a_index) {
        a_node.setParent(this);
        m_children.add(a_index, a_node);
        m_nodeCount++;
    }

    //Adds a new node to the list of children.
    @org.checkerframework.dataflow.qual.Impure
    public void add(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_node) {
        a_node.setParent(this);
        m_children.add(a_node);
        m_nodeCount++;
    }

    //Gets the node in the given index. Exception must be catched in caller
    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode get( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_index) throws ArrayIndexOutOfBoundsException {
        return m_children.get(a_index);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setBehaviorTree(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt) {
        m_tree = a_bt;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BehaviorTree getBehaviorTree() {
        return m_tree;
    }

    //Function to notify the parent about my result.
    @org.checkerframework.dataflow.qual.Impure
    public abstract void update( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_nodeStatus) throws IncorrectNodeException;

    @org.checkerframework.dataflow.qual.Impure
    public void notifyResult() throws IncorrectNodeException {
        if ((m_nodeStatus == BTConstants.NODE_STATUS_FAILURE) || (m_nodeStatus == BTConstants.NODE_STATUS_SUCCESS)) {
            int nodeStatusResult = m_nodeStatus;
            m_nodeStatus = BTConstants.NODE_STATUS_IDLE;
            m_parent.update(nodeStatusResult);
        } else {
            //This will be executed if an action returns
            //something different than SUCCESS or FAILURE (action executed again)
            this.step();
        }
    }

    //Function to execute this node.
    @org.checkerframework.dataflow.qual.Impure
    public void step() throws IncorrectNodeException {
        m_tree.setCurrentNode(this);
        m_lastTick = m_tree.getCurTick();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void assignTreeRecur(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt) {
        m_tree = a_bt;
        for (int i = 0; i < m_nodeCount; ++i) {
            m_children.get(i).assignTreeRecur(a_bt);
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public abstract void resetNode();

    @org.checkerframework.dataflow.qual.Impure
    public void reset() {
        this.resetNode();
        for (int i = 0; i < m_nodeCount; ++i) {
            m_children.get(i).reset();
        }
    }
}
