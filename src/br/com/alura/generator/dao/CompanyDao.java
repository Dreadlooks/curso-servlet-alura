package br.com.alura.generator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Company> findAll() {
		List<Company> all = new ArrayList<>();
		String sql = "select * from company";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");

				all.add(new Company(name));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		return all;
	} 
}
