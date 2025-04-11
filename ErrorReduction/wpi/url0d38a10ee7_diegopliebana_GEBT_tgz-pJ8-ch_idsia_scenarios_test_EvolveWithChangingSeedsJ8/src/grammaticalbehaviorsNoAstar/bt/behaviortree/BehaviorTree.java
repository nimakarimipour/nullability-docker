/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

import java.util.Hashtable;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BehaviorTree {

    //Root of the tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTRootNode m_rootNode;

    //Root of the tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode m_currentNode;

    //Agent that holds this behavior tree
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Object m_agent;

    //Execution tick
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long m_tick;

    //My XML reader.
    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull XML_BTReader m_xmlReader;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public BehaviorTree(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Object a_agent, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull XML_BTReader a_reader) {
        m_rootNode = new BTRootNode();
        m_currentNode = m_rootNode;
        m_agent = a_agent;
        m_xmlReader = a_reader;
        m_tick = 0;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean load(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String a_filename) {
        return m_xmlReader.open(this, a_filename);
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean load(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTStream a_stream) {
        return m_xmlReader.read(this, a_stream);
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long getCurTick() {
        return m_tick;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setRootNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_root) {
        m_rootNode = (BTRootNode) a_root;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getRootNode() {
        return m_rootNode;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Object getAgent() {
        return m_agent;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCurrentNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_curNode) {
        m_currentNode = a_curNode;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode getCurrentNode() {
        return m_currentNode;
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BTNode createNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<String, String> a_properties) throws IncorrectNodeException {
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
    public void execute() {
        try {
            /*m_rootNode.step();
            m_tick++; //New tick
             */
            if (m_currentNode.getParent() == null) {
                //We are at the root, execute from here.
                m_rootNode.step();
            } else {
                m_currentNode.notifyResult();
            }
            m_tick++;
        } catch (IncorrectNodeException e) {
            System.out.println("Error executing the behavior tree.");
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public void reset() {
        m_currentNode = m_rootNode;
        m_tick = 0;
    }
}
