package controleurs;

import medias.Genre;
import test.Bdd;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurGenre {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean addGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int de) {
        // on verifie que l'id n'est pas deja utilise
        int i = 0;
        while (i < Bdd.listGenres.size()) {
            if (Bdd.listGenres.get(i).getId() == idGenre)
                return false;
            else
                i++;
        }
        // si l'id n'est pas utilise, on instancie un nouveau genre
        Genre genre = new Genre(idGenre, n, de);
        Bdd.listGenres.add(genre);
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean setGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int de) {
        // on recupere l'index du genre
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listGenres.size() && !found) {
            if (Bdd.listGenres.get(i).getId() == idGenre)
                found = true;
            else
                i++;
        }
        // si le genre n'existe pas : echec
        if (!found)
            return false;
        // sinon on modifie le genre
        Bdd.listGenres.set(i, new Genre(idGenre, n, de));
        return true;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean removeGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre) {
        // on recupere l'index du genre
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listGenres.size() && !found) {
            if (Bdd.listGenres.get(i).getId() == idGenre)
                found = true;
            else
                i++;
        }
        // si le genre n'existe pas : echec
        if (!found)
            return false;
        // sinon on le supprime
        Bdd.listGenres.remove(i);
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGenre() {
        String listGenres = "";
        int i = 0;
        while (i < Bdd.listGenres.size()) {
            listGenres += Bdd.listGenres.get(i) + "\n";
            i++;
        }
        return listGenres;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre) {
        // on recupere l'index du genre
        int i = 0;
        Boolean found = false;
        while (i < Bdd.listGenres.size() && !found) {
            if (Bdd.listGenres.get(i).getId() == idGenre)
                found = true;
            else
                i++;
        }
        // si le genre n'existe pas : echec
        if (!found)
            return "";
        return "" + Bdd.listGenres.get(i);
    }
}
