/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.GEBT_Mario;

import java.util.Vector;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Path {

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_RIGHTMOST = 1;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_GROUNDMOST = 2;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_TOPMOST = 3;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_POTCANNON = 4;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_CLOSESTBRICK = 5;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_CLOSESTQUESTION = 6;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int PATH_CLOSESTITEM = 7;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_originID;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_destinationID;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_cost;

    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Integer> m_points;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_metadata;

    //Constructors
    @org.checkerframework.dataflow.qual.SideEffectFree
    public Path() {
        m_originID = -1;
        m_destinationID = -1;
        m_cost = Integer.MAX_VALUE;
        m_points = new Vector<Integer>();
        m_metadata = 0;
    }

    @org.checkerframework.dataflow.qual.Impure
    public Path( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_start,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_end) {
        m_originID = a_start;
        m_destinationID = a_end;
        m_cost = Integer.MAX_VALUE;
        m_points = new Vector<Integer>();
        m_metadata = 0;
        //These two points MUST be in the path!!
        m_points.add(a_start);
        if (a_start != a_end)
            m_points.add(a_end);
    }

    @org.checkerframework.dataflow.qual.Impure
    public Path( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_start,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_end,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_costP) {
        m_originID = a_start;
        m_destinationID = a_end;
        m_cost = a_costP;
        m_points = new Vector<Integer>();
        m_metadata = 0;
        //These two points MUST be in the path!!
        m_points.add(a_start);
        if (a_start != a_end)
            m_points.add(a_end);
    }

    @org.checkerframework.dataflow.qual.Impure
    public Path(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Path a_p) {
        m_originID = a_p.m_originID;
        m_destinationID = a_p.m_destinationID;
        m_cost = a_p.m_cost;
        m_metadata = a_p.m_metadata;
        m_points = new Vector<Integer>();
        for (int i = 0; i < a_p.m_points.size(); ++i) {
            m_points.add(a_p.m_points.get(i));
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Path this) {
        return m_originID + " -> " + m_destinationID + " in (" + m_points.size() + "), cost: " + m_cost;
    }
}
