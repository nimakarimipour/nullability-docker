package test;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class Main {

    @org.checkerframework.dataflow.qual.Impure
    public static void main(String[] args) {
        Bdd.main(null);
        ControleurTest.main();
    }
}
