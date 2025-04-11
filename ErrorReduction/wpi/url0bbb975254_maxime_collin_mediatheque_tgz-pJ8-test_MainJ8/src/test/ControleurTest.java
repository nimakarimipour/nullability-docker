package test;

import java.util.Date;
import mediatheque.Controleur;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class ControleurTest {

    @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Controleur controleur = new Controleur();

    //////////////////////////////////////////
    // 				Media 					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddMedia( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String a, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String r,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int d) {
        Boolean valide = controleur.addMedia(idCours, idGenre, idMedia, n, a, r, d);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetMedia( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String a, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String r,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int d) {
        Boolean valide = controleur.setMedia(idCours, idGenre, idMedia, n, a, r, d);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveMedia( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia) {
        Boolean valide = controleur.removeMedia(idMedia);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetMedia() {
        String res = controleur.getMedia();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetMedia( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia) {
        String res = controleur.getMedia(idMedia);
        return res;
    }

    //////////////////////////////////////////
    //				Genre					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int de) {
        Boolean valide = controleur.addGenre(idGenre, n, de);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int de) {
        Boolean valide = controleur.setGenre(idGenre, n, de);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre) {
        Boolean valide = controleur.removeGenre(idGenre);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetGenre() {
        String res = controleur.getGenre();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetGenre( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idGenre) {
        String res = controleur.getGenre(idGenre);
        return res;
    }

    //////////////////////////////////////////
    //				User					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddUser( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        Boolean valide = controleur.addUser(idUser, n, p, t, nbEM);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetUser( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String t,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbEM) {
        Boolean valide = controleur.setUser(idUser, n, p, t, nbEM);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveUser( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser) {
        Boolean valide = controleur.removeUser(idUser);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetUser() {
        String res = controleur.getUser();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetUser( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser) {
        String res = controleur.getUser(idUser);
        return res;
    }

    //////////////////////////////////////////
    //				Admin					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p) {
        Boolean valide = controleur.addAdmin(idAdmin, n, p);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String p) {
        Boolean valide = controleur.setAdmin(idAdmin, n, p);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin) {
        Boolean valide = controleur.removeAdmin(idAdmin);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetAdmin() {
        String res = controleur.getAdmin();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetAdmin( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idAdmin) {
        String res = controleur.getAdmin(idAdmin);
        return res;
    }

    //////////////////////////////////////////
    //				Cours					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEnseignant,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.addCours(idCycle, idMatiere, idEnseignant, idCours, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEnseignant,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.setCours(idCycle, idMatiere, idEnseignant, idCours, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours) {
        Boolean valide = controleur.removeCours(idCours);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetCours() {
        String res = controleur.getCours();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours) {
        String res = controleur.getCours(idCours);
        return res;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testInscrireUserCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours) {
        Boolean valide = controleur.inscrireUserCours(idUser, idCours);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testDesinscrireUserCours( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours) {
        Boolean valide = controleur.desinscrireUserCours(idUser, idCours);
        return valide;
    }

    //////////////////////////////////////////
    //				Cycle					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.addCycle(idCycle, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.setCycle(idCycle, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle) {
        Boolean valide = controleur.removeCycle(idCycle);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetCycle() {
        String res = controleur.getCycle();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetCycle( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCycle) {
        String res = controleur.getCycle(idCycle);
        return res;
    }

    //////////////////////////////////////////
    //				Matiere					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.addMatiere(idMatiere, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n) {
        Boolean valide = controleur.setMatiere(idMatiere, n);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere) {
        Boolean valide = controleur.removeMatiere(idMatiere);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetMatiere() {
        String res = controleur.getMatiere();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetMatiere( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMatiere) {
        String res = controleur.getMatiere(idMatiere);
        return res;
    }

    //////////////////////////////////////////
    //				Projet					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String d, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        Boolean valide = controleur.addProjet(idCours, idProjet, n, d, dd, df);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idCours,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String d, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        Boolean valide = controleur.setProjet(idCours, idProjet, n, d, dd, df);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet) {
        Boolean valide = controleur.removeProjet(idProjet);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetProjet() {
        String res = controleur.getProjet();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet) {
        String res = controleur.getProjet(idProjet);
        return res;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddEtudiantProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEtudiant,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet) {
        Boolean valide = controleur.addEtudiantProjet(idEtudiant, idProjet);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveEtudiantProjet( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idEtudiant,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet) {
        Boolean valide = controleur.removeEtudiantProjet(idEtudiant, idProjet);
        return valide;
    }

    //////////////////////////////////////////
    //				Stage					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testAddStage( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        Boolean valide = controleur.addStage(idProjet, i, n, dd, df);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testSetStage( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idProjet,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int i, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dd, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date df) {
        Boolean valide = controleur.setStage(idProjet, i, n, dd, df);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testRemoveStage( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idStage) {
        Boolean valide = controleur.removeStage(idStage);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetStage() {
        String res = controleur.getStage();
        return res;
    }

    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String testGetStage( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idStage) {
        String res = controleur.getStage(idStage);
        return res;
    }

    //////////////////////////////////////////
    //				Emprunt					//
    //////////////////////////////////////////
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testEmprunter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date de, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dr) {
        Boolean valide = controleur.emprunter(idUser, idMedia, de, dr);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testEmprunter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date de, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Date dr,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int nbJours) {
        Boolean valide = controleur.emprunter(idUser, idMedia, de, dr, nbJours);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Boolean testCommenter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idUser,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int idMedia,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int n, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String c) {
        Boolean valide = controleur.commenter(idUser, idMedia, n, c);
        return valide;
    }

    @org.checkerframework.dataflow.qual.Pure
    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String displayFunctionTest(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String nameFunction) {
        return "Test " + nameFunction + "\n--->";
    }

    @org.checkerframework.dataflow.qual.Impure
    public static void main() {
        ControleurTest testeur = new ControleurTest();
        System.out.println("demarrage test Controleur");
        System.out.println(displayFunctionTest("addMedia") + testeur.testAddMedia(1, 2, 8, "test", "auteur", "resume", 42));
        System.out.println(displayFunctionTest("setMedia") + testeur.testSetMedia(2, 1, 8, "test", "maxime", "resume", 42));
        System.out.println(displayFunctionTest("removeMedia") + testeur.testRemoveMedia(1));
        System.out.println(displayFunctionTest("getMedia") + testeur.testGetMedia());
        System.out.println(displayFunctionTest("getMedia(int idMedia)") + testeur.testGetMedia(8));
        System.out.println(displayFunctionTest("addGenre") + testeur.testAddGenre(4, "Musique", 14));
        System.out.println(displayFunctionTest("setGenre") + testeur.testSetGenre(4, "Documentation", 21));
        System.out.println(displayFunctionTest("removeGenre") + testeur.testRemoveGenre(1));
        System.out.println(displayFunctionTest("getGenre") + testeur.testGetGenre());
        System.out.println(displayFunctionTest("getGenre(int idGenre)") + testeur.testGetGenre(4));
        System.out.println(displayFunctionTest("addUser") + testeur.testAddUser(2, "Bourrel", "Guillaume", "Enseignant", 100));
        System.out.println(displayFunctionTest("setUser") + testeur.testSetUser(2, "Alain", "Plantec", "Enseignant", 100));
        System.out.println(displayFunctionTest("removeUser") + testeur.testRemoveUser(0));
        System.out.println(displayFunctionTest("getUser") + testeur.testGetUser());
        System.out.println(displayFunctionTest("getUser(int idUser)") + testeur.testGetUser(2));
        System.out.println(displayFunctionTest("addAdmin") + testeur.testAddAdmin(0, "admin", "admin"));
        System.out.println(displayFunctionTest("setAdmin") + testeur.testSetAdmin(0, "admin", "root"));
        System.out.println(displayFunctionTest("getAdmin") + testeur.testGetAdmin());
        System.out.println(displayFunctionTest("getAdmin(int idAdmin)") + testeur.testGetAdmin(0));
        System.out.println(displayFunctionTest("removeAdmin") + testeur.testRemoveAdmin(0));
        System.out.println(displayFunctionTest("addCours") + testeur.testAddCours(1, 1, 2, 3, "coursTest"));
        System.out.println(displayFunctionTest("setCours") + testeur.testSetCours(2, 1, 2, 3, "coursTest"));
        System.out.println(displayFunctionTest("removeCours") + testeur.testRemoveCours(1));
        System.out.println(displayFunctionTest("getCours") + testeur.testGetCours());
        System.out.println(displayFunctionTest("getCours(int idCours)") + testeur.testGetCours(3));
        System.out.println(displayFunctionTest("inscrireUserCours") + testeur.testInscrireUserCours(1, 3));
        System.out.println(displayFunctionTest("desincrireUserCours") + testeur.testDesinscrireUserCours(1, 3));
        System.out.println(displayFunctionTest("addCycle") + testeur.testAddCycle(3, "M2"));
        System.out.println(displayFunctionTest("setCycle") + testeur.testSetCycle(3, "M2_SIAM"));
        System.out.println(displayFunctionTest("removeCycle") + testeur.testRemoveCycle(1));
        System.out.println(displayFunctionTest("getCycle") + testeur.testGetCycle());
        System.out.println(displayFunctionTest("getCycle(int idCycle)") + testeur.testGetCycle(3));
        System.out.println(displayFunctionTest("addMatiere") + testeur.testAddMatiere(3, "SOR"));
        System.out.println(displayFunctionTest("setMatiere") + testeur.testSetMatiere(3, "JEE"));
        System.out.println(displayFunctionTest("removeMatiere") + testeur.testRemoveMatiere(1));
        System.out.println(displayFunctionTest("getMatiere") + testeur.testGetMatiere());
        System.out.println(displayFunctionTest("getMatiere(int idMatiere)") + testeur.testGetMatiere(3));
        System.out.println(displayFunctionTest("addProjet") + testeur.testAddProjet(3, 0, "projet", "carto web", new Date(), new Date(42000000)));
        System.out.println(displayFunctionTest("setProjet") + testeur.testSetProjet(2, 0, "projet", "workflow systeme gestion campagne oceanographique", new Date(), new Date(42000000)));
        System.out.println(displayFunctionTest("getProjet") + testeur.testGetProjet());
        System.out.println(displayFunctionTest("getProjet(int idProjet)") + testeur.testGetProjet(0));
        System.out.println(displayFunctionTest("addEtudiantProjet") + testeur.testAddEtudiantProjet(4, 0));
        System.out.println(displayFunctionTest("removeEtudiantProjet") + testeur.testRemoveEtudiantProjet(4, 0));
        System.out.println(displayFunctionTest("addStage") + testeur.testAddStage(0, 0, "IFREMER", new Date(), new Date(42000000)));
        System.out.println(displayFunctionTest("setStage") + testeur.testSetStage(0, 0, "GEOMER", new Date(), new Date(42000000)));
        System.out.println(displayFunctionTest("getStage") + testeur.testGetStage());
        System.out.println(displayFunctionTest("getStage(int idStage)") + testeur.testGetStage(0));
        System.out.println(displayFunctionTest("removeStage") + testeur.testRemoveStage(0));
        System.out.println(displayFunctionTest("removeProjet") + testeur.testRemoveProjet(0));
        System.out.println(displayFunctionTest("emprunter") + testeur.testEmprunter(3, 5, new Date(), new Date(42000000)));
        System.out.println(displayFunctionTest("emprunter(int nbJours") + testeur.testEmprunter(2, 3, new Date(), new Date(42000000), 7));
        System.out.println(displayFunctionTest("commenter") + testeur.testCommenter(3, 5, 4, "trop d'la balle"));
    }
}
