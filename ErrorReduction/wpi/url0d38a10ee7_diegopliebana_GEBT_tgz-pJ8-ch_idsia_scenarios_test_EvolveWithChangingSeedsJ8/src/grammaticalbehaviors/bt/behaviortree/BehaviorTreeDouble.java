/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

import java.util.Hashtable;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BehaviorTreeDouble implements BTInterface {

    //Reactive tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree m_reactiveTree;

    //Deliberative tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree m_delibTree;

    //Current executing behavior tree.
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_currentReactive;

    //Agent that holds this behavior tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Object m_agent;

    //Execution tick
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long m_tick;

    //My XML reader.
    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull XML_BTReader m_xmlReader;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public BehaviorTreeDouble(Object a_agent, XML_BTReader a_reader) {
        m_reactiveTree = new BehaviorTree(a_agent, a_reader);
        m_delibTree = new BehaviorTree(a_agent, a_reader);
        m_agent = a_agent;
        m_xmlReader = a_reader;
        m_tick = 0;
        m_currentReactive = false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean load(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String a_filename) {
        //read the complete behavior tree
        BehaviorTree unique = m_xmlReader.openDouble(this, a_filename);
        //init the behavior trees from unique.
        if (unique != null) {
            return initTrees(unique);
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean load(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTStream a_stream) {
        //return m_xmlReader.readDouble(this, a_stream);
        //read the complete behavior tree
        BehaviorTree unique = m_xmlReader.readDouble(this, a_stream);
        //init the behavior trees from unique.
        if (unique != null) {
            return initTrees(unique);
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean initTrees(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_src) {
        //Root:
        BTRootNode root = (BTRootNode) a_src.getRootNode();
        if (root != null) {
            //Its child must be a parallel node.
            try {
                BTParallelNode parallel = (BTParallelNode) root.get(0);
                //1. Create reactive structure
                BTRootNode reactiveRootNode = new BTRootNode();
                m_reactiveTree.setRootNode(reactiveRootNode);
                // reactiveRootNode.setBehaviorTree(m_reactiveTree);
                reactiveRootNode.add(parallel.get(0));
                reactiveRootNode.assignTreeRecur(m_reactiveTree);
                //2. Create deliberative structure
                BTRootNode deliberativeRootNode = new BTRootNode();
                // deliberativeRootNode.setBehaviorTree(m_delibTree);
                m_delibTree.setRootNode(deliberativeRootNode);
                deliberativeRootNode.add(parallel.get(1));
                deliberativeRootNode.assignTreeRecur(m_delibTree);
                m_currentReactive = false;
            } catch (ClassCastException cce) {
                return false;
            }
        } else
            return false;
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long getCurTick(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        return m_tick;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDeliberativeRootNode(BTNode a_root) {
        m_delibTree.setRootNode((BTRootNode) a_root);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setReactiveRootNode(BTNode a_root) {
        m_reactiveTree.setRootNode((BTRootNode) a_root);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getDeliberativeRootNode() {
        return m_delibTree.getRootNode();
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getReactiveRootNode() {
        return m_reactiveTree.getRootNode();
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Object getAgent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        return m_agent;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDeliberativeCurrentNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_curNode) {
        m_delibTree.setCurrentNode(a_curNode);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getDeliberativeCurrentNode() {
        return m_delibTree.getCurrentNode();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setReactiveCurrentNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_curNode) {
        m_reactiveTree.setCurrentNode(a_curNode);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getReactiveCurrentNode() {
        return m_reactiveTree.getCurrentNode();
    }

    /**
     * @param a_parent Parent of this node
     * @param a_properties Hashtable of properties for this node:
     *    Type: Selector, Sequence, Parallel, Filter, Action, Condition (it is NOT case sensitive).
     *    Filter Type: Non
     *    Name(Only for Actions and conditions): Name of the class for the Action/Condition.
     * @return the new node, or null if it could not be created
     */
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BTNode createNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<String, String> a_properties) throws IncorrectNodeException {
        BTNode newNode = null;
        int nodeId = -1;
        String idValue = a_properties.get("Node id");
        if (idValue != null)
            nodeId = Integer.parseInt(idValue);
        String typeValue = a_properties.get("Type");
        if (typeValue != null) {
            //Create node depending on type
            if (typeValue.compareToIgnoreCase("Selector") == 0) {
                newNode = new BTSelectNode(a_parent);
            } else if (typeValue.compareToIgnoreCase("Sequence") == 0) {
                newNode = new BTSequenceNode(a_parent);
            } else /*else if(typeValue.compareToIgnoreCase("Parallel") == 0)
            {
                //Read policies
                int sucVal = 1, failVal = 1;
                
                String succPolValue = a_properties.get("Success_Policy");
                if(succPolValue != null) sucVal = Integer.parseInt(succPolValue);
                
                String failPolValue = a_properties.get("Failure_Policy");
                if(failPolValue != null) failVal = Integer.parseInt(failPolValue);
                
                newNode = new BTParallelNode(a_parent, sucVal, failVal);
            }*/
            if (typeValue.compareToIgnoreCase("Filter") == 0) {
                String filterType = a_properties.get("Filter Type");
                if (filterType != null) {
                    if (filterType.compareToIgnoreCase("Non") == 0) {
                        newNode = new BTNonFilter(a_parent);
                    } else if (filterType.compareToIgnoreCase("Until Fails Limited") == 0) {
                        int limit = 1;
                        String limitValue = a_properties.get("Times");
                        if (limitValue != null)
                            limit = Integer.parseInt(limitValue);
                        newNode = new BTUntilFailsLimitedFilter(a_parent, limit);
                    } else if (filterType.compareToIgnoreCase("Until Fails") == 0) {
                        newNode = new BTUntilFails(a_parent);
                    } else if (filterType.compareToIgnoreCase("Loop") == 0) {
                        int limit = 1;
                        String limitValue = a_properties.get("Times");
                        if (limitValue != null)
                            limit = Integer.parseInt(limitValue);
                        newNode = new BTLoopFilter(a_parent, limit);
                    }
                }
            } else if ((typeValue.compareToIgnoreCase("Action") == 0) || (typeValue.compareToIgnoreCase("Condition") == 0)) {
                newNode = m_xmlReader.readNode(a_parent, a_properties);
                if (newNode == null) {
                    throw new IncorrectNodeException(a_properties.get("Name") + ": undefined node.");
                }
            }
        }
        if (newNode != null)
            newNode.m_nodeId = nodeId;
        return newNode;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void execute(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        //REACTIVE!
        m_currentReactive = true;
        m_reactiveTree.execute();
        //DELIBERATIVE!
        m_currentReactive = false;
        m_delibTree.execute();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void reset(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        setDeliberativeCurrentNode(getDeliberativeRootNode());
        setReactiveCurrentNode(getReactiveRootNode());
        m_tick = 0;
        m_currentReactive = false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull XML_BTReader getReader(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        return m_xmlReader;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void setRootNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_root) {
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.FBCBottom @org.checkerframework.checker.nullness.qual.Nullable BTNode getRootNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        return null;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void setCurrentNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_curNode) {
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.FBCBottom @org.checkerframework.checker.nullness.qual.Nullable BTNode getCurrentNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTreeDouble this) {
        return null;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isCurrentReactive() {
        return m_currentReactive;
    }
}
