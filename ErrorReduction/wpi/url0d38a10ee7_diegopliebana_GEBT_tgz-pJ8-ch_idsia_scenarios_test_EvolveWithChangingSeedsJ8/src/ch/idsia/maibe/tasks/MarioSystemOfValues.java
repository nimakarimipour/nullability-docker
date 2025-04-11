package ch.idsia.maibe.tasks;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, sergey at idsia dot ch
 * Date: Mar 27, 2010 Time: 5:55:38 PM
 * Package: ch.idsia.scenarios.champ
 */
/**
 * tune the parameters of the multiobjective function with MarioSystemOfValues class
 * assigning a high value to a certain parameter should steer your agent to maximize
 * objective function w.r.t this value,
 * e.g.
 * assigning timeLeft = 0 and coins = 1000 should make your agent collect all coins before
 * advanching to finish. If win = 0 as well, this agent will not have motivation to win.
 * or
 * very high value of kills should produce a true `MARIONATOR`, making him a perfect killer.
 * By tuning killedByFire, killedByShell, killedByStomp you make the killer
 * stylish and of refined manners.
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class MarioSystemOfValues extends SystemOfValues {

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int distance = 1;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int win = 1024;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int mode = 32;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int coins = 16;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int hiddenItems = 24;

    // not used for now
    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int flowerFire = 64;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int kills = 42;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int killedByFire = 4;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int killedByShell = 17;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int killedByStomp = 12;

    final public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int timeLeft = 8;

    public interface timeLengthMapping {

        final public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int TIGHT = 10;

        final public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int MEDIUM = 20;

        final public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int FLEXIBLE = 30;
    }
}
