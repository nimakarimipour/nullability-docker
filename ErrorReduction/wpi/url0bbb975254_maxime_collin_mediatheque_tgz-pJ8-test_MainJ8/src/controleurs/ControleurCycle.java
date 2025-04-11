package controleurs;

import scolarite.Cycle;
import test.Bdd;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurCycle {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listCycles.size()) {
            if (Bdd.listCycles.get(i).getId() == idCycle)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie un nouveau cycle
        Cycle cycle = new Cycle(idCycle, n);
        Bdd.listCycles.add(cycle);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        // on recupere l'index du cycle
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listCycles.size() && !found) {
            if (Bdd.listCycles.get(i).getId() == idCycle)
                found = true;
            else
                i++;
        }
        // si le cycle n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie le cycle
        Bdd.listCycles.set(i, new Cycle(idCycle, n));
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean removeCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle) {
        // on recupere l'index du cycle
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listCycles.size() && !found) {
            if (Bdd.listCycles.get(i).getId() == idCycle)
                found = true;
            else
                i++;
        }
        // si le cycle n'existe pas : echec
        if (!found)
            return false;
        // sinon on le supprime
        Bdd.listCycles.remove(i);
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCycle() {
        String listCycles = "";
        int i = 0;
        while (i < Bdd.listCycles.size()) {
            listCycles += Bdd.listCycles.get(i) + "\n";
            i++;
        }
        return listCycles;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle) {
        // on recupere l'index du cycle
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listCycles.size() && !found) {
            if (Bdd.listCycles.get(i).getId() == idCycle)
                found = true;
            else
                i++;
        }
        // si le cycle n'existe pas : echec
        if (!found)
            return "";
        return "" + Bdd.listCycles.get(i);
    }
}
