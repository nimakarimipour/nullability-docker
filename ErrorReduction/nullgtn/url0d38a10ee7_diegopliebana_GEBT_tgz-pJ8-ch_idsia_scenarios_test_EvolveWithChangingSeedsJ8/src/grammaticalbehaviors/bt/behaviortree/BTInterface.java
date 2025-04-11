/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

import java.util.Hashtable;

/**
 * @author Diego
 */
public interface BTInterface {

    void execute();

    boolean load(@javax.annotation.Nullable String a_filename);

    boolean load(@javax.annotation.Nullable BTStream a_stream);

    public XML_BTReader getReader();

    public long getCurTick();

    public void setRootNode(@javax.annotation.Nullable BTNode a_root);

    public BTNode getRootNode();

    public Object getAgent();

    public void setCurrentNode(@javax.annotation.Nullable BTNode a_curNode);

    public BTNode getCurrentNode();

    public BTNode createNode(@javax.annotation.Nullable BTNode a_parent, @javax.annotation.Nullable Hashtable<String, String> a_properties) throws IncorrectNodeException;

    public void reset();
}
