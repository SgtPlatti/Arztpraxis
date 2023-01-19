import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class PraxisJOp {

    public static void main(String[] args) {

        int input = 0;
        boolean valid = true;

        ArrayList<String> namen = new ArrayList<>(); // Patientenliste, leer
        String[] hauptmenü = {"Anmeldung", "Suchen", "Anzahl", "Liste", "Aufruf", "Beenden"};

        while (valid) {
            /*Hauptmenü*/
            input = (JOptionPane.showOptionDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Auswahl:</html>", "Hauptmenü",
                    0, JOptionPane.PLAIN_MESSAGE, null, hauptmenü, hauptmenü[0]));

            switch (input) {
                case 0: // Anmeldung
                    if (namen.size() == 20) {
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Liste voll!", "Anmeldung",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    } else {
                        boolean nameOK = false;
                        while (nameOK == false) {
                            String pName = (JOptionPane.showInputDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Name:", "Anmeldung",
                                    JOptionPane.QUESTION_MESSAGE));
                            try {
                                if (pName.equals("")) {
                                    JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Ungültige Eingabe", "Fehler",
                                            JOptionPane.ERROR_MESSAGE);
                                } else {
                                    namen.add(pName);
                                    nameOK = true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Ungültige Eingabe", "Fehler",
                                    JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 1: // Überprüfen, ob Patient angemeldet ist
                    if (namen.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Liste leer", "Fehler",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        String find = "";
                        String search = JOptionPane.showInputDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Gesuchter Patient:",
                                "Patientensuche", JOptionPane.QUESTION_MESSAGE);
                        for (int i = 0; i < namen.size(); ) {
                            if (search.equalsIgnoreCase(namen.get(i))) {
                                find = ("Gefunden an Stelle " + (i + 1));
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!find.equals("")) {
                            JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + find, "Patientensuche",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Patient nicht gefunden",
                                    "Patientensuche", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 2: // Wie viele Patienten angemeldet sind
                    if (namen.isEmpty())
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Liste leer",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
                    else if (namen.size() == 1) JOptionPane.showMessageDialog(null,
                            "<html> <h3> ARM 2.77 </h3>" + "1 Patient ist angemeldet.", "Anzahl Anmeldungen",
                            JOptionPane.INFORMATION_MESSAGE);
                    else {
                        String size = String.format("%d Patienten sind angemeldet.", namen.size());
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + size, "Anzahl Anmeldungen",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 3: // Liste angemeldeter Patienten
                    if (namen.isEmpty())
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Liste leer",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
                    else {
                        String liste = "Anmeldungsliste:\n";
                        for (int i = 0; i < namen.size(); i++) {
                            liste += String.format("%2s.: " + namen.get(i) + "\n", (i + 1));
                        }
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + liste, "Anmeldungen",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 4: // Patienten aufrufen
                    if (namen.isEmpty())
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Liste leer",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
                    else {
                        String aufruf = (String.format("Patienten aufrufen:\n%s", "<html><h2>" + namen.get(0) + "</h2></html>"));
                        namen.remove(0);
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + aufruf, "Aufruf",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 5: // Beenden-Button nutzen
                    int X = JOptionPane.showConfirmDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Wirklich beenden?",
                            "Beenden", YES_NO_OPTION);
                    if (X == 0) {
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Auf wiedersehen!", "",
                                JOptionPane.PLAIN_MESSAGE);
                        valid = false;
                    }
                    break;

                default: // Im Hauptmenü über das X beenden
                    X = JOptionPane.showConfirmDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Wirklich beenden?",
                            "Beenden", YES_NO_OPTION);
                    if (X == 0) {
                        JOptionPane.showMessageDialog(null, "<html> <h3> ARM 2.77 </h3>" + "Auf wiedersehen!", "",
                                JOptionPane.PLAIN_MESSAGE);
                        valid = false;
                    }
            }
        }
    }
}