package cl.titanium.security.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.titanium.security.interf.IAsesoria;
import cl.titanium.security.model.Asesoria;

public class AsesoriaDAO implements IAsesoria {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// RowMapper
	public class AsesoriaMapper implements RowMapper<Asesoria> {

		@Override
		public Asesoria mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Asesoria(rs.getInt("id_asesoria"), rs.getInt("id_cliente"), rs.getInt("id_profesional"),
					rs.getDate("fecha_solicitud"), rs.getBoolean("estado_asesoria"),
					rs.getString("detalle_solicitud"));
		}
	}

	@Override
	public int ingresarAsesoria (Asesoria asesoria) {
	
		String sql = "INSERT INTO asesoria (id_cliente, id_profesional, fecha_solicitud, Estado_asesoria, detalle_solicitud) VALUES (?,?,?,?,?)";
		
		return template.update(sql, asesoria.getId_cliente(), asesoria.getId_profesional(),
				asesoria.getFecha_solicitud(), asesoria.isEstado_asesoria(), asesoria.getDetalle_solicitud());
		
	}

	@Override
	public int borrarAsesoria(Asesoria asesoria) {

		String sql = "DELETE FROM asesoria WHERE id_asesoria=?";

		return template.update(sql, asesoria.getId_asesoria());

	}

	@Override
	public int modificarAsesoria(Asesoria asesoria) {

		String sql = "UPDATE asesoria SET id_profesional=?, fecha_solicitud=?, estado_asesoria=?,"
				+ " detalle_solicitud=? WHERE id_asesoria=?";

		return template.update(sql, asesoria.getId_profesional(), asesoria.getFecha_solicitud(),
				asesoria.isEstado_asesoria(), asesoria.getDetalle_solicitud(), asesoria.getId_asesoria());

	}

	@Override
	public Asesoria obtenerAsesoria(int id_asesoria) {

		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " FROM asesoria WHERE id_asesoria=?";

		return template.queryForObject(sql, new AsesoriaMapper(), id_asesoria);

	}

	@Override
	public int obtenerUltimoId() {

		String sql = "SELECT MAX(id_asesoria) AS ultimo_id FROM asesoria";

		return template.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Asesoria> obtenerListaAsesorias() {
		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud "
				+ "FROM asesoria";

		return template.query(sql, new AsesoriaMapper());
	}

	@Override
	public List<Asesoria> obtenerListaCasoAse() {
		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " FROM asesoria WHERE id_profesional IS null";
		
		return template.query(sql, new AsesoriaMapper());
		
	}

	@Override
	public List<Asesoria> obtenerListaAsesoriasPorCliente(int id_cliente) {
		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " FROM asesoria WHERE id_cliente=?";

		return template.query(sql, new AsesoriaMapper(), id_cliente);
	}

	@Override
	public List<Asesoria> obtenerListaAsesoriasPorPro(int id_profesional) {
		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " FROM asesoria WHERE id_profesional=?";
		return template.query(sql, new AsesoriaMapper(), id_profesional);
	}
	
	@Override
	public List<Asesoria> obtenerListaAsesoriasPorClienteYPro(int id_cliente, int id_profesional) {
		String sql = "SELECT id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " FROM asesoria WHERE id_cliente=? AND id_profesional=?";

		return template.query(sql, new AsesoriaMapper(), id_cliente, id_profesional);
	}

	@Override
	public int solicitarAsesoria(Asesoria asesoria) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO asesoria (id_cliente, fecha_solicitud, detalle_solicitud, estado_asesoria) VALUES (?,?,?,?)";
		return template.update(sql, asesoria.getId_cliente(), asesoria.getFecha_solicitud(), asesoria.getDetalle_solicitud(),
				asesoria.isEstado_asesoria());
	}

	@Override
	public List<Asesoria> proxcli() {

		String sql = "select id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud "
				+ "from asesoria order by id_cliente";
		return template.query(sql, new AsesoriaMapper());
	}

	@Override
	public List<Asesoria> clixpro() {

		String sql = "select id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " from asesoria order by id_profesional";

		return template.query(sql, new AsesoriaMapper());
	}

	@Override
	public List<Asesoria> asesoriames(Date pMes, Date sMes) {

		String sql = "select id_asesoria, id_cliente, id_profesional, fecha_solicitud, estado_asesoria, detalle_solicitud"
				+ " from asesoria where fecha_solicitud >= ? AND fecha_solicitud <= ?";
		
		return template.query(sql, new AsesoriaMapper(), pMes, sMes);
		
	}

	@Override
	public int aceptarcaso(Asesoria asesoria) {

		String sql = "UPDATE asesoria SET id_profesional=?  WHERE id_asesoria=?";
		
		return template.update(sql, asesoria.getId_profesional(), asesoria.getId_asesoria());

	}

}
