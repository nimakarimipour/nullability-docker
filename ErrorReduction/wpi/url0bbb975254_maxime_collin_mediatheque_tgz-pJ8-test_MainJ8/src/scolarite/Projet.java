package scolarite;

import java.util.ArrayList;
import java.util.Date;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Projet {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Stage stage;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cours cours;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable ArrayList<utilisateurs.Etudiant> etudiants;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nom;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String description;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateDebut;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dateFin;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Projet(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cours c, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable ArrayList<utilisateurs.Etudiant> e,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String d, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        cours = c;
        etudiants = e;
        id = i;
        nom = n;
        description = d;
        dateDebut = dd;
        dateFin = df;
        etudiants = new ArrayList<utilisateurs.Etudiant>();
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Stage getStage() {
        return stage;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setStage(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Stage stage) {
        this.stage = stage;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cours getCours() {
        return cours;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable ArrayList<utilisateurs.Etudiant> getEtudiants() {
        return etudiants;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setEtudiants(ArrayList<utilisateurs.Etudiant> etudiants) {
        this.etudiants = etudiants;
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getDescription() {
        return description;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDescription(String description) {
        this.description = description;
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Projet this) {
        String res = "";
        res += id + " ";
        res += nom + " ";
        res += description + " ";
        res += dateDebut + "->";
        res += dateFin + " ";
        res += cours.getNom() + " ";
        res += "etudiants : ";
        for (int i = 0; i < etudiants.size(); i++) res += etudiants.get(i).getNom();
        res += "\n";
        return res;
    }
}
