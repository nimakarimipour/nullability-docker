package ch.idsia.ai.agents.learning;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.Evolvable;
import ch.idsia.ai.MLP;
import ch.idsia.ai.agents.controllers.BasicAIAgent;
import ch.idsia.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: julian
 * Date: May 13, 2009
 * Time: 11:11:33 AM
 */
public class MediumMLPAgent extends BasicAIAgent implements Agent, Evolvable {

    private static final String name = "MediumMLPAgent";

    private MLP mlp;

    final int numberOfOutputs = Environment.numberOfButtons;

    //    final int numberOfInputs = 53;
    final int numberOfInputs = 28;

    public MediumMLPAgent() {
        super(name);
        mlp = new MLP(numberOfInputs, 10, numberOfOutputs);
    }

    private MediumMLPAgent(MLP mlp) {
        super(name);
        this.mlp = mlp;
    }

    public Evolvable getNewInstance() {
        return new MediumMLPAgent(mlp.getNewInstance());
    }

    public Evolvable copy() {
        return new MediumMLPAgent(mlp.copy());
    }

    public void reset() {
        mlp.reset();
    }

    public void mutate() {
        mlp.mutate();
    }

    public boolean[] getAction() {
        byte[][] scene = this.mergedObservation;
        //        byte[][] enemies = observation.getEnemiesObservation(/*0*/);
        double[] inputs = new double[numberOfInputs];
        int which = 0;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                inputs[which++] = probe(i, j, scene);
            }
        }
        //        for (int i = -2; i < 3; i++) {
        //            for (int j = -2; j < 3; j++) {
        //                inputs[which++] = probe(i, j, enemies);
        //            }
        //        }
        inputs[inputs.length - 3] = isMarioOnGround ? 1 : 0;
        inputs[inputs.length - 2] = isMarioAbleToJump ? 1 : 0;
        inputs[inputs.length - 1] = 1;
        double[] outputs = mlp.propagate(inputs);
        boolean[] action = new boolean[numberOfOutputs];
        for (int i = 0; i < action.length; i++) {
            action[i] = outputs[i] > 0;
        }
        return action;
    }

    public AGENT_TYPE getType() {
        return AGENT_TYPE.AI;
    }

    public String getName() {
        return name;
    }

    public void setName(@javax.annotation.Nullable String name) {
    }

    private double probe(int x, int y, byte[][] scene) {
        int realX = x + 11;
        int realY = y + 11;
        return (scene[realX][realY] != 0) ? 1 : 0;
    }
}
