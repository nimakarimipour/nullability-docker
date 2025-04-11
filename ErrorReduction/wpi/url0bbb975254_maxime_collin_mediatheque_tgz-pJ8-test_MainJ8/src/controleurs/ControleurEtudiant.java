package controleurs;

import test.Bdd;
import utilisateurs.Etudiant;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurEtudiant {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addEtudiant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEtudiant, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listEtudiants.size()) {
            if (Bdd.listEtudiants.get(i).getId() == idEtudiant)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie un nouvel etudiant
        Etudiant etudiant = new Etudiant(i, n, p, t, nbEM);
        Bdd.listEtudiants.add(etudiant);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setEtudiant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEtudiant, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        // on recupere l'index de l'etudiant
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listEtudiants.size() && !found) {
            if (Bdd.listEtudiants.get(i).getId() == idEtudiant)
                found = true;
            else
                i++;
        }
        // si l'etudiant n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie l'etudiant
        Etudiant etudiant = new Etudiant(i, n, p, t, nbEM);
        Bdd.listEtudiants.set(i, etudiant);
        return true;
    }
}
