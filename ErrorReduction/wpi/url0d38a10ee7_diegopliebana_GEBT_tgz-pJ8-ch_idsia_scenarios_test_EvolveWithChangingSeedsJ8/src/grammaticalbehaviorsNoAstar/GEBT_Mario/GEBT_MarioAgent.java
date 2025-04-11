package grammaticalbehaviorsNoAstar.GEBT_Mario;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.engine.sprites.Sprite;
import ch.idsia.mario.environments.Environment;
import ch.idsia.tools.EvaluationInfo;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BTStream;
import grammaticalbehaviorsNoAstar.bt.behaviortree.BehaviorTree;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA. \n User: Sergey Karakovskiy, sergey at idsia dot ch Date: Mar 24, 2010 Time: 6:51:44 PM
 * Package: competition.evostar.sergeykarakovskiy
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class GEBT_MarioAgent implements Agent {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String name;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] action;

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<Integer, Integer> m_record;

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Integer> m_gaps;

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<IntPair> m_forbiddenGaps;

    //private boolean[] m_lastAction;
    //10;
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_X = Environment.HalfObsHeight;

    //10;
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MARIO_Y = Environment.HalfObsWidth;

    /*final*/
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] levelScene;

    /*final */
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] enemies;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] mergedObservation;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] marioFloatPos = null;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] enemiesFloatPos = null;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] marioState = null;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int marioStatus;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int marioMode;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioOnGround;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioAbleToJump;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioAbleToShoot;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioCarrying;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getKillsTotal;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getKillsByFire;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getKillsByStomp;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getKillsByShell;

    protected int m_cellsRun, m_cellsRunOld;

    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_stuckCounter;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int CYCLES_TO_STUCK = 40;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_isATrap;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_isATrapRight;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_heightTrapRight;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_heightTrapLeft;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_trapPos;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_objective;

    //Our Behavior Tree
    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable BehaviorTree m_behaviorTree;

    //Indicates that the agent must be reseted this cycle
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_resetThisCycle;

    @org.checkerframework.dataflow.qual.Impure
    public GEBT_MarioAgent() {
        m_record = new Hashtable<Integer, Integer>();
        m_gaps = new Vector<Integer>();
        m_forbiddenGaps = new Vector<IntPair>();
        name = "GEBT_MarioAgent";
        action = new boolean[10];
        m_objective = -1;
        m_resetThisCycle = false;
        m_isATrap = false;
        m_isATrapRight = false;
        m_heightTrapRight = 0;
        m_heightTrapLeft = 0;
        m_trapPos = 0;
        reset();
        //loadBehaviorTree("bestIndividual_GEBT_MarioAgent.xml");
        //System.out.println("Tried to load: bestIndividual_GEBT_MarioAgent.xml");
    }

    @org.checkerframework.dataflow.qual.Impure
    public void resetAgent() {
        m_record = new Hashtable<Integer, Integer>();
        m_gaps = new Vector<Integer>();
        m_forbiddenGaps = new Vector<IntPair>();
        name = "GEBT_MarioAgent";
        action = new boolean[10];
        m_objective = -1;
        m_isATrap = false;
        m_isATrapRight = false;
        m_heightTrapRight = 0;
        m_heightTrapLeft = 0;
        m_trapPos = 0;
        reset();
        m_behaviorTree.reset();
        m_resetThisCycle = false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void loadBehaviorTree(BTStream a_stream) {
        reset();
        m_behaviorTree = new BehaviorTree(this, new MarioXMLReader());
        m_behaviorTree.load(a_stream);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void loadBehaviorTree(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String a_filename) {
        reset();
        m_behaviorTree = new BehaviorTree(this, new MarioXMLReader());
        m_behaviorTree.load(a_filename);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<IntPair> getForbiddenGaps() {
        return m_forbiddenGaps;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void deleteForbiddenGap( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int toDelete) {
        boolean deleted = false;
        int gapIndex = 0;
        while (!deleted && gapIndex < m_forbiddenGaps.size()) {
            IntPair storedPair = m_forbiddenGaps.get(gapIndex);
            //if(toDelete == storedPair.a  &&  toDelete == storedPair.b)
            if (toDelete == storedPair.a && toDelete == storedPair.b) {
                //The stored pair must be deleted
                m_forbiddenGaps.remove(gapIndex);
                deleted = true;
            } else if (toDelete >= storedPair.a && toDelete < storedPair.b) {
                storedPair.a = toDelete + 1;
                deleted = true;
            } else {
                gapIndex++;
            }
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public void addForbiddenGap( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int b) {
        if (a > b) {
            int swp = b;
            b = a;
            a = swp;
        }
        IntPair newPair = new IntPair(a, b);
        boolean mustAdd = true;
        int gapIndex = 0;
        while (mustAdd && gapIndex < m_forbiddenGaps.size()) {
            IntPair storedPair = m_forbiddenGaps.get(gapIndex);
            if (newPair.a <= storedPair.a && newPair.b >= storedPair.b) {
                //The stored pair can be deleted
                //Dont increase the index in this case!
                m_forbiddenGaps.remove(gapIndex);
            } else if (newPair.a >= storedPair.a && newPair.b <= storedPair.b) {
                //This pair is covered y another one already in the vector.
                mustAdd = false;
            } else {
                gapIndex++;
            }
        }
        if (mustAdd)
            m_forbiddenGaps.add(newPair);
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isGapForbidden( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_gapPos) {
        boolean forbidden = false;
        int gapIndex = 0;
        while (!forbidden && gapIndex < m_forbiddenGaps.size()) {
            IntPair storedPair = m_forbiddenGaps.get(gapIndex);
            if (a_gapPos >= storedPair.a && a_gapPos <= storedPair.b) {
                //This gap is forbidden by the pairs I have stored.
                forbidden = true;
            }
            gapIndex++;
        }
        return forbidden;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean inTrap() {
        return m_isATrap;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isRightTrap() {
        return m_isATrapRight;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int heightTrapRight() {
        return m_heightTrapRight;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int heightTrapLeft() {
        return m_heightTrapLeft;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int trapPos() {
        return m_trapPos;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getObjective() {
        return m_objective;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setObjective( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int o) {
        m_objective = o;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<Integer, Integer> getRecord() {
        return m_record;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Integer> getGaps() {
        return m_gaps;
    }

    // values of these variables could be changed during the Agent-Environment interaction.
    // Use them to get more detailed or less detailed description of the level.
    // for information see documentation for the benchmark <link: marioai.org/marioaibenchmark/zLevels
    // *** Level 2: Obstacle (1) or not (0) ***
    /*
     LevelScene:
        1 - any kind of obstacle, cannot pass through
        0 - no obstacle, can pass through

     Enemies:
        1 - some enemy
        0 - no any enemy, Sprite.KIND_NONE

     */
    // *** Level 1: More detailed ***
    /*
     LevelScene:
        0 - no obstacle
        -10 -- hard obstacle, cannot pass through
        -11 -- soft obstacle, can overjump (// half-border, can jump through from bottom and can stand on)
        20 -- angry enemy flower pot or parts of a cannon
        16 - brick (simple or with a hidden coin or with a hidden mushroom/flower)
        21 - question brick (with a coin or mushroom/flower)

     Enemies:
        0 - no enemy in a cell
        2 - Enemy that you can kill by shooting or jumping on it (KIND_BULLET_BILL, KIND_GOOMBA, KIND_GOOMBA_WINGED,
            KIND_GREEN_KOOPA, KIND_GREEN_KOOPA_WINGED, KIND_RED_KOOPA, KIND_RED_KOOPA_WINGED, KIND_SHELL)
        9 - KIND_SPIKY or KIND_ENEMY_FLOWER (cannot kill by jumping, but can kill one of them by shooting;
            hint: FLOWER is only above the flower spot and always above ground)
        25 - KIND_FIREBALL, mario weapon projectile.
     */
    // *** Level 0: Crazy: see http://www.marioai.org/gameplay-track/marioai-benchmark ***
     @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int zLevelScene = 1;

     @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int zLevelEnemies = 0;

    @org.checkerframework.dataflow.qual.Impure
    private void cleanActions() {
        for (int i = 0; i < action.length; ++i) {
            action[i] = false;
        }
    }

    /*private void recordActions()
    {
        for(int i = 0; i < action.length; ++i)
        {
            m_lastAction[i] = action[i];
        }
    }*/
    @org.checkerframework.dataflow.qual.Impure
    public void setAction( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_actionIndex,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean a_value) {
        action[a_actionIndex] = a_value;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getAction(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this) {
        //Clean all the actions
        cleanActions();
        //Execute BT to get the action to do.
        m_behaviorTree.execute();
        //keep track of last set of actions.
        //recordActions();
        if (m_resetThisCycle) {
            resetAgent();
        }
        //And this is the action that must be taken:
        return action;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getLevelScene() {
        return levelScene;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] getEnemyScene() {
        return enemies;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getCellsRun() {
        return m_cellsRun;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void integrateObservation(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Environment environment) {
        levelScene = environment.getLevelSceneObservationZ(zLevelScene);
        enemies = environment.getEnemiesObservationZ(zLevelEnemies);
        mergedObservation = environment.getMergedObservationZZ(1, 0);
        this.marioFloatPos = environment.getMarioFloatPos();
        this.enemiesFloatPos = environment.getEnemiesFloatPos();
        this.marioState = environment.getMarioState();
        EvaluationInfo evaluationInfo = environment.getEvaluationInfo();
        m_cellsRun = evaluationInfo.distancePassedCells;
        if (m_cellsRunOld == m_cellsRun) {
            m_stuckCounter++;
        } else {
            m_stuckCounter = 0;
        }
        m_cellsRunOld = m_cellsRun;
        //System.out.println("CELLS PASSED: " + m_cellsRun);
        /*
        //Some printings:
        System.out.println("####levelScene.length##########################");
        for(int i = 0; i < levelScene.length; ++i)
        {
            for(int j = 0; j < levelScene[i].length; ++j)
            {
                if(i == 11 && j == 11)
                {
                    System.out.print(" *" + levelScene[i][j] + "* ");
                }
                else
                {    
                    System.out.print(levelScene[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("##############################");
  */
        // It also possible to use direct methods from Environment interface.
        //
        marioStatus = marioState[0];
        marioMode = marioState[1];
        isMarioOnGround = marioState[2] == 1;
        isMarioAbleToJump = marioState[3] == 1;
        isMarioAbleToShoot = marioState[4] == 1;
        isMarioCarrying = marioState[5] == 1;
        getKillsTotal = marioState[6];
        getKillsByFire = marioState[7];
        getKillsByStomp = marioState[8];
        getKillsByShell = marioState[9];
        int aheadStartPos = GEBT_MarioAgent.MARIO_Y - 5;
        int aheadEndPos = GEBT_MarioAgent.MARIO_Y + 5;
        snapshot(GEBT_MarioAgent.MARIO_X - 3, GEBT_MarioAgent.MARIO_X - 2, aheadStartPos, aheadEndPos);
        trap();
        if (environment.isLevelFinished()) {
            m_resetThisCycle = true;
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean canIJump() {
        return isMarioAbleToJump;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean canIFire() {
        return isMarioAbleToShoot;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean amIOnGround() {
        return isMarioOnGround;
    }

    @org.checkerframework.dataflow.qual.Pure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkMarioFits( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int horizontal,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int vertical,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int minX) {
        boolean fits = false;
        boolean oldFree = false;
        boolean marioSmall = marioMode == 0;
        int h = horizontal;
        while (!fits && h <= minX) {
            //Go down looking for gaps.
            boolean freeHere = !isObstacle(levelScene[h][vertical]);
            //1-cell gaps, for small Mario.
            if (freeHere && marioSmall) {
                //This is a 1-cell gap.
                if (h >= MARIO_X - 4)
                    //And reachable!
                    fits = true;
            }
            ///2-cell gaps, for large Mario.
            if (freeHere && oldFree) {
                //This is a 2-cell gap.
                if (h >= MARIO_X - 4)
                    //And reachable!
                    fits = true;
            }
            oldFree = freeHere;
            ++h;
        }
        return fits;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean trap() {
        if (!isMarioOnGround) {
            //If we are jumping, there is no sense in searching for traps. Do it on ground!
            return false;
        }
        //First, find obstacle in vertical:
        int xmin = MARIO_X;
        int xmax = MARIO_X - Environment.HalfObsHeight;
        boolean obsFound = false;
        int i = xmin;
        m_isATrap = false;
        for (; !obsFound && i > xmax; --i) {
            //WATCH OUT: THIS GOES BOTTOM UP!!!
            obsFound = isObstacle(levelScene[i][MARIO_Y]);
        }
        if (obsFound) {
            //Second A, follow obstacles to the RIGHT
            {
                int x = i + 1;
                int ymin = MARIO_Y + 1;
                int ymax = MARIO_Y + 10;
                for (int j = ymin; obsFound && j < ymax; ++j) {
                    obsFound = isObstacle(levelScene[x][j]);
                    int y = j;
                    int k = x + 1;
                    if (!obsFound) {
                        //There is a gap in the wall, we need to check that mario fits (this checks the whole vertical)
                        boolean marioFits = checkMarioFits(k, y, MARIO_X);
                        //if Mario does not fit, then it is a trap
                        if (!marioFits) {
                            m_isATrap = true;
                            m_isATrapRight = true;
                            m_trapPos = m_cellsRun;
                            m_heightTrapRight = x;
                            return true;
                        }
                    } else //obsFound
                    {
                        boolean obsBack = true;
                        //Third, check the vertical down.
                        for (; obsBack && k <= MARIO_X; ++k) {
                            obsBack &= isObstacle(levelScene[k][y]);
                        }
                        //If obsBack... OH, IT IS A TRAP!!
                        if (obsBack) {
                            m_isATrap = true;
                            m_isATrapRight = true;
                            m_trapPos = m_cellsRun;
                            m_heightTrapRight = x;
                            return true;
                        } else {
                            //There is a gap in the wall, we need to check that mario fits (this checks the whole vertical)
                            boolean marioFits = checkMarioFits(k - 1, y, MARIO_X);
                            //if Mario does not fit, then it is a trap
                            if (!marioFits) {
                                m_isATrap = true;
                                m_isATrapRight = true;
                                m_trapPos = m_cellsRun;
                                m_heightTrapRight = x;
                                return true;
                            }
                        }
                    }
                }
            }
            //Second B, follow obstacles to the LEFT
            {
                obsFound = true;
                int x = i + 1;
                int ymin = MARIO_Y - 1;
                int ymax = MARIO_Y - 10;
                for (int j = ymin; obsFound && j > ymax; --j) {
                    obsFound = isObstacle(levelScene[x][j]);
                    int y = j;
                    int k = x + 1;
                    if (!obsFound) {
                        //There is a gap in the wall, we need to check that mario fits (this checks the whole vertical)
                        boolean marioFits = checkMarioFits(k, y, MARIO_X);
                        //if Mario does not fit, then it is a trap
                        if (!marioFits) {
                            m_isATrap = true;
                            m_isATrapRight = false;
                            m_trapPos = m_cellsRun;
                            m_heightTrapLeft = x;
                            return true;
                        }
                    } else //obsFound
                    {
                        boolean obsBack = true;
                        //Third, check the vertical down.
                        for (; obsBack && k <= MARIO_X; ++k) {
                            obsBack &= isObstacle(levelScene[k][y]);
                        }
                        //If obsBack... OH, IT IS A TRAP!!
                        if (obsBack) {
                            m_isATrap = true;
                            m_isATrapRight = false;
                            m_trapPos = m_cellsRun;
                            m_heightTrapLeft = x;
                            return true;
                        } else {
                            //There is a gap in the wall, we need to check that mario fits (this checks the whole vertical)
                            boolean marioFits = checkMarioFits(k - 1, y, MARIO_X);
                            //if Mario does not fit, then it is a trap
                            if (!marioFits) {
                                m_isATrap = true;
                                m_isATrapRight = false;
                                m_trapPos = m_cellsRun;
                                m_heightTrapLeft = x;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean reachableGap( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int pos) {
        //1st check, I can reach the gap
        boolean reachableGap = false;
        int destinationY = GEBT_MarioAgent.MARIO_Y;
        if (pos - 1 > m_cellsRun) {
            destinationY = GEBT_MarioAgent.MARIO_Y + (pos - 1 - m_cellsRun);
            reachableGap = !isObstacle(GEBT_MarioAgent.MARIO_X - 1, GEBT_MarioAgent.MARIO_X, GEBT_MarioAgent.MARIO_Y, destinationY);
        } else if (pos - 1 < m_cellsRun) {
            destinationY = GEBT_MarioAgent.MARIO_Y + (pos - 1 - m_cellsRun);
            reachableGap = !isObstacle(GEBT_MarioAgent.MARIO_X - 1, GEBT_MarioAgent.MARIO_X, destinationY, GEBT_MarioAgent.MARIO_Y);
        } else
            reachableGap = true;
        //2nd check, there must be space for me over the gap
        if (reachableGap) {
            //Identify where the obstacle is.
            boolean obsInTop = isObstacle(a_xmin, a_xmin, destinationY + 1, destinationY + 1);
            boolean obsInDown = isObstacle(a_xmax, a_xmax, destinationY + 1, destinationY + 1);
            int hMin = a_xmin, hMax = a_xmax;
            if (obsInTop && !obsInDown) {
                //hMin = a_xmax;//THIS IS BAD
                //hMax = a_xmax + 1;//THIS IS BAD
                //THIS IS GOOD
                hMin = a_xmin - 2;
                //THIS IS GOOD
                hMax = a_xmax - 2;
            } else if (obsInDown) {
                //hMin = a_xmin + 2;//THIS IS BAD
                //hMax = a_xmax + 2;//THIS IS BAD
                //THIS IS GOOD
                hMin = a_xmin - 1;
                //THIS IS GOOD
                hMax = a_xmax - 1;
            }
            boolean marioSmall = marioMode == 0;
            if (marioSmall)
                hMax = hMin;
            //Check if there is space enough for Mario to jump.
            reachableGap = !isObstacle(hMin, hMax, destinationY + 1, destinationY + 1);
        }
        return reachableGap;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void snapshot( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        m_record = new Hashtable<Integer, Integer>();
        if (!isMarioOnGround)
            return;
        int minKey = m_cellsRun + (a_ymin - GEBT_MarioAgent.MARIO_Y);
        int maxKey = m_cellsRun + (a_ymax - GEBT_MarioAgent.MARIO_Y);
        for (int j = a_ymin; j <= a_ymax; ++j) {
            boolean obstacle = false;
            for (int i = a_xmin; i <= a_xmax; ++i) {
                boolean obsFound = isObstacle(levelScene[i][j]);
                if (obsFound) {
                    obstacle = true;
                }
            }
            int desp = j - GEBT_MarioAgent.MARIO_Y;
            int pos = m_cellsRun + desp;
            if (!obstacle) {
                m_record.put(pos, Sprite.KIND_NONE);
            } else {
                m_record.put(pos, 1);
            }
        }
        //Now, detect and store gaps
        m_gaps = new Vector<Integer>();
        boolean lastObs = false;
        //When is 2, gap found.
        int obsState = 0;
        for (int i = minKey; i <= maxKey; ++i) {
            int type = m_record.get(i);
            if (!lastObs && type == 1) {
                //Found an obstacle
                ++obsState;
                lastObs = true;
                if (obsState == 1) {
                    boolean reachableGap = reachableGap(a_xmin, a_xmax, i);
                    if (reachableGap) {
                        m_gaps.add(i - 1);
                    }
                } else if (obsState == 2) {
                    boolean reachableGap = reachableGap(a_xmin, a_xmax, i);
                    if (reachableGap) {
                        m_gaps.add(i - 1);
                    }
                    obsState = 1;
                    //1st check, I can reach the gap
                    /*boolean reachableGap = false;
                    int destinationY = GEBT_MarioAgent.MARIO_Y;
                    if(i-1 > m_cellsRun)
                    {
                        destinationY = GEBT_MarioAgent.MARIO_Y + (i - 1 - m_cellsRun);
                        reachableGap = !isObstacle(GEBT_MarioAgent.MARIO_X-1, GEBT_MarioAgent.MARIO_X,GEBT_MarioAgent.MARIO_Y, destinationY);
                    }
                    else if(i-1 < m_cellsRun)
                    {
                        destinationY = GEBT_MarioAgent.MARIO_Y - (i - 1 - m_cellsRun);
                        reachableGap = !isObstacle(GEBT_MarioAgent.MARIO_X-1, GEBT_MarioAgent.MARIO_X, destinationY, GEBT_MarioAgent.MARIO_Y);
                    }
                    else reachableGap = true;

                    //2nd check, there must be space for me over the gap
                    if(reachableGap)
                    {
                        boolean obsInMin = isObstacle(a_xmin, a_xmin, destinationY+1, destinationY+1); //Identify where the obstacle is.
                        boolean obsInMax = isObstacle(a_xmax, a_xmax, destinationY+1, destinationY+1);
                        int hMin = a_xmin, hMax = a_xmax;
                        if(obsInMin && !obsInMax)
                        {
                            hMin = a_xmax;
                            hMax = a_xmax + 1;
                        }else if(obsInMax)
                        {
                            hMin = a_xmin + 2;
                            hMax = a_xmax + 2;
                        }

                        reachableGap = !isObstacle(hMin, hMax, destinationY+1, destinationY+1); //Check if there is space enough for Mario to jump.
                    }*/
                }
            } else if (lastObs && type == Sprite.KIND_NONE) {
                lastObs = false;
            }
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isJumpableEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if ((a_type >= Sprite.KIND_GOOMBA && a_type <= Sprite.KIND_BULLET_BILL) || a_type == Sprite.KIND_SHELL)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isJumpableEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= enemies.length)
            a_xmax = enemies.length - 1;
        if (a_ymax >= enemies[0].length)
            a_ymax = enemies[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean enemyFound = isJumpableEnemy(enemies[i][j]);
                if (enemyFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isNoJumpableEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type >= Sprite.KIND_SPIKY && a_type <= Sprite.KIND_ENEMY_FLOWER)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isNoJumpableEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= enemies.length)
            a_xmax = enemies.length - 1;
        if (a_ymax >= enemies[0].length)
            a_ymax = enemies[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean enemyFound = isNoJumpableEnemy(enemies[i][j]);
                if (enemyFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type >= Sprite.KIND_GOOMBA && a_type <= Sprite.KIND_SHELL)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= enemies.length)
            a_xmax = enemies.length - 1;
        if (a_ymax >= enemies[0].length)
            a_ymax = enemies[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean enemyFound = isEnemy(enemies[i][j]);
                if (enemyFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isItem( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= enemies.length)
            a_xmax = enemies.length - 1;
        if (a_ymax >= enemies[0].length)
            a_ymax = enemies[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean itemFound = isItem(enemies[i][j]);
                if (itemFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isObstacle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type != 0)
            return true;
        return false;
    }

    /*
     LevelScene:
        0 - no obstacle
        -10 -- hard obstacle, cannot pass through
        -11 -- soft obstacle, can overjump (// half-border, can jump through from bottom and can stand on)
        20 -- angry enemy flower pot or parts of a cannon
        16 - brick (simple or with a hidden coin or with a hidden mushroom/flower)
        21 - question brick (with a coin or mushroom/flower)
*/
    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isBreakable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type == 16)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isPushable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type == 21)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isItem( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (// Sprite.KIND_COIN_ANIM looks to be deprecated...
        a_type == Sprite.KIND_MUSHROOM || a_type == Sprite.KIND_FIRE_FLOWER || a_type == Sprite.KIND_COIN_ANIM)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isClimbable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        if (a_type == -11)
            return true;
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isObstacle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= levelScene.length)
            a_xmax = levelScene.length - 1;
        if (a_ymax >= levelScene[0].length)
            a_ymax = levelScene[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean obsFound = isObstacle(levelScene[i][j]);
                if (obsFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isClimbable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= levelScene.length)
            a_xmax = levelScene.length - 1;
        if (a_ymax >= levelScene[0].length)
            a_ymax = levelScene[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean obsFound = isClimbable(levelScene[i][j]);
                if (obsFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isPushable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= levelScene.length)
            a_xmax = levelScene.length - 1;
        if (a_ymax >= levelScene[0].length)
            a_ymax = levelScene[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean obsFound = isPushable(levelScene[i][j]);
                if (obsFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isBreakable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xmax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymin,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ymax) {
        if (a_xmin < 0)
            a_xmin = 0;
        if (a_ymin < 0)
            a_ymin = 0;
        if (a_xmax >= levelScene.length)
            a_xmax = levelScene.length - 1;
        if (a_ymax >= levelScene[0].length)
            a_ymax = levelScene[0].length - 1;
        for (int i = a_xmin; i <= a_xmax; ++i) {
            for (int j = a_ymin; j <= a_ymax; ++j) {
                boolean obsFound = isBreakable(levelScene[i][j]);
                if (obsFound)
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void reset(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this) {
        m_cellsRun = 0;
        m_cellsRunOld = 0;
        m_stuckCounter = 0;
        for (int i = 0; i < action.length; ++i) action[i] = false;
        //action[Mario.KEY_RIGHT] = true;
        // action[Mario.KEY_SPEED] = true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioSmall() {
        return !(Mario.large || Mario.fire);
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioLarge() {
        return Mario.large;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioFire() {
        return Mario.fire;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioStuck() {
        return m_stuckCounter >= CYCLES_TO_STUCK;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull AGENT_TYPE getType(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this) {
        return Agent.AGENT_TYPE.AI;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this) {
        return name;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String Name) {
        this.name = Name;
    }

    @org.checkerframework.dataflow.qual.Pure
    public boolean @org.checkerframework.checker.initialization.qual.FBCBottom @org.checkerframework.checker.nullness.qual.Nullable [] getAction(Environment observation) {
        return null;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void integrateObservation(int[] serializedLevelSceneObservationZ, int[] serializedEnemiesObservationZ, float[] marioFloatPos, float[] enemiesFloatPos, int[] marioState) {
    }
}
