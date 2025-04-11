package ch.idsia.ai.agents;

import ch.idsia.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Mar 28, 2009
 * Time: 8:46:42 PM
 * package ch.idsia.controllers.agents;
 */
//    @Deprecated
//    public boolean[] getAction(Environment observation);
//    @Deprecated
//    void integrateObservation(int[] serializedLevelSceneObservationZ,
//                              int[] serializedEnemiesObservationZ,
//                              float[] marioFloatPos,
//                              float[] enemiesFloatPos,
//                              int[] marioState);
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface Agent {

    @org.checkerframework.dataflow.qual.Impure
     @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getAction();

    @org.checkerframework.dataflow.qual.Impure
    void integrateObservation(Environment environment);

    public enum AGENT_TYPE {

        AI, HUMAN, TCP_SERVER
    }

    // clears all dynamic data, such as hidden layers in recurrent networks
    // just implement an empty method for a reactive controller
    @org.checkerframework.dataflow.qual.Impure
    public void reset();

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull AGENT_TYPE getType();

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getName();

    @org.checkerframework.dataflow.qual.Impure
    public void setName(String name);
}
