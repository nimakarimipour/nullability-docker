package scolarite;

import java.util.Date;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Stage {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Projet projet;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nom;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateDebut;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateFin;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Stage(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Projet p,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        projet = p;
        id = i;
        nom = n;
        dateDebut = dd;
        dateFin = df;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Projet getProjet() {
        return projet;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setProjet(Projet projet) {
        this.projet = projet;
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getNom() {
        return nom;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNom(String nom) {
        this.nom = nom;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date getDateDebut() {
        return dateDebut;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date getDateFin() {
        return dateFin;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Stage this) {
        String res = "";
        res += id + " ";
        res += nom + " ";
        res += dateDebut + "->";
        res += dateFin + "\n";
        res += "projet : " + projet + "\n";
        res += "etudiants : ";
        for (int i = 0; i < projet.getEtudiants().size(); i++) res += projet.getEtudiants().get(i).getNom();
        return res;
    }
}
