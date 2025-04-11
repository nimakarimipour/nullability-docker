package medias;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Genre {

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nom;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int dureeEmprunt;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Genre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int de) {
        id = i;
        nom = n;
        dureeEmprunt = de;
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
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getDureeEmprunt() {
        return dureeEmprunt;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setDureeEmprunt(int dureeEmprunt) {
        this.dureeEmprunt = dureeEmprunt;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Genre this) {
        String res = "";
        res += id + " ";
        res += nom + " ";
        res += dureeEmprunt + "\n";
        return res;
    }
}
