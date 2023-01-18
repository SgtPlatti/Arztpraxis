import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PraxisListe {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int input = 0;
        boolean valid = false;

        //Patientenliste, leer
        ArrayList<String> namen = new ArrayList<>();

      //Hauptmenü
        String hauptmenü = "";
        hauptmenü += String.format("\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        hauptmenü += String.format("\t┃          Hauptmenü          ┃\n");
        hauptmenü += String.format("\t┣━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━┫\n");
        hauptmenü += String.format("\t┃ 1 ┃  Anmeldung              ┃\n");
        hauptmenü += String.format("\t┃ 2 ┃  Anmeldung überprüfen   ┃\n");
        hauptmenü += String.format("\t┃ 3 ┃  Anzahl Anmeldungen     ┃\n");
        hauptmenü += String.format("\t┃ 4 ┃  Anmeldungsliste        ┃\n");
      //hauptmenü += String.format("\t┃ 5 ┃                         ┃\n");
      //hauptmenü += String.format("\t┃ 6 ┃                         ┃\n");
        hauptmenü += String.format("\t┃ 7 ┃  Patient aufrufen       ┃\n");
      //hauptmenü += String.format("\t┃ 8 ┃                         ┃\n");
        hauptmenü += String.format("\t┃ 9 ┃  Beenden                ┃\n");
        hauptmenü += String.format("\t┗━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        //Verarbeitung
        while (input != 9) {
            System.out.println(hauptmenü);

            //Eingabe ins Hauptmenü
            do {
                try {
                    input = Integer.parseInt(reader.readLine());
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Bitte Eingabe wiederholen");
                }
            } while (valid == false);

            switch (input) {
                case 0:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 1:
                    int wahl = 0;
                    do {
                        if (namen.size() == 20) {
                        System.out.println("Liste voll!");
                        System.out.println("\n<┘: Zurück zum Hauptmenü");
                        reader.readLine();
                        break;
                    } else {
                        System.out.println("Name:");
                        namen.add(reader.readLine());
                        System.out.println("1 Nächster Patient\n2 Hauptmenü");
                        wahl = Integer.parseInt(reader.readLine());
                        }
                    } while (wahl == 1);
                    break;

                case 2:
                    if (namen.size() == 0) {
                        System.out.println("Liste leer");
                    } else {
                        String find = "";
                        System.out.println("gesuchter Patient:");
                        String suche = reader.readLine();
                        for (int i = 0; i < namen.size();) {
                            if (suche.equalsIgnoreCase(namen.get(i))) {
                                find = ("Gefunden an Stelle " + (i + 1));
                                break;
                            } else {
                                i++;
                            }
                        }
                    if (!find.equals("")) {
                    System.out.println(find);
                    } else {System.out.println("Patient nicht gefunden");}
                    }
                    System.out.println("\n<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 3: if (namen.size() == 0) System.out.println("Liste leer");
                        else if (namen.size() == 1) System.out.println("1 Patient ist angemeldet.");
                        else System.out.println(String.format("%d Patienten sind angemeldet.", namen.size()));

                    System.out.println("\n<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 4:
                    if (namen.size() == 0) System.out.println("Liste leer");
                    else {
                        String liste = "";
                        for (int i = 0; i < namen.size(); i++) {
                            liste += String.format("%2s.: " + namen.get(i) + "\n", (i + 1));
                            }
                        System.out.println("Anmeldungsliste:");
                        System.out.println(liste);
                    }

                    System.out.println("\n<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 5:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 6:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 7:
                    System.out.println(String.format("Patienten aufrufen:\n%s", namen.get(0)));
                    namen.remove(0);

                    System.out.println("\n<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 8:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 9:
                    System.out.println("\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("\t┃       Auf wiedersehen!      ┃");
                    System.out.println("\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    System.out.println("");
                    break;

                default:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;
            }

        }
        // Ende des Programms
        // Taucht nur auf, wenn der User "9" im Hauptmenü eingibt
        System.out.println("<┘: Exit");
        reader.readLine();
    }
}
// ┃━┏┓┗┛┣┫┳┻╋ ┘