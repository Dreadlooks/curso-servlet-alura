package br.com.alura.generator.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alura.generator.models.Company;
import br.com.alura.generator.shared.DateHelper;

public class CompanyDao {

	private Connection conn;
	
	public CompanyDao() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public void save(Company company) {
		String sql = "insert into company(name, openingDate) values(?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, company.getName());
			stmt.setDate(2, new Date(company.getOpeningDate().getTimeInMillis()));
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
				
				Date date = rs.getDate("openingDate");
				Calendar openingDate = DateHelper.getCalendarFromDate(date);
				
				all.add(new Company(id, name, openingDate));
			}
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		return all;
	}
	
	public void delete(Long id) {
		String sql = "delete from company where id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Company findById(Long id) {
		String sql = "select * from company where id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Company(rs.getLong("id"), rs.getString("name"), 
						DateHelper.getCalendarFromDate(rs.getDate("openingDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
		return new Company();
	}
	
	public void update(Company company) {
		String sql = "update company set name=?, openingDate=? where id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, company.getName());
			stmt.setDate(2, new Date(company.getOpeningDate()
					.getTimeInMillis()));
			stmt.setLong(3, company.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
