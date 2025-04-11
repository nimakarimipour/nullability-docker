package controleurs;

import test.Bdd;
import utilisateurs.Administrateur;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurAdmin {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listAdmins.size()) {
            if (Bdd.listAdmins.get(i).getId() == idAdmin)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie un nouveau admin
        Administrateur admin = new Administrateur(idAdmin, n, p);
        Bdd.listAdmins.add(admin);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p) {
        // on recupere l'index du admin
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listAdmins.size() && !found) {
            if (Bdd.listAdmins.get(i).getId() == idAdmin)
                found = true;
            else
                i++;
        }
        // si le admin n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie le admin
        Bdd.listAdmins.set(i, new Administrateur(idAdmin, n, p));
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean removeAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin) {
        // on recupere l'index du admin
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listAdmins.size() && !found) {
            if (Bdd.listAdmins.get(i).getId() == idAdmin)
                found = true;
            else
                i++;
        }
        // si le admin n'existe pas : echec
        if (!found)
            return false;
        // sinon on le supprime
        Bdd.listAdmins.remove(i);
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getAdmin() {
        String listAdmins = "";
        int i = 0;
        while (i < Bdd.listAdmins.size()) {
            listAdmins += Bdd.listAdmins.get(i) + "\n";
            i++;
        }
        return listAdmins;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin) {
        // on recupere l'index du admin
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listAdmins.size() && !found) {
            if (Bdd.listAdmins.get(i).getId() == idAdmin)
                found = true;
            else
                i++;
        }
        // si le admin n'existe pas : echec
        if (!found)
            return "";
        // sinon on le retourne
        return "" + Bdd.listAdmins.get(i);
    }
}
