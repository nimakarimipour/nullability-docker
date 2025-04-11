/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.GEBT_Mario;

import ch.idsia.mario.engine.sprites.Sprite;
import java.util.Vector;

/**
 * Node for a Graph.
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Node {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_id;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_x;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_y;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Long> m_edges;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Enemy> m_enemies;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Item> m_items;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_metadata;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_holes;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_coins;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_HOLE_ON_LEFT = -1000;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_HOLE_ON_RIGHT = -1001;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_HOLE_ON_BOTH = -1002;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Node() {
        m_id = -1;
        m_x = -1;
        m_y = -1;
        m_coins = 0;
        m_holes = 0;
        m_edges = new Vector<Long>();
        m_enemies = new Vector<Enemy>();
        m_items = new Vector<Item>();
        m_metadata = Map.MAP_NOTHING;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Node( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_id,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y) {
        m_id = a_id;
        m_x = a_x;
        m_y = a_y;
        m_coins = 0;
        m_holes = 0;
        m_edges = new Vector<Long>();
        m_enemies = new Vector<Enemy>();
        m_items = new Vector<Item>();
        m_metadata = Map.MAP_NOTHING;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void addEdge( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long a_id) {
        m_edges.add(a_id);
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getID() {
        return m_id;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getX() {
        return m_x;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getY() {
        return m_y;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Long> getEdgesFromNode() {
        return m_edges;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMetadata( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_meta) {
        m_metadata = a_meta;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getMetadata() {
        return m_metadata;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setHoles( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_h) {
        m_holes = a_h;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getHoles() {
        return m_holes;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCoins( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_c) {
        m_coins = a_c;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getCoins() {
        return m_coins;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setEnemies(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Enemy> a_enemies) {
        m_enemies = a_enemies;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Enemy> getEnemies() {
        return m_enemies;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setItems(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Item> a_items) {
        m_items = a_items;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Item> getItems() {
        return m_items;
    }

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float COIN_WEIGHT = 0f;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ITEM_WEIGHT_SMALL = -10f;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ITEM_WEIGHT_BIG = -15f;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ITEM_WEIGHT_FIRE = -20f;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ENEMY_WEIGHT_STOMP_SLOW = 8;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ENEMY_WEIGHT_STOMP_FAST = 16;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ENEMY_WEIGHT_WINGED = 24;

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float ENEMY_WEIGHT_SPIKY = 32;

    //Cost dependant on coins, enemies, items.
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int internalCost(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull GEBT_MarioAgent a_agent) {
        //Coin factor.
        float coinWeight = COIN_WEIGHT;
        int costCoins = (int) (m_coins * coinWeight);
        //Item factor.
        //Small Mario: risk to die!
        float itemWeight = ITEM_WEIGHT_SMALL;
        if (a_agent.isMarioLarge())
            //Possibility to fire but risk to be small
            itemWeight = ITEM_WEIGHT_BIG;
        if (a_agent.isMarioFire())
            //Possibility to keep fire if damaged in the way
            itemWeight = ITEM_WEIGHT_FIRE;
        int costItems = (int) (itemWeight * m_items.size());
        //Enemy factor
        float costEnemies = 0;
        int numEnemies = m_enemies.size();
        for (int i = 0; i < numEnemies; ++i) {
            Enemy en = m_enemies.elementAt(i);
            float thisCost = getEnemyWeight(en.m_type);
            costEnemies += thisCost;
        }
        int totalCost = /*costCoins + costItems +*/
        (int) costEnemies;
        return totalCost;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int manhattanDistanceTo(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Node a_other) {
        int xDiff = Math.abs(m_x - a_other.getX());
        int yDiff = Math.abs(m_y - a_other.getY());
        return xDiff + yDiff;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int manhattanDistanceTo( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y) {
        int xDiff = Math.abs(m_x - a_x);
        int yDiff = Math.abs(m_y - a_y);
        return xDiff + yDiff;
    }

    @org.checkerframework.dataflow.qual.Pure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull float getEnemyWeight( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_type) {
        switch(a_type) {
            case (Sprite.KIND_GOOMBA):
            case (Sprite.KIND_GREEN_KOOPA):
            case (Sprite.KIND_RED_KOOPA):
                return ENEMY_WEIGHT_STOMP_SLOW;
            case (Sprite.KIND_SHELL):
            case (Sprite.KIND_BULLET_BILL):
                return ENEMY_WEIGHT_STOMP_FAST;
            case (Sprite.KIND_RED_KOOPA_WINGED):
            case (Sprite.KIND_GOOMBA_WINGED):
            case (Sprite.KIND_GREEN_KOOPA_WINGED):
                return ENEMY_WEIGHT_WINGED;
            case (Sprite.KIND_SPIKY):
            case (Sprite.KIND_ENEMY_FLOWER):
            case (Sprite.KIND_SPIKY_WINGED):
                return ENEMY_WEIGHT_SPIKY;
        }
        return 1;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isFlowerOut(@org.checkerframework.checker.initialization.qual.UnknownInitialization(grammaticalbehaviors.GEBT_Mario.Graph.class) @org.checkerframework.checker.nullness.qual.NonNull Graph a_graph) {
        //First, see this node.
        for (int i = 0; i < m_enemies.size(); ++i) {
            if (m_enemies.get(i).m_type == Sprite.KIND_ENEMY_FLOWER) {
                return true;
            }
        }
        //If not, I have neighbors IN THE SAME POT that could have the flower.
        int numN = m_edges.size();
        for (int i = 0; i < numN; ++i) {
            Edge edg = a_graph.getEdge(m_edges.get(i));
            if (edg != null && (edg.getMode() == Graph.MODE_WALK_BIG || edg.getMode() == Graph.MODE_WALK_SMALL)) {
                int nodeId = edg.getA() != m_id ? edg.getA() : edg.getB();
                Node n = a_graph.getNode(nodeId);
                Vector<Enemy> destEnemies = n.getEnemies();
                for (int j = 0; j < destEnemies.size(); ++j) {
                    if (destEnemies.get(j).m_type == Sprite.KIND_ENEMY_FLOWER) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
