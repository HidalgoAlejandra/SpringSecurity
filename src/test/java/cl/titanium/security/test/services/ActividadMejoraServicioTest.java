package cl.titanium.security.test.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.titanium.security.interfaces.ActividadMejoraServicio;
import cl.titanium.security.model.ActividadMejora;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ActividadMejoraServicioTest {
	
	@Autowired
	ActividadMejoraServicio act;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testIngresarActividadMejora() {
		ActividadMejora a = new ActividadMejora(1, true, "Detalle");
		act.ingresarActividadMejora(a);
		int id = act.obtenerUltimoId();
		ActividadMejora result = act.obtenerActividadMejora(id);
		assertEquals("Detalle", result.getDetalle_actividad());
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testBorrarActividadMejora() {
		ActividadMejora a = new ActividadMejora(1, true, "Detalle");
		act.ingresarActividadMejora(a);
		List<ActividadMejora> listaInicial = act.obtenerListaAcm();
		int contInicial = listaInicial.size();
		int ultimoid = act.obtenerUltimoId();
		ActividadMejora borrable = act.obtenerActividadMejora(ultimoid);
		act.borrarActividadMejora(borrable);
		List<ActividadMejora> listaFinal = act.obtenerListaAcm();
		int contFinal = listaFinal.size();
		assertEquals(contInicial - 1, contFinal);
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testModificarActividadMejora() {
		ActividadMejora a = act.obtenerActividadMejora(6);
		a.setRealizado(false);
		act.modificarActividadMejora(a);
		ActividadMejora result = act.obtenerActividadMejora(6);
		assertEquals(false, result.isRealizado());
	}

	@Test
	public void testObtenerActividadMejora() {
		ActividadMejora a = act.obtenerActividadMejora(2);
		assertEquals(2, a.getId_asesoria());
	}

	@Test
	public void testObtenerUltimoId() {
		int id = act.obtenerUltimoId();
		assertTrue(id == 6);
	}

	@Test
	public void testObtenerListaAcm() {
		List<ActividadMejora> lista = act.obtenerListaAcm();
		assertEquals(6, lista.size());
	}

	@Test
	public void testObtenerListaAcmCliente() {
		List<ActividadMejora> lista = act.obtenerListaAcmCliente(1);
		assertEquals(2, lista.size());
	}

}
