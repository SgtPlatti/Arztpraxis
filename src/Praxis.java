import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;

public class Praxis {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int input = 0;
        boolean valid = false;
        int counter = 0;

        //Patientenliste, leer
        String[] namen = new String[20];
        for (int i = 0; i < namen.length; i++) {
            namen[i] = "";
        }
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
                    if (namen[namen.length - 1] != "") {
                        System.out.println("Liste voll!");
                    } else {
                        for (int i = 0; i < namen.length; i++) {
                            if (namen[i] == "") {
                                System.out.println("Name:");
                                namen[i] = reader.readLine();
                                counter++;
                                break;
                            }
                        }
                    }

                    System.out.println("<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 2:
                    if (namen[0] == "") {
                        System.out.println("Liste leer");
                    } else {
                        System.out.println("gesuchter Patient:");
                        String suche = reader.readLine();
                        for (int i = 0; i < namen.length; i++) {
                            if (suche.equalsIgnoreCase(namen[i])) {
                                System.out.println("Gefunden an Stelle " + (i + 1));
                                break;
                            } else {
                                System.out.println("Patient nicht gefunden");
                                break;
                            }
                        }
                    }

                    System.out.println("<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 3:
                    if (counter == 0) System.out.println("Liste leer");
                    else if (counter == 1) System.out.println("1 Patient ist angemeldet.");
                    else System.out.println(String.format("%d Patienten sind angemeldet.", counter));

                    System.out.println("<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 4:
                    if (namen[0].equals("")) System.out.println("Liste leer");
                    else {
                        String liste = "";
                        for (int i = 0; i < counter; i++) {
                            liste += String.format("%2s.: " + namen[i] + "\n", (i + 1));
                        }
                        System.out.println("Anmeldungsliste:");
                        System.out.println(liste);
                    }

                    System.out.println("<┘: Zurück zum Hauptmenü");
                    reader.readLine();
                    break;

                case 5:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 6:
                    System.out.println("Bitte Eingabe wiederholen");
                    break;

                case 7:
                    if (namen[0].equals("")) {
                        System.out.println("Liste leer");
                    } else {
                        System.out.println(String.format("Patienten aufrufen:\n%s", namen[0]));

                        for (int i = 0; i < namen.length - 1; i++) {
                            namen[i] = namen[i + 1];
                        }
                        namen[namen.length - 1] = "";
                        counter--;
                    }
                    System.out.println("<┘: Zurück zum Hauptmenü");
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