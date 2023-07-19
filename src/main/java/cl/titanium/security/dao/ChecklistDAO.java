package cl.titanium.security.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.titanium.security.interf.IChecklist;
import cl.titanium.security.model.Checklist;


public class ChecklistDAO implements IChecklist {

	JdbcTemplate template;

	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public class ChecklistMapper implements RowMapper<Checklist> {

		@Override
		public Checklist mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			return new Checklist(rs.getInt("id_checklist"), rs.getInt("id_cliente"), rs.getDate("fecha_creacion"), rs.getDate("fecha_cambio"));
	
		}

	}
	
	
	@Override
	public Checklist obtenerChecklist(int id_checklist) {

		String sql = "select id_checklist, id_cliente, fecha_creacion, fecha_cambio from checklist WHERE id_checklist=?";

		return template.queryForObject(sql, new ChecklistMapper(), id_checklist);
	}

		
	@Override
	public List<Checklist> listar() {

		String sql = "select id_checklist, id_cliente, fecha_creacion, fecha_cambio from checklist";
	
		return template.query(sql, new ChecklistMapper());
	}

	
	@Override
	public List<Checklist> seleccionarChecklistsCliente(int id_cliente) {

		
		String sql = "select id_checklist, id_cliente, fecha_creacion, fecha_cambio from checklist WHERE id_cliente=?";
	
		return template.query(sql, new ChecklistMapper(), id_cliente);
	}

		
	@Override
	public List<Checklist> seleccionarChecklistsProfesional(int id_profesional) {

	
		String sql = "select distinct id_checklist, checklist.id_cliente AS id_cliente, fecha_creacion, " + 
			" fecha_cambio from checklist join asesoria on checklist.id_cliente = asesoria.id_cliente " + 
				" where asesoria.id_profesional = ?";

		return template.query(sql, new ChecklistMapper(), id_profesional);
	}

	
	@Override
	public int crearChecklist(Checklist che) {
		
		
		String sql = "INSERT INTO checklist (id_cliente, fecha_creacion, fecha_cambio) values (?,?,?)";
	
		return template.update(sql, che.getId_cliente(), che.getFecha_creacion(), che.getFecha_cambio());
	}

	
	
	@Override
	public int editarChecklist(Checklist che) {
		String sql = "update checklist set id_cliente=?, fecha_cambio=? where id_checklist=?";
	
		return template.update(sql, che.getId_cliente(), che.getFecha_cambio(), che.getId_checklist());
	}

	
	
	@Override
	public int eliminarChecklist(int id) {
		String sql = "delete from checklist where id_checklist=?";
	
		return template.update(sql, id);
	}

}
