
/**
 * Ein Graph (gerichtet oder ungerichtet, gewichtet oder ungewichtet)
 *
 * @author Susanne Weber
 * @version Version 6
 */
public class Graph {
    // Aufgabe 2a)
    // Attribut knotenfeld zur Verwaltung der Knoten
    private Knoten[] knotenfeld;

    // Attribut anzahl für die aktuelle Knotenanzahl
    private int anzahl;

    // Aufgabe 3a)
    // Attribut matrix zur Verwaltung der Kanten
    private int[][] matrix;

    // für Tiefensuche
    private boolean[] besucht;

    // Aufgabe 2b)
    // Konstruktor mit frei wählbarer Maximalanzahl an Knoten
    public Graph(int maxAnzahl) {
        // Im Konstruktor: Erzeugen des Knotenfeldes
        knotenfeld = new Knoten[maxAnzahl];
        // Im Konstruktor: Initialisierung des Attributs anzahl
        anzahl = 0;

        // Aufgabe 3b)
        // Im Konstruktor: Instanzierung der Adjazenzmatrix
        matrix = new int[maxAnzahl][maxAnzahl];

        // Aufgabe 3c)
        // Im Konstruktor: Initialisierung der Adjazenzmatrix
        for(int i = 0; i < maxAnzahl; i++) {
            for(int j = 0; j < maxAnzahl; j++) {
                if(i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        //für Tiefensuche
        besucht = new boolean[maxAnzahl];

    }

    // Aufgabe 2c)
    // Methode knotenEinfuegen(name) zum Einfügen eines neuen Knotens
    public void knotenEinfuegen(String name) {
        if(anzahl < knotenfeld.length) {
            knotenfeld[anzahl] = new Knoten(name);
            anzahl++;
        }
    }

    // Aufgabe 2d)
    // Methode knotenAusgeben() zur Ausgabe aller Knoten-Bezeichner auf der Konsole
    public void knotenAusgeben() {
        for(int i = 0; i < anzahl; i++) {
            knotenfeld[i].nameAusgeben();
        }
    }

    // Aufgabe 4a)
    // Methode matrixAusgeben() zur Ausgabe aller Kanten in Matrixform
    public void matrixAusgeben() {
        for(int i = 0; i < anzahl; i++) {
            for(int j = 0; j < anzahl; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // Aufgabe 4c)
    // Methode kanteEinfuegen(von, nach, gewicht) zum Einfügen einer Kante mit Hilfe der Knotennamen
    public void kanteEinfuegen(String von, String nach, int gewicht) {
        int start = indexSuchen(von);
        int ziel = indexSuchen(nach);
        if(start != -1 && ziel != -1) {
            matrix[start][ziel] = gewicht;
        }
    }

    /**
     * Methode zum Initialisieren der Tiefensuche
     *
     * @param name der Name des Startknotens
     */
    public void tiefensucheStarten(String name) {
        //bestimmt den Index zum angegebenen Startknoten
        int index = indexSuchen(name);
        //falls Knoten mit name vorhanden
        if(index != -1) {
            //setzt alle Knoten auf unbesucht
            for(int i = 0; i < anzahl; i++) {

                besucht[i] = false;

            }
            tiefensuche(index);
        }
    }

    /**
     * rekursive Methode zur Tiefensuche
     *
     * @param index der Index des aktuellen Knotens
     */
    public void tiefensuche(int index) {
        //markiert den aktuellen Knoten als besucht
        besucht[index] = true;
        //gibt den aktuellen Knoten aus
        knotenfeld[index].nameAusgeben();
        //überprüft alle Knoten, ob sie Nachbarn sind, die noch nicht besucht wurden
        for(int i = 0; i < anzahl; i++) {
            if(!besucht[i] && matrix[index][i] > 0) {
                //führt die Tiefensuche für den unbesuchten Nachbarn aus
                tiefensuche(i);
            }
        }

    }

    // Aufgabe 4b)
    // Hilfsmethode indexSuchen(name) zur Zuordnung des Index im Knotenfeld zum Knotennamen
    private int indexSuchen(String name) {
        for(int i = 0; i < anzahl; i++) {
            if(name.equals(knotenfeld[i].nameGeben())) {
                return i;
            }
        }
        return -1;
    }
}
