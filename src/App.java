import java.sql.*;
import javax.swing.*;

public class App extends JFrame {
    public App() {
        setSize(600, 500);
        setTitle("Trabalho ORI");
        setLocationRelativeTo(new JFrame());   
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        new App();
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:BD_Loja.db");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Loja");
            while ( rs.next() ) {
               JOptionPane.showMessageDialog (
                null, 
                rs.getInt("Id")+"\n" + 
                rs.getString("Produto")+"\n" +
                rs.getFloat("Preco")+"\n" );
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "SQLite acessado com sucesso!");
    }
}