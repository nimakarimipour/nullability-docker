/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.GEBT_Mario;

import ch.idsia.ai.agents.Agent;
import ch.idsia.maibe.tasks.BasicTask;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationInfo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class EvoMain {

    //GE Evaluation
    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] timeLimits;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelDifficulties;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelTypes;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelLengths;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] creaturesEnabled;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int levelSeed;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean visualization;

    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int fps;

    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String inputFile;

    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String outputFile;

    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String statsFile;

    //Eval info
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalFitness;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalCellsPassed;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgCellsPassed;

    //mushrooms, flowers and coins.
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalItemsCollected;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgItemsCollected;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalKillsByFire;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgKillsByFire;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalKillsByShell;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgKillsByShell;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalKillsByStomp;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgKillsByStomp;

    //any type
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalKills;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgKills;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalTimeSpent;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgTimeSpent;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalTimeLeft;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgTimeLeft;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_totalLevelsEnded;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_avgLevelsEnded;

    @org.checkerframework.dataflow.qual.Impure
    private void initEvalInfo() {
        m_totalFitness = 0.0f;
        m_totalCellsPassed = 0.0f;
        m_avgCellsPassed = 0.0f;
        m_totalItemsCollected = 0.0f;
        m_avgItemsCollected = 0.0f;
        m_totalKillsByFire = 0.0f;
        m_avgKillsByFire = 0.0f;
        m_totalKillsByShell = 0.0f;
        m_avgKillsByShell = 0.0f;
        m_totalKillsByStomp = 0.0f;
        m_avgKillsByStomp = 0.0f;
        m_totalKills = 0.0f;
        m_avgKills = 0.0f;
        m_totalTimeSpent = 0.0f;
        m_avgTimeSpent = 0.0f;
        m_totalTimeLeft = 0.0f;
        m_avgTimeLeft = 0.0f;
        m_totalLevelsEnded = 0.0f;
        m_avgLevelsEnded = 0.0f;
    }

    @org.checkerframework.dataflow.qual.Impure
    private void computeEvalInfo(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull EvaluationInfo a_evalInfo) {
        m_totalCellsPassed += a_evalInfo.distancePassedCells;
        m_totalItemsCollected += (a_evalInfo.flowersDevoured + a_evalInfo.mushroomsDevoured);
        m_totalKillsByFire += a_evalInfo.killsByFire;
        m_totalKillsByShell += a_evalInfo.killsByShell;
        m_totalKillsByStomp += a_evalInfo.killsByStomp;
        m_totalKills += a_evalInfo.killsTotal;
        m_totalTimeSpent += a_evalInfo.timeSpent;
        m_totalTimeLeft += a_evalInfo.timeLeft;
        m_totalLevelsEnded += (a_evalInfo.marioStatus == Mario.STATUS_WIN) ? 1 : 0;
    }

    @org.checkerframework.dataflow.qual.Impure
    private void endEvalInfo( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float a_fitness,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_numPlays) {
        m_totalFitness = a_fitness;
        m_avgCellsPassed = m_totalCellsPassed / a_numPlays;
        m_avgItemsCollected = m_totalItemsCollected / a_numPlays;
        m_avgKillsByFire = m_totalKillsByFire / a_numPlays;
        m_avgKillsByShell = m_totalKillsByShell / a_numPlays;
        m_avgKillsByStomp = m_totalKillsByStomp / a_numPlays;
        m_avgKills = m_totalKills / a_numPlays;
        m_avgTimeSpent = m_totalTimeSpent / a_numPlays;
        m_avgTimeLeft = m_totalTimeLeft / a_numPlays;
        m_avgLevelsEnded = m_totalLevelsEnded / a_numPlays;
    }

    @org.checkerframework.dataflow.qual.Impure
    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] toIntArray(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] array) {
        int[] values = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            values[i] = Integer.parseInt(array[i]);
        }
        return values;
    }

    @org.checkerframework.dataflow.qual.Impure
    private static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] toBoolArray(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] array) {
        boolean[] values = new boolean[array.length];
        for (int i = 0; i < array.length; ++i) {
            int val = Integer.parseInt(array[i]);
            if (val == 0)
                values[i] = false;
            else
                values[i] = true;
        }
        return values;
    }

    @org.checkerframework.dataflow.qual.Impure
    private static void parse(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String parameter, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] values) {
        if (parameter.compareToIgnoreCase("-tl") == 0) {
            timeLimits = toIntArray(values);
        } else if (parameter.compareToIgnoreCase("-ld") == 0) {
            levelDifficulties = toIntArray(values);
        } else if (parameter.compareToIgnoreCase("-lt") == 0) {
            levelTypes = toIntArray(values);
        } else if (parameter.compareToIgnoreCase("-ll") == 0) {
            levelLengths = toIntArray(values);
        } else if (parameter.compareToIgnoreCase("-ce") == 0) {
            creaturesEnabled = toBoolArray(values);
        } else if (parameter.compareToIgnoreCase("-vis") == 0) {
            visualization = toBoolArray(values)[0];
        } else if (parameter.compareToIgnoreCase("-fps") == 0) {
            fps = toIntArray(values)[0];
        } else if (parameter.compareToIgnoreCase("-rnd") == 0) {
            levelSeed = toIntArray(values)[0];
        } else if (parameter.compareToIgnoreCase("-if") == 0) {
            inputFile = values[0];
        } else if (parameter.compareToIgnoreCase("-of") == 0) {
            outputFile = values[0];
        } else if (parameter.compareToIgnoreCase("-os") == 0) {
            statsFile = values[0];
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    private static void parseArgs(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] args) {
        int index = 0;
        int numArgs = args.length;
        String thisArg;
        String parameter = new String();
        String values = new String();
        while (index < numArgs) {
            thisArg = args[index];
            if (thisArg.length() > 0 && thisArg.charAt(0) == '-') {
                //Then, this is a new parameter
                //And end of the last parameter
                if (values.length() > 0) {
                    //Last parameter parse
                    parse(parameter, values.split(" "));
                }
                parameter = thisArg;
                values = new String();
            }
            if (thisArg.length() > 0 && thisArg.charAt(0) != '-') {
                //This is a value
                values = values.concat(thisArg + " ");
            }
            ++index;
        }
        //Last parameter parse
        parse(parameter, values.split(" "));
    }

    @org.checkerframework.dataflow.qual.Impure
    private static void printFitnessToFile( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull double fitness) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            out.print(fitness + " ");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    private void printStatsToFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(statsFile)));
            out.print("Total fitness,");
            out.print("Total levels ended,");
            out.print("Avg.levels ended,");
            out.print("Total cells passed,");
            out.print("Avg. cells passed,");
            out.print("Total time spent,");
            out.print("Avg. time spent,");
            out.print("Total time left,");
            out.print("Avg. time left,");
            out.print("Total kills,");
            out.print("Avg. kills,");
            out.print("Total items collected,");
            out.print("Avg. itmes collected,");
            out.print("Total kills by fire,");
            out.print("Avg. kills by fire,");
            out.print("Total kills by shell,");
            out.print("Avg. kills by shell,");
            out.print("Total kills by stomp,");
            out.print("Avg. kills by stomp");
            out.println();
            out.print(m_totalFitness + ",");
            out.print(m_totalLevelsEnded + ",");
            out.print(m_avgLevelsEnded + ",");
            out.print(m_totalCellsPassed + ",");
            out.print(m_avgCellsPassed + ",");
            out.print(m_totalTimeSpent + ",");
            out.print(m_avgTimeSpent + ",");
            out.print(m_totalTimeLeft + ",");
            out.print(m_avgTimeLeft + ",");
            out.print(m_totalKills + ",");
            out.print(m_avgKills + ",");
            out.print(m_totalItemsCollected + ",");
            out.print(m_avgItemsCollected + ",");
            out.print(m_totalKillsByFire + ",");
            out.print(m_avgKillsByFire + ",");
            out.print(m_totalKillsByShell + ",");
            out.print(m_avgKillsByShell + ",");
            out.print(m_totalKillsByStomp + ",");
            out.print(m_avgKillsByStomp);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public static void main(String[] args) {
        String[] defaultArgs = new String[] { //Level types
        "-lt", //Level types
        "0 1", //Level difficulties
        "-ld", //Level difficulties
        "0 1 2 3 4 5 6 12 16 20", //Level length
        "-ll", //Level length
        "256", //Time limit (levelLength*4 / 10)
        "-tl", //Time limit (levelLength*4 / 10)
        "102", //creatures enabled
        "-ce", //creatures enabled
        "0 1", //Visualization
        "-vis", //Visualization
        "1", //FPS
        "-fps", //FPS
        "60", //Random Seed
        "-rnd", //Random Seed
        "0" };
        //parse code args (the ones above).
        parseArgs(defaultArgs);
        //parse execution / command line args
        parseArgs(args);
        //Load the agent:
        String[] agentArgs = new String[] { "-ag", "grammaticalbehaviorsNoAstar.GEBT_Mario.GEBT_MarioAgent" };
        final CmdLineOptions cmdLineOptions = new CmdLineOptions(agentArgs);
        Agent agent = cmdLineOptions.getAgent();
        GEBT_MarioAgent myAgent = (GEBT_MarioAgent) agent;
        //Setting some things:
        //TO SET GRAPHICS OFF
        cmdLineOptions.setVisualization(visualization);
        //TO ACTIVATE TIME COMPRESSION
        cmdLineOptions.setFPS(fps);
        //TO SET THE RANDOM SEED (Seed 0 must be submitted. )
        cmdLineOptions.setLevelRandSeed(levelSeed);
        //Load the behavior tree to evaluate (either XML or through BTStream)
        myAgent.loadBehaviorTree(inputFile);
        //Set the agent (maybe this step is not needed...)
        cmdLineOptions.setAgent(myAgent);
        //Score!
        EvoMain evoM = new EvoMain();
        double fitness = evoM.score(cmdLineOptions, timeLimits, levelDifficulties, levelTypes, levelLengths, creaturesEnabled);
        //double realFitness =  100000.0 / (1.0 + fitness);
        evoM.printFitnessToFile(fitness);
        evoM.printStatsToFile();
    }

    @org.checkerframework.dataflow.qual.Impure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float score(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CmdLineOptions cmdLineOptions,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] timeLimits,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelDifficulties,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelTypes,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] levelLengths,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] creaturesEnables) {
        //        final Environment environment = new MarioEnvironment();
        //        System.out.println("agent = " + agent);
        final BasicTask basicTask = new BasicTask(cmdLineOptions);
        float fitness = 0;
        boolean verbose = false;
        int trials = 0;
        int disqualifications = 0;
        //----------------------------------------------------------------------
        //init our stats
        initEvalInfo();
        // todo: include level lengths.
        for (int ll : levelLengths) for (int levelDifficulty : levelDifficulties) {
            for (int levelType : levelTypes) {
                for (boolean creaturesEnable : creaturesEnables) {
                    for (int timeLimit : timeLimits) {
                        trials++;
                        cmdLineOptions.setLevelLength(ll);
                        cmdLineOptions.setLevelDifficulty(levelDifficulty);
                        cmdLineOptions.setLevelType(levelType);
                        cmdLineOptions.setPauseWorld(!creaturesEnable);
                        cmdLineOptions.setTimeLimit(timeLimit);
                        basicTask.reset(cmdLineOptions);
                        if (!basicTask.runOneEpisode()) {
                            System.out.println("MarioAI: out of computational time per action!");
                            disqualifications++;
                            continue;
                        }
                        EvaluationInfo evaluationInfo = basicTask.getEnvironment().getEvaluationInfo();
                        float f = evaluationInfo.computeMultiObjectiveFitness();
                        if (verbose) {
                            System.out.println("LEVEL OPTIONS: -ld " + levelDifficulty + " -lt " + levelType + " -pw " + !creaturesEnable + " -tl " + timeLimit);
                            System.out.println("Intermediate SCORE = " + f + "; Details: " + evaluationInfo.toStringSingleLine());
                        }
                        fitness += f;
                        computeEvalInfo(evaluationInfo);
                    }
                }
            }
        }
        System.out.println("trials = " + trials);
        System.out.println("disqualifications = " + disqualifications);
        System.out.println("GamePlayEvaluation final score = " + fitness);
        endEvalInfo(fitness, trials);
        //        EvaluationInfo evaluationInfo = new EvaluationInfo(environment.getEvaluationInfoAsFloats());
        //        System.out.println("evaluationInfo = " + evaluationInfo);
        return fitness;
    }
}
