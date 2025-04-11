package scolarite;

import java.util.ArrayList;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Cours {

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cycle cycle;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Matiere matiere;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<Projet> projets;

    private utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Enseignant prof;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<utilisateurs.Etudiant> etudiants;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nom;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Cours(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cycle c, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Matiere m, utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Enseignant p,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        cycle = c;
        matiere = m;
        projets = new ArrayList<Projet>();
        prof = p;
        etudiants = new ArrayList<utilisateurs.Etudiant>();
        id = i;
        nom = n;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cycle getCycle() {
        return cycle;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Matiere getMatiere() {
        return matiere;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<Projet> getProjets() {
        return projets;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setProjets(ArrayList<Projet> projets) {
        this.projets = projets;
    }

    @org.checkerframework.dataflow.qual.Pure
    public utilisateurs.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Enseignant getProf() {
        return prof;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setProf(utilisateurs.@org.checkerframework.checker.initialization.qual.FBCBottom @org.checkerframework.checker.nullness.qual.Nullable Enseignant prof) {
        this.prof = prof;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<utilisateurs.Etudiant> getEtudiants() {
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Cours this) {
        String res = "";
        res += id + " ";
        res += nom + "\n";
        res += "cycle : " + cycle.getNom() + "\n";
        res += "matiere : " + matiere.getNom() + "\n";
        res += "enseignant : " + prof.getNom() + "\n";
        res += "etudiants : ";
        for (int i = 0; i < etudiants.size(); i++) res += etudiants.get(i).getNom() + " ";
        res += "\n";
        return res;
    }
}
