/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.bt.behaviortree;

import grammaticalbehaviors.GEBT_Mario.MarioXMLReader;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Main {

    /**
     * @param args the command line arguments
     */
    @org.checkerframework.dataflow.qual.Impure
    public static void main(String[] args) {
        // TODO code application logic here
        BehaviorTree bt = new BehaviorTree(null, new MarioXMLReader());
        bt.execute();
    }
}
