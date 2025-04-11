/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public abstract class XML_BTReader {

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BufferedReader m_reader;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public XML_BTReader() {
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean open(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String a_filename) {
        boolean ok = true;
        try {
            //For a file, create a writer.
            m_reader = new BufferedReader(new FileReader(a_filename));
            BTRootNode btRoot = new BTRootNode();
            a_bt.setRootNode(btRoot);
            btRoot.setBehaviorTree(a_bt);
            //Read!
            readXMLRecur(a_bt, btRoot);
            //And close it
            m_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found: " + a_filename);
            e.printStackTrace();
            ok = false;
        } catch (IOException e) {
            System.out.println("Error reading the file: " + a_filename);
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean read(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTStream a_stream) {
        boolean ok = true;
        BTRootNode btRoot = new BTRootNode();
        a_bt.setRootNode(btRoot);
        btRoot.setBehaviorTree(a_bt);
        //Read!
        readXMLRecurStream(a_bt, btRoot, a_stream);
        return ok;
    }

    @org.checkerframework.dataflow.qual.Pure
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String unformatDataXML(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String prop) {
        String newProp;
        newProp = prop.replace("__", " ");
        newProp = newProp.replace("_", " ");
        return newProp;
    }

    @org.checkerframework.dataflow.qual.Impure
    private void readXMLRecurStream(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTStream a_stream) {
        try {
            String line = a_stream.readLine();
            boolean endChilds = false;
            BTNode newNode = null;
            while (!endChilds && line != null && line.length() > 0) {
                if (line.contains("<Node")) {
                    Hashtable<String, String> properties = new Hashtable<String, String>();
                    //Lets split its components
                    String[] chunks = line.split(" ");
                    for (int i = 0; i < chunks.length; ++i) {
                        if (chunks[i].contains("=")) {
                            //It is a property!
                            int index = chunks[i].indexOf('=');
                            String property = chunks[i].substring(0, index);
                            //String value = chunks[i].substring(index + 2, (chunks[i].length() - 1) - (index + 2));
                            String value = chunks[i].substring(index + 2, chunks[i].length() - 1);
                            String propUnformatted = unformatDataXML(property);
                            String valueUnformated = unformatDataXML(value);
                            properties.put(propUnformatted, valueUnformated);
                        }
                    }
                    newNode = a_bt.createNode(a_parent, properties);
                    if (newNode != null) {
                        newNode.setBehaviorTree(a_bt);
                        a_parent.add(newNode);
                    } else {
                        //Could not be created... skip this.
                        newNode = a_parent;
                    }
                } else if (line.contains("<Connector")) {
                    //These are childs of the node.
                    readXMLRecurStream(a_bt, newNode, a_stream);
                } else if (line.contains("</Connector>")) {
                    //End of children.
                    endChilds = true;
                } else if (line.contains("</Node")) {
                    //End of node!
                }
                if (!endChilds)
                    line = a_stream.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    private void readXMLRecur(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BehaviorTree a_bt, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent) throws IOException {
        String line = m_reader.readLine();
        boolean endChilds = false;
        BTNode newNode = null;
        while (!endChilds && line != null) {
            if (line.contains("<Node")) {
                Hashtable<String, String> properties = new Hashtable<String, String>();
                //Lets split its components
                String[] chunks = line.split(" ");
                for (int i = 0; i < chunks.length; ++i) {
                    if (chunks[i].contains("=")) {
                        //It is a property!
                        int index = chunks[i].indexOf('=');
                        String property = chunks[i].substring(0, index);
                        //String value = chunks[i].substring(index + 2, (chunks[i].length() - 1) - (index + 2));
                        String value = chunks[i].substring(index + 2, chunks[i].length() - 1);
                        String propUnformatted = unformatDataXML(property);
                        String valueUnformated = unformatDataXML(value);
                        properties.put(propUnformatted, valueUnformated);
                    }
                }
                try {
                    newNode = a_bt.createNode(a_parent, properties);
                    if (newNode != null) {
                        newNode.setBehaviorTree(a_bt);
                        a_parent.add(newNode);
                    } else {
                        //Could not be created... skip this.
                        newNode = a_parent;
                    }
                } catch (IncorrectNodeException e) {
                    System.out.println("**** INCORRECT NODE *****");
                    e.printStackTrace();
                }
            } else if (line.contains("<Connector")) {
                //These are childs of the node.
                readXMLRecur(a_bt, newNode);
            } else if (line.contains("</Connector>")) {
                //End of children.
                endChilds = true;
            } else if (line.contains("</Node")) {
                //End of node!
            }
            if (!endChilds)
                line = m_reader.readLine();
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public abstract @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BTLeafNode readNode(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull BTNode a_parent, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<String, String> a_properties);
}
