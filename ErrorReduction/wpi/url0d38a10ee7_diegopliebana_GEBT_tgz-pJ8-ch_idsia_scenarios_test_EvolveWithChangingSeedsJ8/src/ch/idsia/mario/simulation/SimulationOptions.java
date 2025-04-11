package ch.idsia.mario.simulation;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.AgentsPool;
import ch.idsia.utils.ParameterContainer;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 12, 2009
 * Time: 9:55:56 PM
 * Package: .Simulation
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class SimulationOptions extends ParameterContainer {

    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Agent agent;

    //    protected MarioComponent marioComponent = null;
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int currentTrial = 1;

    @org.checkerframework.dataflow.qual.Impure
    protected SimulationOptions() {
        super();
        //        resetCurrentTrial();
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SimulationOptions getSimulationOptionsCopy() {
        SimulationOptions ret = new SimulationOptions();
        ret.setAgent(getAgent());
        ret.setLevelDifficulty(getLevelDifficulty());
        ret.setLevelLength(getLevelLength());
        ret.setLevelHeight(getLevelHeight());
        ret.setLevelRandSeed(getLevelRandSeed());
        ret.setLevelType(getLevelType());
        //        ret.setMarioComponent(marioComponent);
        ret.setVisualization(isVisualization());
        ret.setPauseWorld(isPauseWorld());
        ret.setPowerRestoration(isPowerRestoration());
        ret.setMarioMode(getMarioMode());
        ret.setTimeLimit(getTimeLimit());
        ret.setZLevelEnemies(getZLevelEnemies());
        ret.setZLevelScene(getZLevelScene());
        ret.setMarioInvulnerable(isMarioInvulnerable());
        ret.setDeadEndsCount(getDeadEndsCount());
        ret.setCannonsCount(getCannonsCount());
        ret.setHillStraightCount(getHillStraightCount());
        ret.setTubesCount(getTubesCount());
        ret.setBlocksCount(getBlocksCount());
        ret.setCoinsCount(getCoinsCount());
        ret.setGapsCount(getGapsCount());
        ret.setHiddenBlocksCount(getHiddenBlocksCount());
        ret.setEnemiesEnabled(isEnemiesEnabled());
        //        ret.setCurrentTrial(getCurrentTrial());
        return ret;
    }

    // Agent
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Agent getAgent() {
        //        return a(getParameterValue("-ag"));      }
        if (agent == null) {
            agent = AgentsPool.load(getParameterValue("-ag"));
            //            System.out.println("Info: Agent not specified. Default " + agent.getName() + " has been used instead");
        }
        return agent;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setAgent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Agent agent) {
        //        setParameterValue("-ag", s(agent));
        this.agent = agent;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setAgent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String agentWOXorClassName) {
        this.agent = AgentsPool.load(agentWOXorClassName);
    }

    // TODO? LEVEL_TYPE enum?
    // LevelType
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLevelType() {
        return i(getParameterValue("-lt"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setLevelType( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelType) {
        setParameterValue("-lt", s(levelType));
    }

    // LevelDifficulty
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLevelDifficulty() {
        return i(getParameterValue("-ld"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setLevelDifficulty( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelDifficulty) {
        setParameterValue("-ld", s(levelDifficulty));
    }

    //LevelLength
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLevelLength() {
        return i(getParameterValue("-ll"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setLevelLength( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelLength) {
        setParameterValue("-ll", s(levelLength));
    }

    //LevelHeight
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLevelHeight() {
        return i(getParameterValue("-lh"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setLevelHeight( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelHeight) {
        setParameterValue("-lh", s(levelHeight));
    }

    //LevelRandSeed
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getLevelRandSeed() {
        return i(getParameterValue("-ls"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setLevelRandSeed( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelRandSeed) {
        setParameterValue("-ls", s(levelRandSeed));
    }

    //Visualization
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isVisualization() {
        return b(getParameterValue("-vis"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setVisualization( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean visualization) {
        setParameterValue("-vis", s(visualization));
    }

    //isPauseWorld
    @org.checkerframework.dataflow.qual.Impure
    public void setPauseWorld( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean pauseWorld) {
        setParameterValue("-pw", s(pauseWorld));
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean isPauseWorld() {
        return b(getParameterValue("-pw"));
    }

    //isPowerRestoration
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean isPowerRestoration() {
        return b(getParameterValue("-pr"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setPowerRestoration( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean powerRestoration) {
        setParameterValue("-pr", s(powerRestoration));
    }

    //StopSimulationIfWin
    //    public Boolean isStopSimulationIfWin() {
    //        return b(getParameterValue("-ssiw"));     }
    //MarioMode
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getMarioMode() {
        return i(getParameterValue("-mm"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMarioMode( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int marioMode) {
        setParameterValue("-mm", s(marioMode));
    }

    //ZLevelScene
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getZLevelScene() {
        return i(getParameterValue("-zs"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setZLevelScene( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int zLevelMap) {
        setParameterValue("-zs", s(zLevelMap));
    }

    //ZLevelEnemies
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getZLevelEnemies() {
        return i(getParameterValue("-ze"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setZLevelEnemies( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int zLevelEnemies) {
        setParameterValue("-ze", s(zLevelEnemies));
    }

    // TimeLimit
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getTimeLimit() {
        return i(getParameterValue("-tl"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setTimeLimit( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int timeLimit) {
        setParameterValue("-tl", s(timeLimit));
    }

    // Invulnerability
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isMarioInvulnerable() {
        return b(getParameterValue("-i"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMarioInvulnerable( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean invulnerable) {
        setParameterValue("-i", s(invulnerable));
    }

    // Level: dead ends count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getDeadEndsCount() {
        return b(getParameterValue("-lde"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDeadEndsCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lde", s(var));
    }

    // Level: cannons count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getCannonsCount() {
        return b(getParameterValue("-lc"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCannonsCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lc", s(var));
    }

    // Level: HillStraight count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getHillStraightCount() {
        return b(getParameterValue("-lhs"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setHillStraightCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lhs", s(var));
    }

    // Level: Tubes count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getTubesCount() {
        return b(getParameterValue("-ltb"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setTubesCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-ltb", s(var));
    }

    // Level: blocks count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getBlocksCount() {
        return b(getParameterValue("-lb"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setBlocksCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lb", s(var));
    }

    // Level: coins count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getCoinsCount() {
        return b(getParameterValue("-lco"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCoinsCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lco", s(var));
    }

    // Level: gaps count
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getGapsCount() {
        return b(getParameterValue("-lg"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setGapsCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lg", s(var));
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean getHiddenBlocksCount() {
        return b(getParameterValue("-lhb"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setHiddenBlocksCount( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-lhb", s(var));
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean isEnemiesEnabled() {
        return b(getParameterValue("-le"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setEnemiesEnabled( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean var) {
        setParameterValue("-le", s(var));
    }

    // Trial tracking
    @org.checkerframework.dataflow.qual.Impure
    public void resetCurrentTrial() {
        currentTrial = 1;
    }
}
