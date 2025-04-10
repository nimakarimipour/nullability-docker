package ch.idsia.mario.engine;

import ch.idsia.tools.GameViewer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public abstract class GlobalOptions {

    public static final int primaryVerionUID = 0;

    public static final int minorVerionUID = 1;

    public static final int minorSubVerionID = 5;

    public static boolean areLabels = false;

    public static boolean isMarioAlwaysInCenter = false;

    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Integer FPS = 24;

    public static int MaxFPS = 100;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isPauseWorld = false;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isVisualization = true;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isGameVeiwer = true;

    private static GameViewer GameViewer = null;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isTimer = true;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isGameVeiwerContinuousUpdates = false;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isPowerRestoration;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int observationGridWidth = -1;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int observationGridHeight = -1;

    private static MarioVisualComponent marioVisualComponent;

    public static final int VISUAL_COMPONENT_WIDTH = 320;

    public static final int VISUAL_COMPONENT_HEIGHT = 240;

    public static boolean isMatrixView;

    public static  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isShowGrid = false;

    public static int getPrimaryVersionUID() {
        return primaryVerionUID;
    }

    public static int getMinorVersionUID() {
        return minorVerionUID;
    }

    public static int getMinorSubVerionID() {
        return minorSubVerionID;
    }

    public static String getVersionUID() {
        return " v-" + getPrimaryVersionUID() + "." + getMinorVersionUID() + "." + getMinorSubVerionID();
    }

    public static void registerMarioVisualComponent(MarioVisualComponent mc) {
        marioVisualComponent = mc;
    }

    public static void registerGameViewer(GameViewer gv) {
        GameViewer = gv;
    }

    public static void AdjustMarioComponentFPS() {
        if (marioVisualComponent != null)
            marioVisualComponent.adjustFPS();
    }

    public static void gameViewerTick() {
        if (GameViewer != null)
            GameViewer.tick();
        //        else
        //            LOGGER.println("GameViewer is not available. Request for dump ignored.", LOGGER.VERBOSE_MODE.ERROR);
    }

    public static String getDateTime(Long d) {
        DateFormat dateFormat = (d == null) ? new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms") : new SimpleDateFormat("HH:mm:ss:ms");
        if (d != null)
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = (d == null) ? new Date() : new Date(d);
        return dateFormat.format(date);
    }

    final static private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    public static String getTimeStamp() {
        return dateFormat.format(new Date());
    }
}
