package cl.titanium.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.titanium.security.interf.ITarea;
import cl.titanium.security.model.Tarea;


public class TareaDAO implements ITarea {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public class TareaMapper implements RowMapper<Tarea> {

		@Override
		public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tarea(rs.getInt("id_tarea"), rs.getString("nombre"), rs.getString("detalle_tarea"));
		}

	}

	@Override
	public Tarea obtenerTarea(int id_Tarea) {
		String sql = "select id_tarea, nombre, detalle_tarea from tarea WHERE id_tarea=?";

		return template.queryForObject(sql, new TareaMapper(), id_Tarea);
	}

	@Override
	public List<Tarea> listar() {
		String sql = "select id_tarea, nombre, detalle_tarea from tarea";
		
		return template.query(sql, new TareaMapper());
	}

	@Override
	public List<Tarea> listarTareasPorChecklist(int id_checklist) {
		String sql = "SELECT id_tarea, nombre, detalle_tarea from tarea WHERE id_tarea IN ("
				+ "SELECT id_tarea FROM estado WHERE id_checklist=?)";
		
		return template.query(sql, new TareaMapper(), id_checklist);
	}

	@Override
	public int ingresarTarea(Tarea ta) {
		String sql = "insert into tarea (nombre, detalle_tarea) values (?,?)";
		
		return template.update(sql, ta.getNombre(), ta.getDetalle_tarea());
	}

	@Override
	public int editarTarea(Tarea ta) {
		String sql = "update tarea set nombre=?, detalle_tarea=?  where id_tarea=?";
		
		return template.update(sql, ta.getNombre(), ta.getDetalle_tarea(), ta.getId_tarea());
	}

	@Override
	public int eliminarTarea(Tarea tar) {
		String sql = "delete from tarea where Id_tarea=?";
		
		return template.update(sql, tar.getId_tarea());
	}

	@Override
	public int obtenerUltimoId() {
		
		String sql = "SELECT MAX(id_tarea) FROM tarea";

		return template.queryForObject(sql, Integer.class);
	}
}

