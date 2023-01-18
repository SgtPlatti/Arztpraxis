import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class PraxisJOp {

    public static void main(String[] args) {

        int input = 0;
        boolean valid = true;

        ArrayList<String> namen = new ArrayList<>(); // Patientenliste, leer
        String[] hauptmenü = {"Anmeldung", "Suchen", "Anzahl", "Liste", "Aufruf", "Beenden"};

        while (valid) {/*
Hauptmenü*/ input = (JOptionPane.showOptionDialog(null, "Auswahl:", "Hauptmenü",
                    0, JOptionPane.QUESTION_MESSAGE, null, hauptmenü, hauptmenü[0]));

            switch (input) {
                case 0: // Anmeldung
                    if (namen.size() == 20) {
                        JOptionPane.showMessageDialog(null, "Liste voll!");
                        break;
                    } else {
                        namen.add(JOptionPane.showInputDialog("Name:"));
                    }
                    break;

                case 1: // Überprüfen, ob Patient angemeldet ist
                    if (namen.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Liste leer");
                    } else {
                        String find = "";
                        String search = JOptionPane.showInputDialog("Gesuchter Patient:");
                        for (int i = 0; i < namen.size(); ) {
                            if (search.equalsIgnoreCase(namen.get(i))) {
                                find = ("Gefunden an Stelle " + (i + 1));
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!find.equals("")) {
                            JOptionPane.showMessageDialog(null, find);
                        } else {
                            JOptionPane.showMessageDialog(null, "Patient nicht gefunden");
                        }
                    }
                    break;

                case 2: // Wie viele Patienten angemeldet sind
                    if (namen.size() == 0) JOptionPane.showMessageDialog(null, "Liste leer");
                    else if (namen.size() == 1) JOptionPane.showMessageDialog(null, "1 Patient ist angemeldet.");
                    else {
                        String size = String.format("%d Patienten sind angemeldet.", namen.size());
                        JOptionPane.showMessageDialog(null, size);
                    }
                    break;

                case 3: // Liste angemeldeter Patienten
                    if (namen.size() == 0) JOptionPane.showMessageDialog(null, "Liste leer");
                    else {
                        String liste = "Anmeldungsliste:\n";
                        for (int i = 0; i < namen.size(); i++) {
                            liste += String.format("%2s.: " + namen.get(i) + "\n", (i + 1));
                        }
                        JOptionPane.showMessageDialog(null, liste);
                    }
                    break;

                case 4: // Patienten aufrufen
                    if (namen.size() == 0) JOptionPane.showMessageDialog(null, "Liste leer");
                    else {
                        String aufruf = (String.format("Patienten aufrufen:\n%s", namen.get(0)));
                        namen.remove(0);
                        JOptionPane.showMessageDialog(null, aufruf);
                    }
                    break;

                case 5: // Beenden-Button nutzen
                    int X = JOptionPane.showConfirmDialog(null, "Wirklich beenden?", "Beenden", 0, YES_NO_OPTION);
                    if (X == 0) {
                        JOptionPane.showMessageDialog(null, "Auf wiedersehen!");
                        valid = false;
                    }
                    break;

                default: // Im Hauptmenü über das X beenden
                    X = JOptionPane.showConfirmDialog(null, "Wirklich beenden?", "Beenden", 0, YES_NO_OPTION);
                    if (X == 0) {
                        JOptionPane.showMessageDialog(null, "Auf wiedersehen!");
                        valid = false;
                    }
            }
        }
    }
}