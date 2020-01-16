package br.com.alura.generator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.generator.models.Company;

public class CompanyDao {

	private Connection conn;
	
	public CompanyDao() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public void save(Company company) {
		String sql = "insert into company(name) values(?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, company.getName());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
