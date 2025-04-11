/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.GEBT_Mario;

import ch.idsia.mario.engine.GlobalOptions;
import ch.idsia.mario.engine.sprites.Mario;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class MoveSimulator {

    //Agent access.
    private @org.checkerframework.checker.initialization.qual.UnknownInitialization(java.lang.Object.class) @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent m_agent;

    //No action array
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] m_noAction;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_numCyclesJumping;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_x;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_y;

    //Move parameters
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_xa;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_ya;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_onGround;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_facing;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_ducking;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_jumpTime;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_sliding;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_xJumpSpeed;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_yJumpSpeed;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_mayJump;

    //Move parameters
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_xaReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_yaReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_onGroundReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_facingReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_duckingReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_jumpTimeReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_slidingReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_xJumpSpeedReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_yJumpSpeedReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean m_mayJumpReg;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_yaa = 1;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float m_jT;

    @org.checkerframework.dataflow.qual.Impure
    public MoveSimulator(@org.checkerframework.checker.initialization.qual.UnknownInitialization(java.lang.Object.class) @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent a_agent) {
        m_agent = a_agent;
        //10 falses!
        m_noAction = new boolean[10];
        final float jumpPower = 7;
        float marioGravity = a_agent.getMarioGravity();
        m_yaa = marioGravity * 3;
        m_jT = jumpPower / (marioGravity);
        reset();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void reset() {
        m_x = 0;
        m_y = 0;
        m_xa = 0;
        m_ya = 0;
        m_onGround = m_agent.amIOnGround();
        m_facing = 0;
        m_ducking = false;
        m_jumpTime = 0;
        m_sliding = false;
        m_xJumpSpeed = 0;
        m_yJumpSpeed = 0;
        m_mayJump = true;
        m_numCyclesJumping = 0;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void resetReg() {
        m_onGroundReg = m_agent.amIOnGround();
        m_xaReg = 0;
        m_yaReg = 0;
        m_facingReg = 0;
        m_jumpTimeReg = 0;
        m_slidingReg = false;
        m_xJumpSpeedReg = 0;
        m_yJumpSpeedReg = 0;
        m_mayJumpReg = true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void copyState() {
        m_xa = m_xaReg;
        m_ya = m_yaReg;
        m_onGround = m_onGroundReg;
        m_facing = m_facingReg;
        m_ducking = m_duckingReg;
        m_jumpTime = m_jumpTimeReg;
        m_sliding = m_slidingReg;
        m_xJumpSpeed = m_xJumpSpeedReg;
        m_yJumpSpeed = m_yJumpSpeedReg;
        m_mayJump = m_mayJumpReg;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void registerAction( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] a_actions) {
        registerSingleMove(a_actions);
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean simulateFall( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_destX,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_destY,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean a_goingRight) {
        //Copy state from registry
        copyState();
        //new cycle.
        m_numCyclesJumping++;
        //Special condition, dont tell me I will land where I want if I haven't
        //started the jump yet! In other words, return false the first execution.
        if (m_numCyclesJumping == 1) {
            return false;
        }
        //Init mario current position
        m_x = m_agent.marioFloatPos[0];
        m_y = m_agent.marioFloatPos[1];
        //Get the cells
        // 1/16 = 0.0625
        int cellX = (int) (m_x * 0.0625f);
        int cellY = 15 - ((int) (m_y * 0.0625f)) - 1;
        boolean hit = false;
        boolean missed = false;
        do {
            //Simulate one cycle w/ no actions.
            simulateSingleMove(m_noAction);
            //Get the cells
            // 1/16 = 0.0625
            cellX = (int) (m_x * 0.0625f);
            cellY = 15 - ((int) (m_y * 0.0625f)) - 1;
            boolean marioXInMapChunkOk = false;
            //((marioFloatPos[0]/16.0f)*10)%10;
            int marioXInMapChunk = (int) m_x % 16;
            if (a_goingRight && marioXInMapChunk > 10)
                marioXInMapChunkOk = true;
            if (!a_goingRight && marioXInMapChunk < 6)
                marioXInMapChunkOk = true;
            //Check arrived at destination...
            // && marioYInMapChunk == 1;
            hit = a_destX == cellX && a_destY == cellY && marioXInMapChunkOk;
            if (hit) {
                int a = 0;
            }
            //Or It'll be a miss.
            missed = (a_destY > cellY);
        } while (!missed && !hit);
        return hit;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void simulateSingleMove( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] a_actions) {
        boolean large = !m_agent.isMarioSmall();
        float sideWaysSpeed = a_actions[Mario.KEY_SPEED] ? 1.2f : 0.6f;
        if (m_onGround) {
            m_ducking = a_actions[Mario.KEY_DOWN] && large;
        }
        if (m_xa > 2) {
            m_facing = 1;
        }
        if (m_xa < -2) {
            m_facing = -1;
        }
        if (a_actions[Mario.KEY_JUMP] || (m_jumpTime < 0 && !m_onGround && !m_sliding)) {
            if (m_jumpTime < 0) {
                m_xa = m_xJumpSpeed;
                m_ya = -m_jumpTime * m_yJumpSpeed;
                m_jumpTime++;
            } else if (m_onGround && m_mayJump) {
                m_xJumpSpeed = 0;
                m_yJumpSpeed = -1.9f;
                //7
                m_jumpTime = (int) m_jT;
                m_ya = m_jumpTime * m_yJumpSpeed;
                m_onGround = false;
                m_sliding = false;
            } else if (m_sliding && m_mayJump) {
                m_xJumpSpeed = -m_facing * 6.0f;
                m_yJumpSpeed = -2.0f;
                m_jumpTime = -6;
                m_xa = m_xJumpSpeed;
                m_ya = -m_jumpTime * m_yJumpSpeed;
                m_onGround = false;
                m_sliding = false;
                m_facing = -m_facing;
            } else if (m_jumpTime > 0) {
                m_xa += m_xJumpSpeed;
                m_ya = m_jumpTime * m_yJumpSpeed;
                m_jumpTime--;
            }
        } else {
            m_jumpTime = 0;
        }
        if (a_actions[Mario.KEY_LEFT] && !m_ducking) {
            if (m_facing == 1)
                m_sliding = false;
            m_xa -= sideWaysSpeed;
            if (m_jumpTime >= 0)
                m_facing = -1;
        }
        if (a_actions[Mario.KEY_RIGHT] && !m_ducking) {
            if (m_facing == -1)
                m_sliding = false;
            m_xa += sideWaysSpeed;
            if (m_jumpTime >= 0)
                m_facing = 1;
        }
        if ((!a_actions[Mario.KEY_LEFT] && !a_actions[Mario.KEY_RIGHT]) || m_ducking || m_ya < 0 || m_onGround) {
            m_sliding = false;
        }
        m_mayJump = (m_onGround || m_sliding) && !a_actions[Mario.KEY_JUMP];
        m_onGround = false;
        move(m_xa, 0);
        move(0, m_ya);
        //No access to world. It's fair.
        /*if (y > world.level.height * 16 + 16)
        {
            die();
        }*/
        m_ya *= 0.85f;
        if (m_onGround) {
            //GROUND_INERTIA
            m_xa *= 0.89f;
        } else {
            //AIR_INERTIA
            m_xa *= 0.89f;
        }
        if (!m_onGround) {
            // 3;
            m_ya += m_yaa;
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean move( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float a_xa,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float a_ya) {
        while (a_xa > 8) {
            if (!move(8, 0))
                return false;
            a_xa -= 8;
        }
        while (a_xa < -8) {
            if (!move(-8, 0))
                return false;
            a_xa += 8;
        }
        while (a_ya > 8) {
            if (!move(0, 8))
                return false;
            a_ya -= 8;
        }
        while (a_ya < -8) {
            if (!move(0, -8))
                return false;
            a_ya += 8;
        }
        //No collision detection. It's fair.
        m_x += a_xa;
        m_y += a_ya;
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void registerSingleMove( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] a_actions) {
        boolean large = !m_agent.isMarioSmall();
        float sideWaysSpeed = a_actions[Mario.KEY_SPEED] ? 1.2f : 0.6f;
        m_onGroundReg = m_agent.amIOnGround();
        if (m_onGroundReg) {
            m_duckingReg = a_actions[Mario.KEY_DOWN] && large;
        }
        if (m_xaReg > 2) {
            m_facingReg = 1;
        }
        if (m_xaReg < -2) {
            m_facingReg = -1;
        }
        if (a_actions[Mario.KEY_JUMP] || (m_jumpTimeReg < 0 && !m_onGroundReg && !m_slidingReg)) {
            if (m_jumpTimeReg < 0) {
                m_xaReg = m_xJumpSpeedReg;
                m_yaReg = -m_jumpTimeReg * m_yJumpSpeedReg;
                m_jumpTimeReg++;
            } else if (m_onGroundReg && m_mayJumpReg) {
                m_xJumpSpeedReg = 0;
                m_yJumpSpeedReg = -1.9f;
                //7
                m_jumpTimeReg = (int) m_jT;
                m_yaReg = m_jumpTimeReg * m_yJumpSpeedReg;
                m_onGroundReg = false;
                m_slidingReg = false;
            } else if (m_slidingReg && m_mayJumpReg) {
                m_xJumpSpeedReg = -m_facingReg * 6.0f;
                m_yJumpSpeedReg = -2.0f;
                m_jumpTimeReg = -6;
                m_xaReg = m_xJumpSpeedReg;
                m_yaReg = -m_jumpTimeReg * m_yJumpSpeedReg;
                m_onGroundReg = false;
                m_slidingReg = false;
                m_facingReg = -m_facingReg;
            } else if (m_jumpTimeReg > 0) {
                m_xaReg += m_xJumpSpeedReg;
                m_yaReg = m_jumpTimeReg * m_yJumpSpeedReg;
                m_jumpTimeReg--;
            }
        } else {
            m_jumpTimeReg = 0;
        }
        if (a_actions[Mario.KEY_LEFT] && !m_duckingReg) {
            if (m_facingReg == 1)
                m_slidingReg = false;
            m_xaReg -= sideWaysSpeed;
            if (m_jumpTimeReg >= 0)
                m_facingReg = -1;
        }
        if (a_actions[Mario.KEY_RIGHT] && !m_duckingReg) {
            if (m_facingReg == -1)
                m_slidingReg = false;
            m_xaReg += sideWaysSpeed;
            if (m_jumpTimeReg >= 0)
                m_facingReg = 1;
        }
        if ((!a_actions[Mario.KEY_LEFT] && !a_actions[Mario.KEY_RIGHT]) || m_duckingReg || m_yaReg < 0 || m_onGroundReg) {
            m_slidingReg = false;
        }
        m_mayJumpReg = (m_onGroundReg || m_slidingReg) && !a_actions[Mario.KEY_JUMP];
        m_onGroundReg = false;
        m_yaReg *= 0.85f;
        if (m_onGroundReg) {
            //GROUND_INERTIA
            m_xaReg *= 0.89f;
        } else {
            //AIR_INERTIA
            m_xaReg *= 0.89f;
        }
        if (!m_onGroundReg) {
            // 3;
            m_ya += m_yaa;
        }
    }
}
