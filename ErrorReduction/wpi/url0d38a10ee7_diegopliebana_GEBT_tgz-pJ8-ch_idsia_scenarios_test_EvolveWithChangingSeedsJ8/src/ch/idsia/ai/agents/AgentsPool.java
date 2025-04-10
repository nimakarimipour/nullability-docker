package ch.idsia.ai.agents;

import ch.idsia.ai.agents.human.HumanKeyboardAgent;
import wox.serial.Easy;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, firstname_at_idsia_dot_ch
 * Date: May 9, 2009
 * Time: 8:28:06 PM
 * Package: ch.idsia.controllers.agents
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public final class AgentsPool {

    private static Agent currentAgent = null;

    public static void addAgent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Agent agent) {
        agentsHashMap.put(agent.getName(), agent);
    }

    public static void addAgent(String agentWOXName) throws IllegalFormatException {
        addAgent(load(agentWOXName));
    }

    public static Agent load(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String name) {
        Agent agent;
        try {
            agent = (Agent) Class.forName(name).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(name + " is not a class name; trying to load a wox definition with that name.");
            try {
                agent = (Agent) Easy.load(name);
            } catch (Exception ex) {
                System.err.println(name + " is not a wox definition");
                agent = null;
            }
            if (agent == null) {
                System.err.println("wox definition has not been found as well. Loading <HumanKeyboardAgent> instead");
                agent = new HumanKeyboardAgent();
            }
            System.out.println("agent = " + agent);
        } catch (Exception e) {
            //            e.printStackTrace ();
            agent = new HumanKeyboardAgent();
            System.err.println("Agent is null. Loading agent with name " + name + " failed.");
            System.out.println("agent = " + agent);
            //            System.exit (1);
        }
        return agent;
    }

    public static Collection<Agent> getAgentsCollection() {
        return agentsHashMap.values();
    }

    public static Set<String> getAgentsNames() {
        return AgentsPool.agentsHashMap.keySet();
    }

    public static Agent getAgentByName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String agentName) {
        // There is only one case possible;
        Agent ret = AgentsPool.agentsHashMap.get(agentName);
        if (ret == null)
            ret = AgentsPool.agentsHashMap.get(agentName.split(":")[0]);
        return ret;
    }

    public static Agent getCurrentAgent() {
        if (currentAgent == null)
            currentAgent = (Agent) getAgentsCollection().toArray()[0];
        return currentAgent;
    }

    public static void setCurrentAgent(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Agent agent) {
        currentAgent = agent;
    }

    public static void setCurrentAgent(String agentWOXName) {
        setCurrentAgent(AgentsPool.load(agentWOXName));
    }

    static HashMap<String, Agent> agentsHashMap = new LinkedHashMap<String, Agent>();
}
