package utilisateurs;

import medias.Media;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Etudiant extends Utilisateur {

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Etudiant( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        super(i, n, p, t, nbEM);
    }

    @org.checkerframework.dataflow.qual.Pure
    protected  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int eligibilite(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Etudiant this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media) {
        // Si le nombre d'emprunt en cours est au max
        if (this.getNbEmpruntEnCours() == this.getNbEmpruntMax()) {
            return 2;
        } else // Si le nombre d'emprunt non commenté est au max
        if (this.getNbEmpruntNonCommente() == this.getNbEmpruntMax()) {
            return 3;
        } else // Si le media n'est pas disponible
        if (media.isDisponible() == false) {
            return 4;
        }
        return 1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int commenter(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Etudiant this,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEmprunt,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String com) {
        emprunt.Emprunt empruntConcerne = this.getEmprunt(idEmprunt);
        empruntConcerne.setCommentaire(com);
        empruntConcerne.setNote(n);
        this.decrementerNbEmpruntEnCours();
        this.decrementerNbEmpruntNonCommente();
        empruntConcerne.getMedia().setDisponible(true);
        empruntConcerne.setFinis(true);
        return 1;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void VerifierLesEmprunts(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Etudiant this) {
        for (emprunt.Emprunt tmp : emprunts) {
            if (!tmp.isFinis()) {
                tmp.faireUneNotification();
            }
        }
    }
}
