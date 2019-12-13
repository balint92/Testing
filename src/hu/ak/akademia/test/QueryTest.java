package hu.ak.akademia.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hu.ak.akademia.dto.Product;
import hu.ak.akademia.dto.Status;

public class QueryTest {

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "teaching", "password");Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery("SELECT product_id, name, price, creation_date, mod_date, status FROM product");
			while(resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				int price = resultSet.getInt("price");
				String name = resultSet.getString("name");
				Date creationDate = resultSet.getDate("creation_date");
				Date modDate = resultSet.getDate("mod_date");
				String status = resultSet.getString("status");
				
				Product product = new Product();
				product.setId(productId);
				product.setPrice(price);
				product.setName(name);
				product.setCreated(new java.util.Date(creationDate.getTime()));
				product.setModified(new java.util.Date(modDate.getTime()));
				product.setStatus(Status.getByCode(status));
				System.out.println(product);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
