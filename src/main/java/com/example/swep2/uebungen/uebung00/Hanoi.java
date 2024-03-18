package com.example.swep2.uebungen.uebung00;

import com.example.swep2.InputTools;

class Scheibe {
    int durchmesser;

    public Scheibe(int durchmesser) {
        this.durchmesser = durchmesser;
    }
}

class Stab {
    Scheibe[] scheiben;

    public Stab(int anzahlScheiben) {
        scheiben = new Scheibe[anzahlScheiben];
    }

    public void scheibeHinzufuegen(Scheibe s, int index) {
        scheiben[index] = s;
    }

    public void scheibeEntfernen(int index) {
        scheiben[index] = null;
    }

    public void anzeigen() {
        for (Scheibe s : scheiben) {
            if (s != null) {
                System.out.print(s.durchmesser + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}

public class Hanoi {
    public static void hanoi(int n, Stab start, Stab hilfsstab, Stab ziel) {
        if (n == 1) {
            Scheibe scheibe = start.scheiben[n - 1];
            start.scheibeEntfernen(n - 1);
            ziel.scheibeHinzufuegen(scheibe, 0);
            anzeigenStaeben(start, hilfsstab, ziel);
        } else {
            hanoi(n - 1, start, ziel, hilfsstab);
            Scheibe scheibe = start.scheiben[n - 1];
            start.scheibeEntfernen(n - 1);
            ziel.scheibeHinzufuegen(scheibe, 0);
            anzeigenStaeben(start, hilfsstab, ziel);
            hanoi(n - 1, hilfsstab, start, ziel);
        }
    }

    public static void anzeigenStaeben(Stab a, Stab h, Stab b) {
        System.out.println("A:");
        a.anzeigen();
        System.out.println("---");
        System.out.println("H:");
        h.anzeigen();
        System.out.println("---");
        System.out.println("B:");
        b.anzeigen();
        System.out.println("---");
    }

    public static void main(String[] args) {
        int anzahlScheiben = InputTools.readInteger("Geben Sie die Anzahl der Scheiben ein: ");

        Stab a = new Stab(anzahlScheiben);
        Stab h = new Stab(anzahlScheiben);
        Stab b = new Stab(anzahlScheiben);

        for (int i = 0; i < anzahlScheiben; i++) {
            Scheibe scheibe = new Scheibe(i + 1);
            a.scheibeHinzufuegen(scheibe, i);
        }

        anzeigenStaeben(a, h, b);
        hanoi(anzahlScheiben, a, h, b);
    }
}
