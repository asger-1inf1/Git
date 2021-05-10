
/**
 * Ein Knoten mit einem Bezeichner in einem Graphen
 *
 * @author Susanne Weber
 * @version Version 6
 */
public class Knoten {
    // Aufgabe 1a)
    // Attribut name
    private String name;
    private int x;


    // Aufgabe 1b)
    // Konstruktor mit frei wählbarem Namen
    public Knoten(String n) {
        name = n;
    }

    // Aufgabe 1c)
    // Methode nameGeben()
    public String nameGeben() {
        return name;
    }

    // Aufgabe 1d)
    // Methode nameAusgeben()
    public void nameAusgeben() {
        System.out.println(name);
    }
}
