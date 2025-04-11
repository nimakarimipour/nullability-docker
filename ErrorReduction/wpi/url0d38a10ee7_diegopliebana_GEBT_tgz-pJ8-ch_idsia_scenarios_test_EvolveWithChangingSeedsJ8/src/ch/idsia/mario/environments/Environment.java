package ch.idsia.mario.environments;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationInfo;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Mar 28, 2009
 * Time: 8:51:57 PM
 * Package: .Environments
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public interface Environment {

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int numberOfButtons = 5;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int HalfObsWidth = 11;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int HalfObsHeight = 11;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_KEY_DOWN = Mario.KEY_DOWN;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_KEY_JUMP = Mario.KEY_JUMP;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_KEY_LEFT = Mario.KEY_LEFT;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_KEY_RIGHT = Mario.KEY_RIGHT;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_KEY_SPEED = Mario.KEY_SPEED;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_STATUS_WIN = Mario.STATUS_WIN;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_STATUS_DEAD = Mario.STATUS_DEAD;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_STATUS_RUNNING = Mario.STATUS_RUNNING;

    // tunable dimensionality:
    // default: 19x19 cells [0..18][0..18]
    // always centered on the agent
    // Chaning ZLevel during the game on-the-fly;
    // if your agent recieves too ambiguous observation, it might request for more precise one for the next step
    //    SUBJECT TO DELETE in next version
    //    // ATAVIZMS for back compatibility! Strongly recommended to use new interface.
    //    @Deprecated
    //    public byte[][] getCompleteObservation();   // default: ZLevelScene = 1, ZLevelEnemies = 0
    //    @Deprecated
    //    public byte[][] getEnemiesObservation();    // default: ZLevelEnemies = 0
    //    @Deprecated
    //    public byte[][] getLevelSceneObservation(); // default: ZLevelScene = 1
    // NEW INTERFACE
    @org.checkerframework.dataflow.qual.SideEffectFree
    public void resetDefault();

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void reset(int[] setUpOptions);

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void tick();

    @org.checkerframework.dataflow.qual.Pure
    public float[] getMarioFloatPos();

    @org.checkerframework.dataflow.qual.Pure
    public int getMarioMode();

    @org.checkerframework.dataflow.qual.Pure
    public float[] getEnemiesFloatPos();

    @org.checkerframework.dataflow.qual.Pure
    public boolean isMarioOnGround();

    @org.checkerframework.dataflow.qual.Pure
    public boolean isMarioAbleToJump();

    @org.checkerframework.dataflow.qual.Pure
    public boolean isMarioCarrying();

    @org.checkerframework.dataflow.qual.Pure
    public boolean isMarioAbleToShoot();

    @org.checkerframework.dataflow.qual.Pure
    public byte[][] getMergedObservationZZ( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ZLevelScene,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ZLevelEnemies);

    @org.checkerframework.dataflow.qual.Pure
    public byte[][] getLevelSceneObservationZ( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ZLevelScene);

    @org.checkerframework.dataflow.qual.Pure
    public byte[][] getEnemiesObservationZ( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int ZLevelEnemies);

    // KILLS
    @org.checkerframework.dataflow.qual.Pure
    public int getKillsTotal();

    @org.checkerframework.dataflow.qual.Pure
    public int getKillsByFire();

    @org.checkerframework.dataflow.qual.Pure
    public int getKillsByStomp();

    @org.checkerframework.dataflow.qual.Pure
    public int getKillsByShell();

    @org.checkerframework.dataflow.qual.Pure
    int getMarioStatus();

    // FOR AmiCo
    @org.checkerframework.dataflow.qual.Pure
    public float[] getSerializedFullObservationZZ(int ZLevelScene, int ZLevelEnemies);

    /**
     * Serializes the LevelScene observation from 22x22 byte array to a 1x484 byte array
     * @param ZLevelScene -- Zoom Level of the levelScene the caller expects to get
     * @return byte[] with sequenced elements of corresponding getLevelSceneObservationZ output
     */
    @org.checkerframework.dataflow.qual.Pure
    public int[] getSerializedLevelSceneObservationZ(int ZLevelScene);

    /**
     * Serializes the LevelScene observation from 22x22 byte array to a 1x484 byte array
     * @param ZLevelEnemies -- Zoom Level of the enemies observation the caller expects to get
     * @return byte[] with sequenced elements of corresponding <code>getLevelSceneObservationZ</code> output
     */
    @org.checkerframework.dataflow.qual.Pure
    public int[] getSerializedEnemiesObservationZ(int ZLevelEnemies);

    @org.checkerframework.dataflow.qual.Pure
    public int[] getSerializedMergedObservationZZ(int ZLevelScene, int ZLevelEnemies);

    @org.checkerframework.dataflow.qual.Pure
    public float[] getCreaturesFloatPos();

    /**
     * @return array filled with various data about Mario : {
     * getMarioStatus(),
     * getMarioMode(),
     * isMarioOnGround() ? 1 : 0,
     * isMarioAbleToJump() ? 1 : 0,
     * isMarioAbleToShoot() ? 1 : 0,
     * isMarioCarrying() ? 1 : 0,
     * getKillsTotal(),
     * getKillsByFire(),
     * getKillsByStomp(),
     * getKillsByShell(),
     * getTimeLimit(),
     * getTimeLeft
     *    }
     */
    @org.checkerframework.dataflow.qual.Pure
    public int[] getMarioState();

    @org.checkerframework.dataflow.qual.SideEffectFree
    void performAction(boolean[] action);

    @org.checkerframework.dataflow.qual.Pure
    boolean isLevelFinished();

    @org.checkerframework.dataflow.qual.Pure
    float[] getEvaluationInfoAsFloats();

    @org.checkerframework.dataflow.qual.Pure
    String getEvaluationInfoAsString();

    @org.checkerframework.dataflow.qual.Pure
    EvaluationInfo getEvaluationInfo();

    @org.checkerframework.dataflow.qual.SideEffectFree
    void reset(CmdLineOptions cmdLineOptions);

    @org.checkerframework.dataflow.qual.SideEffectFree
    void setAgent(Agent agent);
}
