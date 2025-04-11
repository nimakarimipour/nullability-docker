package ch.idsia.ai.agents;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, firstname_at_idsia_dot_ch
 * Date: May 12, 2009
 * Time: 7:28:57 PM
 * Package: ch.idsia.controllers.agents
 */
public class SimpleAgent implements Agent {

    protected boolean[] Action = new boolean[Environment.numberOfButtons];

    protected String Name = "SimpleAgent";

    public void integrateObservation(@javax.annotation.Nullable int[] serializedLevelSceneObservationZ, @javax.annotation.Nullable int[] serializedEnemiesObservationZ, @javax.annotation.Nullable float[] marioFloatPos, @javax.annotation.Nullable float[] enemiesFloatPos, @javax.annotation.Nullable int[] marioState) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean[] getAction() {
        //To change body of implemented methods use File | Settings | File Templates.
        return new boolean[0];
    }

    public void integrateObservation(@javax.annotation.Nullable Environment environment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void reset() {
        Action = new boolean[Environment.numberOfButtons];
        Action[Mario.KEY_RIGHT] = true;
        Action[Mario.KEY_SPEED] = true;
    }

    public boolean[] getAction(Environment observation) {
        Action[Mario.KEY_SPEED] = Action[Mario.KEY_JUMP] = observation.isMarioAbleToJump() || !observation.isMarioOnGround();
        return Action;
    }

    public AGENT_TYPE getType() {
        return AGENT_TYPE.AI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
