package ch.idsia.tools;

import ch.idsia.mario.engine.GlobalOptions;
import ch.idsia.mario.simulation.SimulationOptions;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 12, 2009
 * Time: 7:49:07 PM
 * Package: .Tools
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class EvaluationOptions extends SimulationOptions {

    @org.checkerframework.dataflow.qual.Impure
    public EvaluationOptions() {
        super();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setUpOptions(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] args) {
        for (int i = 0; i < args.length - 1; i += 2) try {
            setParameterValue(args[i], args[i + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Basically we can push the red button to explaud the computer, since this case cannot' never happen.
            System.err.println("Error: Wrong number of input parameters");
            //                System.err.println("It is a perfect day to kill yourself with the yellow wall");
        }
        GlobalOptions.isVisualization = isVisualization();
        GlobalOptions.FPS = getFPS();
        GlobalOptions.isPauseWorld = isPauseWorld();
        GlobalOptions.isPowerRestoration = isPowerRestoration();
        GlobalOptions.isTimer = isTimer();
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean isExitProgramWhenFinished() {
        return b(getParameterValue("-ewf"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setExitProgramWhenFinished(boolean exitProgramWhenFinished) {
        setParameterValue("-ewf", s(exitProgramWhenFinished));
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getMatlabFileName() {
        return getParameterValue("-m");
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMatlabFileName(String matlabFileName) {
        setParameterValue("-m", matlabFileName);
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Point getViewLocation() {
        int x = i(getParameterValue("-vlx"));
        int y = i(getParameterValue("-vly"));
        return new Point(x, y);
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean isViewAlwaysOnTop() {
        return b(getParameterValue("-vaot"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setFPS( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int fps) {
        setParameterValue("-fps", s(fps));
        GlobalOptions.FPS = getFPS();
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Integer getFPS() {
        return i(getParameterValue("-fps"));
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getAgentName() {
        return getParameterValue("-ag");
    }

    //    public Integer getServerAgentPort() {
    ////        setNumberOfTrials(-1);
    //        String value = optionsHashMap.get("-port");
    //        if (value == null)
    //        {
    //            if (getAgentName().startsWith("ServerAgent"))
    //            {
    //                if ( getAgentName().split(":").length > 1)
    //                {
    //                    return Integer.parseInt(getAgentName().split(":")[1]);
    //                }
    //            }
    //        }
    //        return Integer.parseInt(defaultOptionsHashMap.get("-port"));
    //    }
    //    public boolean isServerAgentEnabled() {
    //        return getAgentName().startsWith("ServerAgent");
    //    }
    //
    //    public boolean isServerMode() {
    //        return b(getParameterValue("    -server"));
    //    }
    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isTimer() {
        return b(getParameterValue("-t"));
    }
}
