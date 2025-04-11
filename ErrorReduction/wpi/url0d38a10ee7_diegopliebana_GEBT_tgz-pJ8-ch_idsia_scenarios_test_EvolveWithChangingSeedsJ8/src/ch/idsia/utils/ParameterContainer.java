package ch.idsia.utils;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.AgentsPool;
import ch.idsia.ai.agents.human.HumanKeyboardAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, firstName_at_idsia_dot_ch
 * Date: May 5, 2009
 * Time: 9:34:33 PM
 * Package: ch.idsia.utils
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ParameterContainer {

    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull HashMap<String, String> optionsHashMap = new HashMap<String, String>();

    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable List<String> allowedOptions = null;

    protected static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable HashMap<String, String> defaultOptionsHashMap = null;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable [] allowed = null;

    @org.checkerframework.dataflow.qual.Impure
    public ParameterContainer() {
        if (allowed == null)
            allowed = new String[] { "-ag", "-amico", "-echo", "-ewf", // grid height (observation )
            "-gh", "-gv", "-gvc", // grid widht (observation )
            "-gw", "-i", "-ld", "-ll", "-ls", "-lt", "-m", "-mm", "-fps", "-pr", "-pw", "-pym", // show grid  (observation )
            "-sg", "-t", "-tc", "-tl", "-vaot", "-vis", "-vlx", "-vly", "-ze", "-zs", // level: height [16-20]
            "-lh", // level: dead ends count
            "-lde", // level: cannons count
            "-lc", // level: HillStraight count
            "-lhs", // level: Tubes count
            "-ltb", // level: blocks count
            "-lb", // level: coins count
            "-lco", // level: gaps count
            "-lg", // level: hidden blocks count
            "-lhb", // level: enemies
            "-le" };
        if (allowedOptions == null) {
            allowedOptions = new ArrayList<String>();
            Collections.addAll(allowedOptions, allowed);
        }
        InitDefaults();
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setParameterValue(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String param, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String value) {
        try {
            if (allowedOptions.contains(param)) {
                optionsHashMap.put(param, value);
            } else {
                throw new IllegalArgumentException("Parameter " + param + " is not valid. Typo?");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Undefined parameter '" + param + " " + value + "'");
            System.err.println(e.getMessage());
            System.err.println("Some defaults might be used instead");
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getParameterValue(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String param) {
        if (allowedOptions.contains(param)) {
            if (optionsHashMap.get(param) == null) {
                //System.err.println("InfoWarning: Default value '" + defaultOptionsHashMap.get(param) + "' for " + param +
                //        " used");
                optionsHashMap.put(param, defaultOptionsHashMap.get(param));
            }
            return optionsHashMap.get(param);
        } else {
            System.err.println("Parameter " + param + " is not valid. Typo?");
            return "";
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String s) {
        return Integer.parseInt(s);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String s(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Object i) {
        return String.valueOf(i);
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String s(Agent a) {
        try {
            if (AgentsPool.getAgentByName(a.getName()) == null)
                AgentsPool.addAgent(a);
            return a.getName();
        } catch (NullPointerException e) {
            System.err.println("ERROR: Agent Not Found");
            return "";
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Agent a(String s) {
        return AgentsPool.getAgentByName(s);
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean b(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String s) {
        return "on".equals(s) || Boolean.valueOf(s);
    }

    @org.checkerframework.dataflow.qual.Impure
    public static void InitDefaults() {
        if (defaultOptionsHashMap != null)
            return;
        else {
            defaultOptionsHashMap = new HashMap<String, String>();
            AgentsPool.setCurrentAgent(new HumanKeyboardAgent());
            //defaultOptionsHashMap.put("-agentName","NoAgent");
            defaultOptionsHashMap.put("-ag", "ch.idsia.ai.agents.human.HumanKeyboardAgent");
            defaultOptionsHashMap.put("-amico", "off");
            //defaultOptionsHashMap.put("-echo","off");
            defaultOptionsHashMap.put("-echo", "off");
            //defaultOptionsHashMap.put("-exitWhenFinished","off");
            defaultOptionsHashMap.put("-ewf", "on");
            defaultOptionsHashMap.put("-gh", "19");
            //defaultOptionsHashMap.put("-gameViewer","off");
            defaultOptionsHashMap.put("-gv", "off");
            //defaultOptionsHashMap.put("-gameViewerContinuousUpdates","off");
            defaultOptionsHashMap.put("-gvc", "off");
            defaultOptionsHashMap.put("-gw", "19");
            // Invulnerability
            defaultOptionsHashMap.put("-i", "off");
            //defaultOptionsHashMap.put("-levelDifficulty","0");
            defaultOptionsHashMap.put("-ld", "0");
            //defaultOptionsHashMap.put("-levelLength","320");
            defaultOptionsHashMap.put("-ll", "320");
            //defaultOptionsHashMap.put("-levelRandSeed","1");
            defaultOptionsHashMap.put("-ls", "0");
            //defaultOptionsHashMap.put("-levelType","1");
            defaultOptionsHashMap.put("-lt", "0");
            // TODO:SK turn out to just FPS, if FPS > 100 -> make it maximum
            //defaultOptionsHashMap.put("-maxFPS","off");
            defaultOptionsHashMap.put("-fps", "24");
            //defaultOptionsHashMap.put("-matLabFile","DefaultMatlabFile");
            defaultOptionsHashMap.put("-m", "");
            //Mario Mode
            defaultOptionsHashMap.put("-mm", "2");
            //            defaultOptionsHashMap.put("-not","1"); //defaultOptionsHashMap.put("-attemptsNumber","5");
            //defaultOptionsHashMap.put("-isPauseWorld","off");
            defaultOptionsHashMap.put("-pw", "off");
            //            defaultOptionsHashMap.put("-port","4242"); //defaultOptionsHashMap.put("-port","4242");
            //defaultOptionsHashMap.put("-powerRestoration","off");
            defaultOptionsHashMap.put("-pr", "off");
            //            defaultOptionsHashMap.put("-ssiw","off"); //defaultOptionsHashMap.put("-stopSimulationIfWin","off");
            //            defaultOptionsHashMap.put("-server","off");
            defaultOptionsHashMap.put("-sg", "off");
            //defaultOptionsHashMap.put("-timer","on");
            defaultOptionsHashMap.put("-t", "on");
            //Time Limit
            defaultOptionsHashMap.put("-tl", "200");
            //defaultOptionsHashMap.put("-toolsConfigurator","off");
            defaultOptionsHashMap.put("-tc", "off");
            //defaultOptionsHashMap.put("-viewAlwaysOnTop","off");
            defaultOptionsHashMap.put("-vaot", "off");
            //defaultOptionsHashMap.put("-viewLocationX","0");
            defaultOptionsHashMap.put("-vlx", "0");
            //defaultOptionsHashMap.put("-viewLocationY","0");
            defaultOptionsHashMap.put("-vly", "0");
            //defaultOptionsHashMap.put("-visual","on");
            defaultOptionsHashMap.put("-vis", "on");
            // ZoomLevel of LevelScene observation
            defaultOptionsHashMap.put("-zs", "1");
            //  ZoomLevel of Enemies observation
            defaultOptionsHashMap.put("-ze", "0");
            //level height
            defaultOptionsHashMap.put("-lh", "15");
            //level: dead ends count
            defaultOptionsHashMap.put("-lde", "on");
            //level: cannons count
            defaultOptionsHashMap.put("-lc", "on");
            //level: HillStraight count
            defaultOptionsHashMap.put("-lhs", "on");
            //level: tubes count
            defaultOptionsHashMap.put("-ltb", "on");
            //level: coins count
            defaultOptionsHashMap.put("-lco", "on");
            //level: blocks count
            defaultOptionsHashMap.put("-lb", "on");
            //level: coins count
            defaultOptionsHashMap.put("-lco", "on");
            //level: blocks count
            defaultOptionsHashMap.put("-lg", "on");
            //level: hidden blocks count
            defaultOptionsHashMap.put("-lhb", "off");
            //level: enemies enabled
            defaultOptionsHashMap.put("-le", "on");
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getDefaultParameterValue(String param) {
        if (allowedOptions.contains(param)) {
            assert (defaultOptionsHashMap.get(param) != null);
            return defaultOptionsHashMap.get(param);
        } else {
            System.err.println("Requires for Default Parameter " + param + " Failed. Typo?");
            return "";
        }
    }
}
