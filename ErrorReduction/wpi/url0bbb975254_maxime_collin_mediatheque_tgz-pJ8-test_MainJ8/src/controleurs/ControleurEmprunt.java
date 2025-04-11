package controleurs;

import java.util.Date;
import medias.Media;
import test.Bdd;
import utilisateurs.Utilisateur;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurEmprunt {

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ControleurUser controleurUser = new ControleurUser();

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean emprunter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date de, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dr) {
        Utilisateur user = controleurUser.getUtilisateur(idUser);
        if (user == null)
            return false;
        // on recupere l'index du media
        int i = 0;
        Media media = null;
        while (i < Bdd.listMedias.size() && media == null) {
            if (Bdd.listMedias.get(i).getId() == idMedia)
                media = Bdd.listMedias.get(i);
            else
                i++;
        }
        // si le media n'existe pas : echec
        if (media == null)
            return false;
        // si l'emprunt est effectue correctement
        if (user.emprunter(media) == 1)
            return true;
        else
            return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean emprunter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date de, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dr,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbJours) {
        Utilisateur user = controleurUser.getUtilisateur(idUser);
        if (user == null)
            return false;
        // on recupere l'index du media
        int i = 0;
        Media media = null;
        while (i < Bdd.listMedias.size() && media == null) {
            if (Bdd.listMedias.get(i).getId() == idMedia)
                media = Bdd.listMedias.get(i);
            else
                i++;
        }
        // si le media n'existe pas : echec
        if (media == null)
            return false;
        // si l'emprunt est effectue correctement
        if (user.emprunter(media, nbJours) == 1)
            return true;
        else
            return false;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean commenter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String c) {
        Utilisateur user = controleurUser.getUtilisateur(idUser);
        if (user == null)
            return false;
        // on recupere l'index de l'emprunt
        int indexEmpruntUser = 0;
        Boolean found = false;
        while (indexEmpruntUser < user.getEmprunts().size() && !found) {
            if (user.getEmprunts().get(indexEmpruntUser).getMedia().getId() == idMedia)
                found = true;
            else
                indexEmpruntUser++;
        }
        // si le media n'existe pas : echec
        if (!found)
            return false;
        // si le commentaire est effectue correctement
        if (user.commenter(indexEmpruntUser, n, c) == 1)
            return true;
        else
            return false;
    }
}
