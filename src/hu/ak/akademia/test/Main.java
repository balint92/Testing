package hu.ak.akademia.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "teaching", "password");
                Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO product (product_id, name, price, creation_date, mod_date, status) VALUES (product_seq.nextval, 'SSD', 20000, systimestamp, systimestamp, 'A')");
            System.out.println("Új termék sikeresen rögzítve.");
        } catch (SQLException e) {
            System.err.println("Hiba az adatbázis művelet végrehajtása közben.");
            e.printStackTrace();
        }
    }

	}

