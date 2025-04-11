package emprunt;

import java.util.Date;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Emprunt {

    private utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Utilisateur emprunteur;

    private medias.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int note;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String commentaire;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateEmprunt;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateRetour;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean finis;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Emprunt(utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Utilisateur e, medias.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media m, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date de, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dr) {
        emprunteur = e;
        media = m;
        note = -1;
        commentaire = null;
        dateEmprunt = de;
        dateRetour = dr;
    }

    @org.checkerframework.dataflow.qual.Pure
    public utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Utilisateur getEmprunteur() {
        return emprunteur;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setEmprunteur(utilisateurs.Utilisateur emprunteur) {
        this.emprunteur = emprunteur;
    }

    @org.checkerframework.dataflow.qual.Pure
    public medias.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media getMedia() {
        return media;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMedia(medias.Media media) {
        this.media = media;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getNote() {
        return note;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNote( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int note) {
        this.note = note;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getCommentaire() {
        return commentaire;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCommentaire(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String commentaire) {
        this.commentaire = commentaire;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date getDateEmprunt() {
        return dateEmprunt;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date getDateRetour() {
        return dateRetour;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getId() {
        return id;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setId(int id) {
        this.id = id;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isFinis() {
        return finis;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setFinis( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean finis) {
        this.finis = finis;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void faireUneNotification() {
        Date aujourdhui = new Date();
        if (this.dateRetour.compareTo(aujourdhui) <= 0) {
            this.media.getCours().getProf().addAlerteEmprunt(this);
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Emprunt this) {
        String res = "";
        res += id + " ";
        res += emprunteur.getNom() + " ";
        res += media.getNom() + " ";
        res += dateEmprunt + "->" + dateRetour + " ";
        res += "rendu : " + finis + "\n";
        res += commentaire + "\n";
        res += note + "\n";
        return res;
    }
}
