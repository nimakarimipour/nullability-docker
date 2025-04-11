/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviors.GEBT_Mario;

import ch.idsia.mario.engine.sprites.Sprite;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Map {

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int LEVEL_HEIGHT = 15;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_BLOCK_LENGTH = 100;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAX_JUMP_HEIGHT = 4;

    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAX_JUMP_HEIGHT_PUSH = 6;

    /**
     * ENGINE 0.1.9 **
     */
    //Defined by the engine.
    /*public static final int MAP_OBSTACLE = -127;
    public static final int MAP_SOFT_OBSTACLE = -62; //Those that Mario can jump from the bottom.
    public static final int MAP_SOFT_OBSTACLE2 = -76; //Strange, but this is another one too.
    public static final int MAP_SIMPLE_BRICK = -20;
    public static final int MAP_QUESTION_BRICK = -22;
    //public static final int MAP_POT_OR_CANNON = -85;
    public static final int MAP_COIN_ANIM = 1;

    public static final int MAP_BORDER_CANNOT_PASS_THROUGH = -60;
    public static final int MAP_CANNON_MUZZLE = -82;
    public static final int MAP_CANNON_TRUNK = -80;
    public static final int MAP_FLOWER_POT = -90;
    public static final int MAP_NOTHING = 0;*/
    /**
     * ENGINE 0.1.5 **
     */
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_OBSTACLE = -127;

    //-62; //Those that Mario can jump from the bottom.
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_SOFT_OBSTACLE = -11;

    //Strange, but this is another one too.
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_SOFT_OBSTACLE2 = -76;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_SIMPLE_BRICK = 16;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_QUESTION_BRICK = 21;

    //public static final int MAP_POT_OR_CANNON = -85;
    //CHANGED FOR 0.1.5
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_COIN_ANIM = 34;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_BORDER_CANNOT_PASS_THROUGH = -60;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_CANNON_MUZZLE = -82;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_CANNON_TRUNK = -80;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_FLOWER_POT = -90;

    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_NOTHING = 0;

    @org.checkerframework.dataflow.qual.Pure
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isObstacle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        return //nothing
        a_data != MAP_NOTHING && //border hill, jumpable from the bottom.
        a_data != MAP_SOFT_OBSTACLE && //Breakable brick
        a_data != MAP_SIMPLE_BRICK && //Unbreakable brick
        a_data != MAP_QUESTION_BRICK && //a_data != MAP_POT_OR_CANNON && //Por or cannon for 1 level zoom view
        //a_data != MAP_BORDER_CANNOT_PASS_THROUGH && //Not sure what is this, but obstacle
        a_data != //Muzzle of the cannon
        MAP_CANNON_MUZZLE && //Trunk of the cannon
        a_data != MAP_CANNON_TRUNK && //Flower pot
        a_data != MAP_FLOWER_POT && //COIN!
        a_data != MAP_SOFT_OBSTACLE2 && //COIN!
        a_data != MAP_COIN_ANIM;
    }

    @org.checkerframework.dataflow.qual.Pure
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isPotOrCannon( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        return //a_data == MAP_POT_OR_CANNON || //Por or cannon for 1 level zoom view
        //Muzzle of the cannon
        a_data == MAP_CANNON_MUZZLE || //Trunk of the cannon
        a_data == MAP_CANNON_TRUNK || //Flower pot
        a_data == MAP_FLOWER_POT;
    }

    //Defined by us.
    //One space over a solid block
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_ONE_SPACE_FREE_FLAG = 101;

    //Two spaces over a solid block
    public static final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAP_TWO_SPACES_FREE_FLAG = 102;

    //Used just for dumping to file (write limit).
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_lastCell;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_currentXWritting;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_currentBlockIndex;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int m_currentXInBlockIndex;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<MapBlock> m_levelMap;

    //Graph
    private @org.checkerframework.checker.initialization.qual.UnknownInitialization(grammaticalbehaviors.GEBT_Mario.Graph.class) @org.checkerframework.checker.nullness.qual.NonNull Graph m_levelGraph;

    //data for coins and enemies:
    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<Integer, Vector<Integer>> m_coinCollection;

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<Integer, Vector<Enemy>> m_enemyCollection;

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Hashtable<Integer, Vector<Item>> m_itemCollection;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Map() {
        m_levelMap = new Vector<MapBlock>();
        m_coinCollection = new Hashtable<Integer, Vector<Integer>>();
        m_enemyCollection = new Hashtable<Integer, Vector<Enemy>>();
        m_itemCollection = new Hashtable<Integer, Vector<Item>>();
        m_levelGraph = new Graph(this);
        m_lastCell = -1;
        m_currentXWritting = -1;
        m_currentBlockIndex = -1;
        m_currentXInBlockIndex = -1;
    }

    @org.checkerframework.dataflow.qual.Pure
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isNothing( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        return a_data == MAP_NOTHING || a_data == MAP_COIN_ANIM;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.UnknownInitialization(grammaticalbehaviors.GEBT_Mario.Graph.class) @org.checkerframework.checker.nullness.qual.NonNull Graph getGraph() {
        return m_levelGraph;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCurrentWrittingX( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x) {
        m_currentXWritting = a_x;
        m_currentBlockIndex = (int) (m_currentXWritting / MAP_BLOCK_LENGTH);
        m_currentXInBlockIndex = (int) (m_currentXWritting % MAP_BLOCK_LENGTH);
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull MapBlock getBlock( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_blockNumber) {
        if (a_blockNumber >= m_levelMap.size()) {
            //We need to create a new block
            m_levelMap.add(new MapBlock());
        }
        return m_levelMap.get(a_blockNumber);
    }

    @org.checkerframework.dataflow.qual.Impure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte preprocessData( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        if (//Gather all types of obstacles.
        Map.isObstacle(a_data)) {
            return Map.MAP_OBSTACLE;
        }
        /*if(Map.isPotOrCannon(a_data))
        {
            return Map.MAP_POT_OR_CANNON;
        }*/
        if (a_data == Map.MAP_SOFT_OBSTACLE2) {
            return Map.MAP_SOFT_OBSTACLE;
        }
        if (a_data == Map.MAP_COIN_ANIM) {
            if (!m_coinCollection.containsKey(a_x)) {
                m_coinCollection.put(a_x, new Vector<Integer>());
            }
            m_coinCollection.get(a_x).add(a_y);
        }
        return a_data;
    }

    //X is defined by m_currentXWritting
    @org.checkerframework.dataflow.qual.Impure
    public void writeLevel( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        //Check boundaries
        if (m_currentXWritting == -1 || a_y < 0 || a_y >= LEVEL_HEIGHT)
            return;
        //Preprocess data:
        a_data = preprocessData(m_currentXWritting, a_y, a_data);
        getBlock(m_currentBlockIndex).write(m_currentXInBlockIndex, a_y, a_data);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void flushEnemiesAndItems() {
        m_enemyCollection.clear();
        m_itemCollection.clear();
    }

    //X is defined by m_currentXWritting
    @org.checkerframework.dataflow.qual.Impure
    public void writeEnemy( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte a_data) {
        //Check boundaries
        if (m_currentXWritting == -1 || a_y < 0 || a_y >= LEVEL_HEIGHT)
            return;
        if (a_data == Sprite.KIND_MUSHROOM || a_data == Sprite.KIND_FIRE_FLOWER) {
            if (!m_itemCollection.containsKey(m_currentXWritting)) {
                m_itemCollection.put(m_currentXWritting, new Vector<Item>());
            }
            m_itemCollection.get(m_currentXWritting).add(new Item(m_currentXWritting, a_y, a_data));
        } else {
            if (!m_enemyCollection.containsKey(m_currentXWritting)) {
                m_enemyCollection.put(m_currentXWritting, new Vector<Enemy>());
            }
            m_enemyCollection.get(m_currentXWritting).add(new Enemy(m_currentXWritting, a_y, a_data));
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkForEnemyType( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xSrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xDest,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ySrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_yDest,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_type) {
        int min_x = Math.min(a_xSrc, a_xDest);
        int min_y = Math.min(a_ySrc, a_yDest);
        int max_x = Math.max(a_xSrc, a_xDest);
        int max_y = Math.max(a_ySrc, a_yDest);
        if (min_x < 0)
            min_x = 0;
        if (max_y >= 15)
            max_y = 14;
        if (min_y < 0)
            min_y = 0;
        for (int x = min_x; x <= max_x; ++x) {
            for (int y = min_y; y <= max_y; ++y) {
                if (m_enemyCollection.containsKey(x)) {
                    Vector<Enemy> enemies = m_enemyCollection.get(x);
                    for (int i = 0; i < enemies.size(); ++i) {
                        Enemy en = enemies.elementAt(i);
                        if (en.m_type == a_type && en.m_y == y) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void updateLastCell() {
        //Update last cell written
        if (m_currentXWritting > m_lastCell)
            m_lastCell = m_currentXWritting;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull byte read(int a_x, int a_y) {
        //Check boundaries
        if (a_y < 0 || a_y >= LEVEL_HEIGHT)
            return -1;
        //Get the block for this position
        int blockIndex = (int) (a_x / MAP_BLOCK_LENGTH);
        int xInBlock = (int) (a_x % MAP_BLOCK_LENGTH);
        if (blockIndex < m_levelMap.size()) {
            return getBlock(blockIndex).read(xInBlock, a_y);
        }
        return -1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void dumpToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int h = 14; h >= 0; --h) {
                for (int w = 0; w < m_lastCell; ++w) {
                    //Get the block for this position
                    int blockIndex = (int) (w / MAP_BLOCK_LENGTH);
                    int xInBlock = (int) (w % MAP_BLOCK_LENGTH);
                    getBlock(blockIndex).dumpToFile(bw, xInBlock, h);
                }
                //End of this line
                bw.newLine();
            }
            //And that's all!
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public void dumpToFileProcessing(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("void setup() { size(" + m_lastCell * 10 + ", 240); background(134,183,183); }");
            bw.newLine();
            bw.write("void draw() {");
            bw.newLine();
            for (int h = 14; h >= 0; --h) {
                for (int w = 0; w < m_lastCell; ++w) {
                    //Get the block for this position
                    int blockIndex = (int) (w / MAP_BLOCK_LENGTH);
                    int xInBlock = (int) (w % MAP_BLOCK_LENGTH);
                    //getBlock(blockIndex).dumpToFile(bw,xInBlock,h);
                    getBlock(blockIndex).dumpToFileProcessing(bw, xInBlock, h, w);
                }
                //End of this line
                bw.newLine();
            }
            //Print graph
            m_levelGraph.dumpProcessing(bw);
            bw.write("}");
            bw.newLine();
            //And that's all!
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //returns an integer: 0: no standing, 1 means small, 2 means big
    @org.checkerframework.dataflow.qual.Pure
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int CanMarioStand( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_data) {
        if (a_data == Map.MAP_ONE_SPACE_FREE_FLAG)
            return 1;
        if (a_data == Map.MAP_TWO_SPACES_FREE_FLAG)
            return 2;
        return 0;
    }

    @org.checkerframework.dataflow.qual.Pure
    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isSomethingSolid( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_data) {
        return (a_data == Map.MAP_OBSTACLE || a_data == Map.MAP_SIMPLE_BRICK || //a_data == Map.MAP_POT_OR_CANNON ||
        isPotOrCannon((byte) a_data) || a_data == Map.MAP_QUESTION_BRICK);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void processGraph( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xInit,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xEnd) {
        m_levelGraph = new Graph(this);
        //Some important checks!
        int xInit = (a_xInit <= 0) ? 1 : a_xInit;
        int xEnd = (a_xEnd > m_lastCell) ? m_lastCell : a_xEnd;
        if (xInit > xEnd)
            return;
        int currentBlockIndex = 0;
        int currentXInBlockIndex = 0;
        //For each horizontal line:
        for (int h = 0; h < 15; ++h) {
            int nodeAX = 0, nodeAY = 0;
            //Watch out: This does not count the free flags
            //0 means not found, 1 found and looking for the end of free flags row
            int freeflagOnThisRow = 0;
            //0: means no running, 1 means small, 2 means big
            int runningSize = 0;
            //Search for a FREE_FLAG:
            for (int cX = xInit; cX <= xEnd; ++cX) {
                //TODO? Watch out when breaking blocks: New links appear, old can be broken
                //EX: (27,3) -> (28,6) should dissappear. Not sure if it is worth to
                //implement this, maybe is better to have a complete new snapshot every time!
                currentBlockIndex = (int) (cX / MAP_BLOCK_LENGTH);
                currentXInBlockIndex = (int) (cX % MAP_BLOCK_LENGTH);
                byte dataInMap = getBlock(currentBlockIndex).read(currentXInBlockIndex, h);
                int thisStand = CanMarioStand(dataInMap);
                if (thisStand > 0) {
                    //Check verticals:
                    boolean stop = false;
                    int vert = h + 1;
                    boolean overSoftFlag = false;
                    boolean youWontFall = false;
                    boolean tooHigh = false;
                    boolean tooHighPush = false;
                    //Watch out: DO not change the order (always up to down)
                    while (vert < 15 && !stop) {
                        byte dataInVertical = getBlock(currentBlockIndex).read(currentXInBlockIndex, vert);
                        byte dataInVerticalPlus1 = Map.MAP_NOTHING;
                        if (vert < 14)
                            dataInVerticalPlus1 = getBlock(currentBlockIndex).read(currentXInBlockIndex, vert + 1);
                        //First of all, if we are oversoft, add a link.
                        if (overSoftFlag) {
                            //Add node and link! (These are vertical jumps)
                            int aId = m_levelGraph.addNode(cX, h);
                            int bId = m_levelGraph.addNode(cX, vert);
                            if (dataInVertical == Map.MAP_ONE_SPACE_FREE_FLAG) {
                                m_levelGraph.addEdge(aId, bId, Graph.MODE_JUMP_SMALL);
                            } else if (dataInVertical == Map.MAP_TWO_SPACES_FREE_FLAG) {
                                m_levelGraph.addEdge(aId, bId, Graph.MODE_JUMP_BIG);
                            }
                            overSoftFlag = false;
                            stop = true;
                            continue;
                        }
                        if (Map.isSomethingSolid(dataInVertical)) {
                            stop = true;
                            //Add metadata to the node below, if applicable
                            if (!tooHighPush) {
                                int aId = m_levelGraph.addNode(cX, h);
                                Node below = m_levelGraph.getNode(aId);
                                below.setMetadata(dataInVertical);
                            }
                            boolean reallyHigh = (vert + 1 - h > MAX_JUMP_HEIGHT) || (vert + 1 >= 15);
                            //Add breakable nodes?
                            if (!reallyHigh && dataInVertical == Map.MAP_SIMPLE_BRICK) {
                                //################
                                //Check right and left.
                                int blockLeft = (int) ((cX - 1) / MAP_BLOCK_LENGTH);
                                int inBlockLeft = (int) ((cX - 1) % MAP_BLOCK_LENGTH);
                                int blockRight = (int) ((cX + 1) / MAP_BLOCK_LENGTH);
                                int inBlockRight = (int) ((cX + 1) % MAP_BLOCK_LENGTH);
                                byte dataOnLeft = getBlock(blockLeft).read(inBlockLeft, vert + 1);
                                if (CanMarioStand(dataOnLeft) > 0) {
                                    //Add node and link!
                                    int aId = m_levelGraph.addNode(cX, h);
                                    int bId = m_levelGraph.addNode(cX - 1, vert + 1);
                                    int mode = Graph.MODE_BREAKABLE;
                                    m_levelGraph.addBreakableEdge(aId, bId, mode);
                                }
                                byte dataOnRight = getBlock(blockRight).read(inBlockRight, vert + 1);
                                if (CanMarioStand(dataOnRight) > 0) {
                                    //Add node and link!
                                    int aId = m_levelGraph.addNode(cX, h);
                                    int bId = m_levelGraph.addNode(cX + 1, vert + 1);
                                    int mode = Graph.MODE_BREAKABLE;
                                    m_levelGraph.addBreakableEdge(aId, bId, mode);
                                }
                                //################
                            }
                        } else {
                            //Check special case: soft obstacles can be jump from under them.
                            if (dataInVertical == Map.MAP_SOFT_OBSTACLE) {
                                //We'll add the link in the next cycle (to avoid out of bounds).
                                overSoftFlag = true;
                                youWontFall = true;
                            }
                            //Check right and left.
                            int blockLeft = (int) ((cX - 1) / MAP_BLOCK_LENGTH);
                            int inBlockLeft = (int) ((cX - 1) % MAP_BLOCK_LENGTH);
                            int blockRight = (int) ((cX + 1) / MAP_BLOCK_LENGTH);
                            int inBlockRight = (int) ((cX + 1) % MAP_BLOCK_LENGTH);
                            byte dataOnLeft = getBlock(blockLeft).read(inBlockLeft, vert);
                            if (CanMarioStand(dataOnLeft) > 0) {
                                //Add node and link!
                                int aId = m_levelGraph.addNode(cX, h);
                                int bId = m_levelGraph.addNode(cX - 1, vert);
                                int mode = -1;
                                if (tooHigh && !youWontFall) {
                                    if (dataOnLeft == MAP_ONE_SPACE_FREE_FLAG)
                                        mode = Graph.MODE_FALL_SMALL;
                                    else if (dataOnLeft == MAP_TWO_SPACES_FREE_FLAG) {
                                        if (isSomethingSolid(dataInVerticalPlus1)) {
                                            mode = Graph.MODE_FALL_SMALL;
                                        } else {
                                            mode = Graph.MODE_FALL_BIG;
                                        }
                                    }
                                } else if (!tooHigh) {
                                    if (dataOnLeft == MAP_ONE_SPACE_FREE_FLAG)
                                        mode = Graph.MODE_JUMP_SMALL;
                                    else if (dataOnLeft == MAP_TWO_SPACES_FREE_FLAG) {
                                        if (isSomethingSolid(dataInVerticalPlus1)) {
                                            mode = Graph.MODE_JUMP_SMALL;
                                        } else {
                                            mode = Graph.MODE_JUMP_BIG;
                                        }
                                    }
                                }
                                if (mode != -1) {
                                    m_levelGraph.addEdge(aId, bId, mode);
                                }
                                //Check what is under this position:
                                byte dataOnLeftUnder = getBlock(blockLeft).read(inBlockLeft, vert - 1);
                                if (isPotOrCannon(dataOnLeftUnder)) //if(dataOnLeftUnder == Map.MAP_POT_OR_CANNON)
                                {
                                    m_levelGraph.getNode(bId).setMetadata(dataOnLeftUnder);
                                }
                            }
                            byte dataOnRight = getBlock(blockRight).read(inBlockRight, vert);
                            if (CanMarioStand(dataOnRight) > 0) {
                                //Add node and link!
                                int aId = m_levelGraph.addNode(cX, h);
                                int bId = m_levelGraph.addNode(cX + 1, vert);
                                int mode = -1;
                                if (tooHigh && !youWontFall) {
                                    if (dataOnRight == MAP_ONE_SPACE_FREE_FLAG)
                                        mode = Graph.MODE_FALL_SMALL;
                                    else if (dataOnRight == MAP_TWO_SPACES_FREE_FLAG) {
                                        if (isSomethingSolid(dataInVerticalPlus1)) {
                                            mode = Graph.MODE_FALL_SMALL;
                                        } else {
                                            mode = Graph.MODE_FALL_BIG;
                                        }
                                    }
                                } else if (!tooHigh) {
                                    if (dataOnRight == MAP_ONE_SPACE_FREE_FLAG)
                                        mode = Graph.MODE_JUMP_SMALL;
                                    else if (dataOnRight == MAP_TWO_SPACES_FREE_FLAG) {
                                        if (isSomethingSolid(dataInVerticalPlus1)) {
                                            mode = Graph.MODE_JUMP_SMALL;
                                        } else {
                                            mode = Graph.MODE_JUMP_BIG;
                                        }
                                    }
                                }
                                if (mode != -1) {
                                    m_levelGraph.addEdge(aId, bId, mode);
                                }
                                //Check what is under this position:
                                byte dataOnRightUnder = getBlock(blockRight).read(inBlockRight, vert - 1);
                                if (isPotOrCannon(dataOnRightUnder)) //if(dataOnRightUnder == Map.MAP_POT_OR_CANNON)
                                {
                                    m_levelGraph.getNode(bId).setMetadata(dataOnRightUnder);
                                }
                            }
                        }
                        //end - Not something solid!
                        vert++;
                        //Check if we can reach higher points.
                        int jumpHeight = vert - h;
                        if (jumpHeight > MAX_JUMP_HEIGHT)
                            //Reached top height for jump, from now on we can only FALL.
                            tooHigh = true;
                        if (jumpHeight > MAX_JUMP_HEIGHT_PUSH)
                            tooHighPush = true;
                    }
                    //end - while checking vertical
                }
                //end dataInMap == MAP_TWO_SPACES_FREE_FLAG
                //Check horizontals:
                //if(freeflagOnThisRow == 0 && dataInMap == MAP_TWO_SPACES_FREE_FLAG )
                if (freeflagOnThisRow == 0 && thisStand > 0) {
                    //Free flag found!
                    //We have to keep going right until no free flag.
                    freeflagOnThisRow++;
                    nodeAX = cX;
                    nodeAY = h;
                    runningSize = thisStand;
                } else if (freeflagOnThisRow == 1 && thisStand > 0) {
                    //Add a new node.
                    //We were linking from here
                    int aId = m_levelGraph.addNode(nodeAX, nodeAY);
                    int bId = m_levelGraph.addNode(cX, h);
                    if (thisStand == 1)
                        m_levelGraph.addEdge(aId, bId, Graph.MODE_WALK_SMALL);
                    else if (thisStand == 2)
                        m_levelGraph.addEdge(aId, bId, Graph.MODE_WALK_BIG);
                    //Link from here now.
                    nodeAX = cX;
                    nodeAY = h;
                    //freeflagOnThisRow = 0;
                } else if (freeflagOnThisRow == 1 && thisStand == 0) {
                    //End of the flag. Create nodes and edge.
                    freeflagOnThisRow = 0;
                    int nodeBX = cX - 1;
                    int nodeBY = h;
                    //Lets check if source and dest are the same.
                    //It can happen: XXAXX or XXXA
                    if ((nodeBX == nodeAX) && (nodeBY == nodeAY)) {
                        //no edge or nodes: Not to itself and the node will be created
                        //if some other node can reach this.
                        //continue;
                    } else {
                        int aId = m_levelGraph.addNode(nodeAX, nodeAY);
                        int bId = m_levelGraph.addNode(nodeBX, nodeBY);
                        if (runningSize == 1)
                            m_levelGraph.addEdge(aId, bId, Graph.MODE_WALK_SMALL);
                        else if (runningSize == 2)
                            m_levelGraph.addEdge(aId, bId, Graph.MODE_WALK_BIG);
                    }
                    //Try some jumps
                    if (Map.isNothing(dataInMap)) {
                        //And here, we should check if a faith jump is possible!
                        graphCheckJumps(cX - 1, nodeBY, runningSize, xEnd);
                    }
                    //Lets try to avoid annoying cannons (or bricks)
                    if (dataInMap == Map.MAP_CANNON_TRUNK || dataInMap == Map.MAP_CANNON_MUZZLE || dataInMap == Map.MAP_SIMPLE_BRICK || dataInMap == Map.MAP_QUESTION_BRICK) {
                        //is it a cannon?
                        int blockRight = (int) ((cX + 1) / MAP_BLOCK_LENGTH);
                        int inBlockRight = (int) ((cX + 1) % MAP_BLOCK_LENGTH);
                        byte dataOnRight = getBlock(blockRight).read(inBlockRight, h);
                        boolean dataOk = dataOnRight != Map.MAP_CANNON_TRUNK && dataOnRight != Map.MAP_CANNON_MUZZLE && dataOnRight != Map.MAP_SIMPLE_BRICK && dataOnRight != Map.MAP_QUESTION_BRICK;
                        if (dataOk && h + 2 < 15) {
                            //For our understanding, this is a cannon.
                            //Let's check the height of the cannon
                            //byte dataOverThere1 =  getBlock(currentBlockIndex).read(currentXInBlockIndex,h+1);
                            byte dataOverThere2 = getBlock(currentBlockIndex).read(currentXInBlockIndex, h + 2);
                            if (Map.isNothing(dataOverThere2)) {
                                int aId = m_levelGraph.addNode(cX - 1, h);
                                int bId = m_levelGraph.addNode(cX + 1, h);
                                int distanceFaith = 2;
                                if (runningSize == 1 || dataOnRight == Map.MAP_ONE_SPACE_FREE_FLAG) {
                                    int mode = Graph.MODE_FAITH_JUMP + distanceFaith;
                                    m_levelGraph.addEdge(aId, bId, mode);
                                } else if (runningSize == 2) {
                                    int mode = (Graph.MODE_FAITH_JUMP * 2) + distanceFaith;
                                    m_levelGraph.addEdge(aId, bId, mode);
                                }
                            }
                        }
                    }
                }
                // end - check horizontals
            }
            // end for - x
        }
        //end for - h
        //graphCheckJumps(a_xInit, a_xEnd);
    }

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MAX_DIST_JUMP = 5;

    @org.checkerframework.dataflow.qual.Impure
    public void graphCheckJumps( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xInit,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_height,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_runSize,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xEnd) {
        //Some important checks!
        int xInit = (a_xInit < 0) ? 0 : a_xInit;
        int xEnd = (a_xEnd > m_lastCell) ? m_lastCell : a_xEnd;
        if (xInit > xEnd)
            return;
        int maxHorJump = 6;
        for (int i = 0; i < maxHorJump; ++i) {
            //Checking the level data in the positions marked with X.
            //  X
            //  XX
            //  XXX
            //  XXXX
            //  XXXXX
            //I XXXXXX (I=Init point).
            //  XXXXX
            //  XXXX
            //  XXX
            //  XX
            //  X
            int yMin = a_height - ((maxHorJump - 1) - i);
            //Check bounds.
            if (yMin < 0)
                yMin = 0;
            int yMax = a_height + ((maxHorJump - 1) - i);
            //Check bounds.
            if (yMax > 14)
                yMax = 14;
            int x = xInit + i + 2;
            if (x >= m_lastCell)
                x = m_lastCell - 1;
            for (int j = yMin; j < yMax; ++j) {
                int currentBlockIndex = (int) (x / MAP_BLOCK_LENGTH);
                int currentXInBlockIndex = (int) (x % MAP_BLOCK_LENGTH);
                byte dataInMap = getBlock(currentBlockIndex).read(currentXInBlockIndex, j);
                int thisStand = CanMarioStand(dataInMap);
                if (thisStand > 0 && thisStand >= a_runSize) {
                    //Check if I can jump
                    boolean jumpAvailable = checkJump(a_xInit, a_height, x, j);
                    if (jumpAvailable) {
                        //Check hole under jump
                        boolean hole = checkHoleUnderJump(a_xInit, a_height, x, j);
                        //Add node
                        int aId = m_levelGraph.addNode(a_xInit, a_height);
                        int bId = m_levelGraph.addNode(x, j);
                        int size = thisStand < a_runSize ? thisStand : a_runSize;
                        int distanceFaith = Math.abs(a_xInit - x);
                        int mode = (Graph.MODE_FAITH_JUMP * size) + distanceFaith;
                        m_levelGraph.addEdge(aId, bId, mode);
                        if (hole) {
                            Edge edg = m_levelGraph.getEdge(aId, bId);
                            if (edg != null)
                                edg.setMetadata(Edge.META_HOLE);
                            edg = m_levelGraph.getEdge(bId, aId);
                            if (edg != null)
                                edg.setMetadata(Edge.META_HOLE);
                        }
                    }
                }
            }
        }
    }

    //Enemies, coins and items.
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int checkVolatileUp( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Enemy> a_enemies, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Vector<Item> a_items) {
        int numCoins = 0;
        int i = a_y;
        boolean end = false;
        int currentBlockIndex = (int) (a_x / MAP_BLOCK_LENGTH);
        int currentXInBlockIndex = (int) (a_x % MAP_BLOCK_LENGTH);
        while (!end && i < 15) {
            int jumpHeight = i - a_y;
            byte dataInMap = getBlock(currentBlockIndex).read(currentXInBlockIndex, i);
            if (Map.isSomethingSolid(dataInMap) || dataInMap == Map.MAP_SOFT_OBSTACLE) {
                //Something solid up. I cant reach higher, end of analysis.
                end = true;
            } else {
                //Check for coins
                if ((m_coinCollection.get(a_x) != null) && (m_coinCollection.get(a_x).contains(i))) {
                    //A coin! :D
                    if (jumpHeight <= MAX_JUMP_HEIGHT_PUSH) {
                        numCoins++;
                    }
                }
                //Check for enemies
                Enemy here = thereIsEnemy(m_enemyCollection.get(a_x), i);
                if (here != null) {
                    //An enemy! :S
                    a_enemies.add(here);
                }
                Item hereIt = thereIsItem(m_itemCollection.get(a_x), i);
                if (hereIt != null) {
                    //An item! :D
                    a_items.add(hereIt);
                }
                ++i;
            }
        }
        return numCoins;
    }

    @org.checkerframework.dataflow.qual.Pure
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Enemy thereIsEnemy(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Vector<Enemy> a_enemies,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y) {
        if (a_enemies == null || a_enemies.isEmpty()) {
            return null;
        }
        for (int i = 0; i < a_enemies.size(); ++i) {
            if (a_enemies.get(i).m_y == a_y) {
                return a_enemies.get(i);
            }
        }
        return null;
    }

    @org.checkerframework.dataflow.qual.Pure
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Item thereIsItem(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Vector<Item> a_items,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y) {
        if (a_items == null || a_items.isEmpty()) {
            return null;
        }
        for (int i = 0; i < a_items.size(); ++i) {
            if (a_items.get(i).m_y == a_y) {
                return a_items.get(i);
            }
        }
        return null;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int checkHoleOnSides( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_x,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_y) {
        //Check right
        boolean onRight = false;
        if ((m_lastCell > a_x + 1) && !checkObstacle(a_x + 1, 0, a_x + 1, a_y)) {
            onRight = true;
        }
        //Check left
        boolean onLeft = false;
        if (!checkObstacle(a_x - 1, 0, a_x - 1, a_y)) {
            onLeft = true;
        }
        //RETURN SOMETHING
        if (onRight && onLeft)
            return Node.MAP_HOLE_ON_BOTH;
        else if (onRight)
            return Node.MAP_HOLE_ON_RIGHT;
        else if (onLeft)
            return Node.MAP_HOLE_ON_LEFT;
        else
            return MAP_OBSTACLE;
    }

    @org.checkerframework.dataflow.qual.Impure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkHoleUnderJump( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xSrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ySrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xDest,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_yDest) {
        //Min height:
        int minHeight = Math.min(a_ySrc, a_yDest);
        int minX = Math.min(a_xSrc, a_xDest) + 1;
        int maxX = Math.max(a_xSrc, a_xDest) - 1;
        for (int i = minX; i <= maxX; ++i) {
            boolean obstacleInThisX = checkObstacle(i, 0, i, minHeight);
            if (!obstacleInThisX)
                return true;
        }
        return false;
    }

    //aX must be lower than bX, otherwise this function doesn't work.
    @org.checkerframework.dataflow.qual.Impure
    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkJump( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ax,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ay,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_bx,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_by) {
        boolean obstacle = false;
        //at least this must be 2. Greater if more restristive for jumps
        int heightCheck = 3;
        // (it would check for higher obstacles than the dest point).
        /* if(a_ax == 69 && a_ay == 11 && a_bx == 71 && a_by == 10)
        {
            int a  = 0;
        } */
        if (Math.abs(a_ax - a_bx) < 4)
            heightCheck = 2;
        //Same height
        if (a_ay == a_by) {
            obstacle = checkObstacle(a_ax, a_by + 1, a_bx, a_by + heightCheck);
        } else if (//jump to a higher place.
        a_ay < a_by) {
            obstacle = checkObstacle(a_ax, a_by + 1, a_bx, a_by + heightCheck);
            if (!obstacle)
                obstacle = checkObstacle(a_ax, a_ay + 1, a_bx - 1, a_by);
        } else //jump to a lower place.
        {
            obstacle = checkObstacle(a_ax, a_ay + 1, a_bx, a_ay + heightCheck);
            if (!obstacle)
                obstacle = checkObstacle(a_ax + 2, a_ay, a_bx, a_by + 1);
        }
        return !obstacle;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkObstacle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xSrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ySrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xDest,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_yDest) {
        int min_x = Math.min(a_xSrc, a_xDest);
        int min_y = Math.min(a_ySrc, a_yDest);
        int max_x = Math.max(a_xSrc, a_xDest);
        int max_y = Math.max(a_ySrc, a_yDest);
        if (min_x < 0)
            min_x = 0;
        if (max_y >= 15)
            max_y = 14;
        if (min_y < 0)
            min_y = 0;
        for (int x = min_x; x <= max_x; ++x) {
            for (int y = min_y; y <= max_y; ++y) {
                int currentBlockIndex = (int) (x / MAP_BLOCK_LENGTH);
                int currentXInBlockIndex = (int) (x % MAP_BLOCK_LENGTH);
                byte dataInMap = getBlock(currentBlockIndex).read(currentXInBlockIndex, y);
                if (isSomethingSolid(dataInMap))
                    return true;
            }
        }
        return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean checkSolid( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xSrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_ySrc,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_xDest,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int a_yDest) {
        int min_x = Math.min(a_xSrc, a_xDest);
        int min_y = Math.min(a_ySrc, a_yDest);
        int max_x = Math.max(a_xSrc, a_xDest);
        int max_y = Math.max(a_ySrc, a_yDest);
        if (min_x < 0)
            min_x = 0;
        if (max_y >= 15)
            max_y = 14;
        if (min_y < 0)
            min_y = 0;
        for (int x = min_x; x <= max_x; ++x) {
            for (int y = min_y; y <= max_y; ++y) {
                int currentBlockIndex = (int) (x / MAP_BLOCK_LENGTH);
                int currentXInBlockIndex = (int) (x % MAP_BLOCK_LENGTH);
                byte dataInMap = getBlock(currentBlockIndex).read(currentXInBlockIndex, y);
                if (!isSomethingSolid(dataInMap))
                    return false;
            }
        }
        return true;
    }
}
