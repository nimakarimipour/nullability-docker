package controleurs;

import scolarite.Matiere;
import test.Bdd;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurMatiere {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listMatieres.size()) {
            if (Bdd.listMatieres.get(i).getId() == idMatiere)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie une nouvelle matiere
        Matiere matiere = new Matiere(idMatiere, n);
        Bdd.listMatieres.add(matiere);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        // on recupere l'index de la matiere
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listMatieres.size() && !found) {
            if (Bdd.listMatieres.get(i).getId() == idMatiere)
                found = true;
            else
                i++;
        }
        // si la matiere n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie la matiere
        Bdd.listMatieres.set(i, new Matiere(idMatiere, n));
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean removeMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere) {
        // on recupere l'index de la matiere
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listMatieres.size() && !found) {
            if (Bdd.listMatieres.get(i).getId() == idMatiere)
                found = true;
            else
                i++;
        }
        // si la matiere n'existe pas : echec
        if (!found)
            return false;
        // sinon on la supprime
        Bdd.listMatieres.remove(i);
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getMatiere() {
        String listMatieres = "";
        int i = 0;
        while (i < Bdd.listMatieres.size()) {
            listMatieres += Bdd.listMatieres.get(i) + "\n";
            i++;
        }
        return listMatieres;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere) {
        // on recupere l'index de la matiere
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listMatieres.size() && !found) {
            if (Bdd.listMatieres.get(i).getId() == idMatiere)
                found = true;
            else
                i++;
        }
        // si la matiere n'existe pas : echec
        if (!found)
            return "";
        return "" + Bdd.listMatieres.get(i);
    }
}
