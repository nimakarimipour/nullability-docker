package ch.idsia.ai.agents.controllers;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 25, 2009
 * Time: 12:30:41 AM
 * Package: ch.idsia.controllers.agents.controllers;
 */
public class BasicAIAgent implements Agent {

    protected boolean[] action = new boolean[Environment.numberOfButtons];

    protected String name = "Instance_of_BasicAIAgent._Change_this_name";

    /*final*/
    protected byte[][] levelScene;

    /*final */
    protected byte[][] enemies;

    protected byte[][] mergedObservation;

    @javax.annotation.Nullable
    protected float[] marioFloatPos = null;

    @javax.annotation.Nullable
    protected float[] enemiesFloatPos = null;

    @javax.annotation.Nullable
    protected int[] marioState = null;

    protected int marioStatus;

    protected int marioMode;

    protected boolean isMarioOnGround;

    protected boolean isMarioAbleToJump;

    protected boolean isMarioAbleToShoot;

    protected boolean isMarioCarrying;

    protected int getKillsTotal;

    protected int getKillsByFire;

    protected int getKillsByStomp;

    protected int getKillsByShell;

    // values of these variables could be changed during the Agent-Environment interaction.
    // Use them to get more detailed or less detailed description of the level.
    // for information see documentation for the benchmark <link: marioai.org/marioaibenchmark/zLevels
    int zLevelScene = 1;

    int zLevelEnemies = 0;

    public BasicAIAgent(String s) {
        setName(s);
        levelScene = new byte[Environment.HalfObsHeight * 2][Environment.HalfObsWidth * 2];
        enemies = new byte[Environment.HalfObsHeight * 2][Environment.HalfObsWidth * 2];
        mergedObservation = new byte[Environment.HalfObsHeight * 2][Environment.HalfObsWidth * 2];
    }

    public void integrateObservation(int[] serializedLevelSceneObservationZ, int[] serializedEnemiesObservationZ, float[] marioFloatPos, float[] enemiesFloatPos, int[] marioState) {
        int k = 0;
        for (int i = 0; i < levelScene.length; ++i) {
            for (int j = 0; j < levelScene[0].length; ++j) {
                levelScene[i][j] = (byte) serializedLevelSceneObservationZ[k];
                enemies[i][j] = (byte) serializedEnemiesObservationZ[k++];
                mergedObservation[i][j] = levelScene[i][j];
                // Simulating merged observation!
                if (enemies[i][j] != 0) {
                    mergedObservation[i][j] = enemies[i][j];
                }
                //                System.out.print(observation[i][j] + "\t");
            }
            //            System.out.println();
        }
        this.marioFloatPos = marioFloatPos;
        this.enemiesFloatPos = enemiesFloatPos;
        this.marioState = marioState;
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
    }

    public boolean[] getAction() {
        return new boolean[Environment.numberOfButtons];
    }

    public void integrateObservation(Environment environment) {
        levelScene = environment.getLevelSceneObservationZ(zLevelScene);
        enemies = environment.getEnemiesObservationZ(zLevelEnemies);
        mergedObservation = environment.getMergedObservationZZ(1, 0);
        this.marioFloatPos = environment.getMarioFloatPos();
        this.enemiesFloatPos = environment.getEnemiesFloatPos();
        this.marioState = environment.getMarioState();
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
    }

    public void reset() {
        // Empty action
        action = new boolean[Environment.numberOfButtons];
    }

    @Deprecated
    public boolean[] getAction(@javax.annotation.Nullable Environment observation) {
        // Empty action
        return new boolean[Environment.numberOfButtons];
    }

    public AGENT_TYPE getType() {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
}
