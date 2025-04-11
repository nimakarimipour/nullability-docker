/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.GEBT_Mario;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Item {

    //Position and type of the item.
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_x;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_y;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte m_type;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Item() {
        m_x = m_y = m_type = -1;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Item( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        m_x = a_x;
        m_y = a_y;
        m_type = a_type;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(Item a_other) {
        return "(" + m_x + "," + m_y + ") =*> " + m_type;
    }
}
