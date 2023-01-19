import javax.swing.*;

public class test {
    public static void main(String[] args) {
        String menu = "<html> <h2> Arztpraxis Dr. Fox</h2>"
                + "Bitte wählen: <br/>"
                + "(1) = Patient meldet sich an der Anmeldung an<br/>"
                + "(2) = Überprüfen, ob ein Patient angemeldet ist<br/>"
                + "(3) = Anzahl der angemeldeten Patienten ausgeben<br/>"
                + "(4) = Liste der Patienten ausgeben<br/>"
                + "(7) = Patient aufrufen<br/>"
                + "(9) = Programm beenden<br/>"
                + "</html>";

        JOptionPane.showInputDialog(menu);
    }
}
