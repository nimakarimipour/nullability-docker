package utilisateurs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import medias.Media;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public abstract class Utilisateur {

    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<scolarite.Cours> cours;

    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<emprunt.Emprunt> emprunts;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int id;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nom;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String prenom;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String type;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEmpruntMax;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEmpruntNonCommente;

    private  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEmpruntEnCours;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public Utilisateur( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        id = i;
        nom = n;
        prenom = p;
        type = t;
        nbEmpruntMax = nbEM;
        nbEmpruntNonCommente = 0;
        nbEmpruntEnCours = 0;
        cours = new ArrayList<scolarite.Cours>();
        emprunts = new ArrayList<emprunt.Emprunt>();
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<scolarite.Cours> getCours() {
        return cours;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setCours(ArrayList<scolarite.Cours> cours) {
        this.cours = cours;
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
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getPrenom() {
        return prenom;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String getType() {
        return type;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setType(String type) {
        this.type = type;
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int emprunter(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media) {
        int valeurEligible = eligibilite(media);
        if (valeurEligible == 1) {
            // -> Création de l'emprunt
            // Récupère la date courante
            Date datedeb = new Date();
            Date datefin;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, media.getGenre().getDureeEmprunt());
            datefin = cal.getTime();
            faireUnEmprunt(media, datedeb, datefin);
            return 1;
        } else // Sinon
        {
            return valeurEligible;
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int emprunter(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbJour) {
        int valeurEligible = eligibilite(media);
        if (valeurEligible == 1) {
            // -> Création de l'emprunt
            // Récupère la date courante
            Date datedeb = new Date();
            Date datefin;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, nbJour);
            datefin = cal.getTime();
            faireUnEmprunt(media, datedeb, datefin);
            return 1;
        } else // Sinon
        {
            return valeurEligible;
        }
    }

    @org.checkerframework.dataflow.qual.Pure
    protected abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int eligibilite(medias.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media);

    @org.checkerframework.dataflow.qual.Impure
    public abstract  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int commenter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEmprunt,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String com);

    @org.checkerframework.dataflow.qual.Impure
    public abstract void VerifierLesEmprunts();

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getNbEmpruntMax() {
        return nbEmpruntMax;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNbEmpruntMax(int nbEmpruntMax) {
        this.nbEmpruntMax = nbEmpruntMax;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getNbEmpruntNonCommente() {
        return nbEmpruntNonCommente;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNbEmpruntNonCommente(int nbEmpruntNonCommente) {
        this.nbEmpruntNonCommente = nbEmpruntNonCommente;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ArrayList<emprunt.Emprunt> getEmprunts() {
        return emprunts;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setEmprunts(ArrayList<emprunt.Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @org.checkerframework.dataflow.qual.Pure
    public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int getNbEmpruntEnCours() {
        return nbEmpruntEnCours;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void setNbEmpruntEnCours(int nbEmpruntEnCours) {
        this.nbEmpruntEnCours = nbEmpruntEnCours;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void incrementerNbEmpruntEnCours() {
        this.nbEmpruntEnCours++;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void decrementerNbEmpruntEnCours() {
        this.nbEmpruntEnCours--;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void incrementerNbEmpruntNonCommente() {
        this.nbEmpruntNonCommente++;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void decrementerNbEmpruntNonCommente() {
        this.nbEmpruntNonCommente--;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void addEmprunts(emprunt.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Emprunt emprunt) {
        this.emprunts.add(emprunt);
    }

    @org.checkerframework.dataflow.qual.Pure
    public emprunt.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable Emprunt getEmprunt( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEmp) {
        emprunt.Emprunt resultat = null;
        for (emprunt.Emprunt tmp : emprunts) {
            if (tmp.getId() == idEmp)
                resultat = tmp;
        }
        return resultat;
    }

    @org.checkerframework.dataflow.qual.Impure
    protected void faireUnEmprunt(medias.@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Media media, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date deb, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date fin) {
        this.incrementerNbEmpruntEnCours();
        this.incrementerNbEmpruntNonCommente();
        this.addEmprunts(new emprunt.Emprunt(this, media, deb, fin));
        //media.setDisponible(false);
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String toString(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Utilisateur this) {
        String res = "";
        res += getId() + " ";
        res += getNom() + " ";
        res += getPrenom() + " ";
        res += getType() + "\n";
        res += "cours : ";
        for (int i = 0; i < getCours().size(); i++) res += getCours().get(i) + " ";
        res += "\n";
        res += "emprunts : ";
        for (int i = 0; i < getEmprunts().size(); i++) res += getEmprunts().get(i) + " ";
        res += "\n";
        res += "nbEmpruntMax : " + getNbEmpruntMax() + "\n";
        res += "nbEmpruntEnCours : " + getNbEmpruntEnCours() + "\n";
        res += "nbEmpruntNonCommente : " + getNbEmpruntNonCommente() + "\n";
        return res;
    }
}
