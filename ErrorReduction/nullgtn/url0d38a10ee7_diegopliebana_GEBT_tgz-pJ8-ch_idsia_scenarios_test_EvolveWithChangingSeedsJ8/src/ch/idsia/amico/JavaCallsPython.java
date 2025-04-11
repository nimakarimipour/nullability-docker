package ch.idsia.amico;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, sergey at idsia dot ch
 * Date: Feb 18, 2010
 * Time: 6:43:16 PM
 * Package: PACKAGE_NAME
 */
public class JavaCallsPython {

    public JavaCallsPython(String moduleName, String agentName) {
        //        System.out.println("Constructor");
        this.setModuleName(moduleName);
        this.setAgentName(agentName);
        System.out.println("Java: agentName = " + agentName);
    }

    public native int setModuleName(@javax.annotation.Nullable String moduleName);

    public native int setAgentName(@javax.annotation.Nullable String agentName);

    public native int[] getAction(@javax.annotation.Nullable int[] squashedObservation, @javax.annotation.Nullable int[] squashedEnemies, @javax.annotation.Nullable float[] marioPos, @javax.annotation.Nullable float[] enemiesPos, @javax.annotation.Nullable int[] marioState);

    static {
        System.out.println("Java: loading AmiCo...");
        System.loadLibrary("AmiCo");
        System.out.println("Java: AmiCo library has been successfully loaded!");
    }
}
