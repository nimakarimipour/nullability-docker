package ch.idsia.scenarios.test;

import ch.idsia.ai.Evolvable;
import ch.idsia.ai.agents.learning.SimpleMLPAgent;
import ch.idsia.ai.ea.ES;
import ch.idsia.maibe.tasks.ProgressTask;
import ch.idsia.mario.engine.GlobalOptions;
import ch.idsia.scenarios.oldscenarios.Stats;
import ch.idsia.tools.CmdLineOptions;
import wox.serial.Easy;

/**
 * Created by IntelliJ IDEA.
 * User: julian
 * Date: Jun 14, 2009
 * Time: 2:15:51 PM
 */
public class EvolveSingle {

    final static int generations = 100;

    final static int populationSize = 100;

    public static void main(@javax.annotation.Nullable String[] args) {
        CmdLineOptions options = new CmdLineOptions(new String[0]);
        //        options.setNumberOfTrials(1);
        options.setPauseWorld(false);
        Evolvable initial = new SimpleMLPAgent();
        //        RegisterableAgent.registerAgent ((Agent) initial);
        options.setFPS(GlobalOptions.MaxFPS);
        options.setLevelDifficulty(0);
        options.setVisualization(false);
        ProgressTask task = new ProgressTask(options);
        options.setLevelRandSeed((int) (Math.random() * Integer.MAX_VALUE));
        ES es = new ES(task, initial, populationSize);
        System.out.println("Evolving " + initial + " with task " + task);
        final String fileName = "evolved" + (int) (Math.random() * Integer.MAX_VALUE) + ".xml";
        for (int gen = 0; gen < generations; gen++) {
            es.nextGeneration();
            double bestResult = es.getBestFitnesses()[0];
            System.out.println("Generation " + gen + " best " + bestResult);
            Easy.save(es.getBests()[0], fileName);
        }
        Stats.main(new String[] { fileName, "1" });
    }
}
