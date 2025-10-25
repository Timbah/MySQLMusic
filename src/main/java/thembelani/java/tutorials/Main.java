package thembelani.java.tutorials;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";

    public static void main(String[] args) {

        String username = JOptionPane.showInputDialog(null, "Enter DB Username");

        JPasswordField pf = new JPasswordField();

        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);

        final char[] password = (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;

        try (Connection connection = DriverManager.getConnection(CONN_STRING, username, String.copyValueOf(password))) {
            System.out.println("Success!! Connection made to the music database");
            Arrays.fill(password, ' '); //Clearing the password to keep it in memory for as short at possible
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//Connection automatically gets closed once the try-catch block is completed, so no need to explicitly close it
    }
}