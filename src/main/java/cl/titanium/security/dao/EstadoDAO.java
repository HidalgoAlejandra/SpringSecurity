package cl.titanium.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.titanium.security.interf.IEstado;
import cl.titanium.security.model.Estado;


public class EstadoDAO implements IEstado {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public class EstadoMapper implements RowMapper<Estado> {
	
		@Override
		public Estado mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Estado(rs.getInt("id_checklist"), rs.getInt("id_tarea"), rs.getBoolean("completado"));
		}
	}
	

	@Override
	public List<Estado> listar() {
		String sql = "select id_checklist, id_tarea, completado from estado";
		
		return template.query(sql, new EstadoMapper());
	}

	@Override
	public int crearEstado(Estado est) {
		String sql = "insert into estado (id_checklist, id_tarea, completado) values (?,?,?)";
		
		return template.update(sql, est.getId_checklist(), est.getId_tarea(), est.isCompletado());
	}

	@Override
	public int editarEstado(Estado est) {
		String sql = "update estado set completado=? where id_checklist=? AND id_tarea=?";
		
		return template.update(sql, est.isCompletado(), est.getId_checklist(), est.getId_tarea());
	}
	
	@Override
	public int eliminarEstado(Estado est) {
		String sql = "delete from estado where id_checklist=? AND id_tarea=?";
		
		return template.update(sql, est.getId_checklist(), est.getId_tarea());
	}

	@Override
	public Estado obtenerEstado(int id_tarea, int id_checklist) {
		
		String sql = "select id_tarea, id_checklist, completado from estado WHERE id_tarea=? and id_checklist=?";

		return template.queryForObject(sql, new EstadoMapper(), id_tarea, id_checklist);

		
	}


}
