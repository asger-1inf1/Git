
/**
 * Test für den Graphen S. 103/4
 *
 * @author Susanne Weber
 * @version Version 6
 */
public class Test {

    /**
     * Konstruktor für Objekte der Klasse Test
     */
    public Test() {
        start();
        Graph g = new Graph(6);
        g.knotenEinfuegen("k1");
        g.knotenEinfuegen("k2");
        g.knotenEinfuegen("k3");
        g.knotenEinfuegen("k4");
        g.knotenEinfuegen("k5");
        g.knotenEinfuegen("k6");
        g.kanteEinfuegen("k1", "k2", 9);
        g.kanteEinfuegen("k2", "k1", 9);
        g.kanteEinfuegen("k1", "k3", 3);
        g.kanteEinfuegen("k3", "k1", 3);
        g.kanteEinfuegen("k1", "k4", 7);
        g.kanteEinfuegen("k4", "k1", 7);
        g.kanteEinfuegen("k2", "k4", 4);
        g.kanteEinfuegen("k4", "k2", 4);
        g.kanteEinfuegen("k2", "k5", 6);
        g.kanteEinfuegen("k5", "k2", 6);
        g.kanteEinfuegen("k3", "k6", 5);
        g.kanteEinfuegen("k6", "k3", 5);
        g.kanteEinfuegen("k4", "k6", 4);
        g.kanteEinfuegen("k6", "k4", 4);
        g.kanteEinfuegen("k5", "k6", 6);
        g.kanteEinfuegen("k6", "k5", 6);
        g.knotenAusgeben();
        g.matrixAusgeben();
        System.out.println("Tiefensuche für k1");
        g.tiefensucheStarten("k1");
        finish();
    }

    private void start(){
        System.out.println("Starte Test:");
    }

    private void finish(){
        System.out.println("Finished");
    }

    public static void main(String[] args) {
        new Test();
        System.out.println("ich kann Git!");
    }
}
