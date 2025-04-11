package utilisateurs;

import java.util.ArrayList;
import medias.Media;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Enseignant extends Utilisateur {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable ArrayList<emprunt.Emprunt> NotificationEmprunts;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Enseignant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        super(i, n, p, t, nbEM);
    }

    @org.checkerframework.dataflow.qual.Pure
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int eligibilite(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Enseignant this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media) {
        // Si le nombre d'emprunt en cours est au max
        if (this.getNbEmpruntEnCours() == this.getNbEmpruntMax()) {
            return 2;
        } else if (media.isDisponible() == false) {
            return 4;
        }
        return 1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int commenter(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Enseignant this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEmprunt,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String com) {
        this.emprunts.get(idEmprunt).setCommentaire(com);
        this.emprunts.get(idEmprunt).setNote(n);
        this.decrementerNbEmpruntEnCours();
        this.emprunts.get(idEmprunt).getMedia().setDisponible(true);
        return 1;
    }

    @org.checkerframework.dataflow.qual.SideEffectFree
    public void VerifierLesEmprunts(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Enseignant this) {
    }

    @org.checkerframework.dataflow.qual.Impure
    public void addAlerteEmprunt(emprunt.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Emprunt emprunt) {
        if (!this.NotificationEmprunts.contains(emprunt))
            this.NotificationEmprunts.add(emprunt);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable ArrayList<emprunt.Emprunt> getNotificationEmprunts() {
        return NotificationEmprunts;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNotificationEmprunts(ArrayList<emprunt.Emprunt> notificationEmprunts) {
        NotificationEmprunts = notificationEmprunts;
    }
}
