package ch.idsia.scenarios.oldscenarios;

import ch.idsia.ai.agents.controllers.*;
import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.AgentsPool;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationInfo;
import ch.idsia.tools.EvaluationOptions;
import ch.idsia.tools.Evaluator;
import ch.idsia.utils.StatisticalSummary;
import ch.idsia.mario.simulation.SimulationOptions;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, firstName_at_idsia_dot_ch
 * Date: May 7, 2009
 * Time: 4:35:08 PM
 * Package: ch.idsia
 */
public class MainRun {

    final static int numberOfTrials = 10;

    final static boolean scoring = false;

    private static int killsSum = 0;

    private static float marioStatusSum = 0;

    private static int timeLeftSum = 0;

    private static int marioModeSum = 0;

    private static boolean detailedStats = false;

    public static void main(String[] args) {
        CmdLineOptions cmdLineOptions = new CmdLineOptions(args);
        // if none options mentioned, all defalults are used.
        EvaluationOptions evaluationOptions = cmdLineOptions;
        createAgentsPool();
        if (scoring)
            scoreAllAgents(cmdLineOptions);
        else {
            //            Evaluator evaluator = new Evaluator(evaluationOptions);
            //            evaluationOptions.setAgent(AgentsPool.getCurrentAgent());
            //            evaluationOptions.setAgent(new AmiCoAgent(amicoModuleName, amicoAgentName));
            //            while (cmdLineOptions.getNumberOfTrials() >= SimulationOptions.currentTrial) {
            //                List<EvaluationInfo> evaluationSummary;
            System.out.println("SimulationOptions.currentTrial = " + SimulationOptions.currentTrial);
            //                evaluator.evaluate();
            //            }
            //        LOGGER.save("log.txt");
        }
        if (cmdLineOptions.isExitProgramWhenFinished())
            System.exit(0);
    }

    private static boolean calledBefore = false;

    public static void createAgentsPool() {
        if (!calledBefore) {
            // Create an Agent here or mention the set of agents you want to be available for the framework.
            // All created agents by now are used here.
            // They can be accessed by just setting the commandline property -ag to the name of desired agent.
            calledBefore = true;
            //addAgentToThePool
            //            AgentsPool.addAgent(new ForwardAgent());
            //            AgentsPool.addAgent(new ForwardJumpingAgent());
            //ice-gic:
            AgentsPool.addAgent(new ScaredAgent());
            //            AgentsPool.addAgent(new Perez());
            //            AgentsPool.addAgent(new AdaptiveAgent());
            //            AgentsPool.addAgent(new AIwesome());
            //            AgentsPool.addAgent(new TutchekAgent());
            //            AgentsPool.addAgent(new SlowAgent());
            //            AgentsPool.addAgent(new AStarAgent());
            //            AgentsPool.addAgent(new RjAgent());
            //            AgentsPool.addAgent(new SergeyKarakovskiy_JumpingAgent());
            //CIG:
            //            AgentsPool.addAgent(new TrondEllingsen_LuckyAgent());
            //            AgentsPool.addAgent(new SergeyPolikarpov_SimpleCyberNeuronAgent());
            //            AgentsPool.addAgent(new SpencerSchumann_SlideRule());
            //            AgentsPool.addAgent(new AndySloane_BestFirstAgent());
            //            AgentsPool.addAgent(AgentsPool.load("competition/cig/matthewerickson/matthewerickson.xml"));
            //            AgentsPool.addAgent(AgentsPool.load("competition/icegic/erek/erekspeed.xml")); // out of memory exception
            //            AgentsPool.addAgent(new PalerAgent());
            //            AgentsPool.addAgent(new PeterLawford_SlowAgent());
        }
    }

    public static void scoreAllAgents(CmdLineOptions cmdLineOptions) {
        int startingSeed = cmdLineOptions.getLevelRandSeed();
        for (Agent agent : AgentsPool.getAgentsCollection()) score(agent, startingSeed, cmdLineOptions);
        //        startingSeed = 0;
        //        for (Agent agent : AgentsPool.getAgentsCollection())
        //            score(agent, startingSeed, cmdLineOptions);
    }

    public static void score(Agent agent, int startingSeed, CmdLineOptions cmdLineOptions) {
        TimingAgent controller = new TimingAgent(agent);
        EvaluationOptions options = cmdLineOptions;
        //        options.setNumberOfTrials(1);
        //        options.setVisualization(false);
        //        options.setMaxFPS(true);
        System.out.println("\nScoring controller " + agent.getName() + " with starting seed " + startingSeed);
        double competitionScore = 0;
        killsSum = 0;
        marioStatusSum = 0;
        timeLeftSum = 0;
        marioModeSum = 0;
        competitionScore += testConfig(controller, options, startingSeed, 0, false);
        competitionScore += testConfig(controller, options, startingSeed, 3, false);
        competitionScore += testConfig(controller, options, startingSeed, 5, false);
        competitionScore += testConfig(controller, options, startingSeed, 10, false);
        System.out.println("\nCompetition score: " + competitionScore + "\n");
        System.out.println("Number of levels cleared = " + marioStatusSum);
        System.out.println("Additional (tie-breaker) info: ");
        System.out.println("Total time left = " + timeLeftSum);
        System.out.println("Total kills = " + killsSum);
        System.out.println("Mario mode (small, large, fire) sum = " + marioModeSum);
        System.out.println("TOTAL SUM for " + agent.getName() + " = " + (competitionScore + killsSum + marioStatusSum + marioModeSum + timeLeftSum));
    }

    public static double testConfig(TimingAgent controller, EvaluationOptions options, int seed, int levelDifficulty, boolean paused) {
        options.setLevelDifficulty(levelDifficulty);
        options.setPauseWorld(paused);
        StatisticalSummary ss = test(controller, options, seed);
        double averageTimeTaken = controller.averageTimeTaken();
        System.out.printf("Difficulty %d score %.4f (avg time %.4f)\n", levelDifficulty, ss.mean(), averageTimeTaken);
        return ss.mean();
    }

    public static StatisticalSummary test(Agent controller, EvaluationOptions options, int seed) {
        StatisticalSummary ss = new StatisticalSummary();
        int kills = 0;
        int timeLeft = 0;
        int marioMode = 0;
        float marioStatus = 0;
        //        options.setNumberOfTrials(numberOfTrials);
        options.resetCurrentTrial();
        for (int i = 0; i < numberOfTrials; i++) {
            options.setLevelRandSeed(seed + i);
            options.setLevelLength(200 + (i * 128) + (seed % (i + 1)));
            options.setLevelType(i % 3);
            controller.reset();
            options.setAgent(controller);
            //            Evaluator evaluator = new Evaluator (options);
            //            EvaluationInfo result = evaluator.evaluate().get(0);
            //            kills += result.computeKillsTotal();
            //            timeLeft += result.timeLeft;
            //            marioMode += result.marioMode;
            //            marioStatus += result.marioStatus;
            //            System.out.println("\ntrial # " + i);
            //            System.out.println("result.timeLeft = " + result.timeLeft);
            //            System.out.println("result.marioMode = " + result.marioMode);
            //            System.out.println("result.marioStatus = " + result.marioStatus);
            //            System.out.println("result.computeKillsTotal() = " + result.computeKillsTotal());
            //            ss.add (result.computeDistancePassed());
        }
        if (detailedStats) {
            System.out.println("\n===================\nStatistics over " + numberOfTrials + " trials for " + controller.getName());
            System.out.println("Total kills = " + kills);
            System.out.println("marioStatus = " + marioStatus);
            System.out.println("timeLeft = " + timeLeft);
            System.out.println("marioMode = " + marioMode);
            System.out.println("===================\n");
        }
        killsSum += kills;
        marioStatusSum += marioStatus;
        timeLeftSum += timeLeft;
        marioModeSum += marioMode;
        return ss;
    }
}
