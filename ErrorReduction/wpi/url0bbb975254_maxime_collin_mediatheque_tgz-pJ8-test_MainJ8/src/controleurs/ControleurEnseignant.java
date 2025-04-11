package controleurs;

import test.Bdd;
import utilisateurs.Enseignant;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurEnseignant {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addEnseignant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEnseignant, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listEnseignants.size()) {
            if (Bdd.listEnseignants.get(i).getId() == idEnseignant)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie un nouvel enseignant
        Enseignant enseignant = new Enseignant(i, n, p, t, nbEM);
        Bdd.listEnseignants.add(enseignant);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setEnseignant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEnseignant, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        // on recupere l'index de l'enseignant
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listEnseignants.size() && !found) {
            if (Bdd.listEnseignants.get(i).getId() == idEnseignant)
                found = true;
            else
                i++;
        }
        // si l'enseignant n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie l'enseignant
        Enseignant enseignant = new Enseignant(i, n, p, t, nbEM);
        Bdd.listEnseignants.set(i, enseignant);
        return true;
    }
}
