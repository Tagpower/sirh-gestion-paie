package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (id, code, nbHeuresBase, tauxBase) VALUES (?,?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {

		String sql = "UPDATE grade set code = ?, nbHeuresBase = ?, tauxBase = ? WHERE id = ?";
		this.jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());		
	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}
	
	@Override
	public void supprimer(Grade grade) {
		String sql = "DELETE FROM grade WHERE id=?";
		this.jdbcTemplate.update(sql, grade.getId());
	}
	
	
}

class GradeMapper implements RowMapper<Grade> {
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade g = new Grade();
		g.setId(rs.getInt("id"));
		g.setCode(rs.getString("code"));
		g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
		g.setTauxBase(rs.getBigDecimal("tauxBase"));
		return g;
	}
}