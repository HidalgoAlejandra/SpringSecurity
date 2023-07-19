package cl.titanium.security.test.services;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.titanium.security.interfaces.CapacitacionServicio;
import cl.titanium.security.model.Capacitacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CapacitacionServicioTest {
	
	@Autowired
	CapacitacionServicio cs;
	Calendar c = Calendar.getInstance();
	Date d;
	Date d2;

	@Before
	public void setUp() throws Exception {
		c.set(2020, 7, 5);
		d = new Date(c.getTimeInMillis());
		c.set(2020, 5, 22);
		d2 = new Date(c.getTimeInMillis());
	}

	@Test
	public void testListar() {
		List<Capacitacion> ca = cs.listar();
		assertEquals(6, ca.size());
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testCrearCapacitacion() {
		Capacitacion ca = new Capacitacion(2, 3, "Asd", d);
		List<Capacitacion> lica = cs.listar();
		int cont1 = lica.size();
		cs.crearCapacitacion(ca);
		lica = cs.listar();
		int cont2 = lica.size();
		assertEquals(cont1 + 1 , cont2);
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testEditarCapacitacion() {
		Capacitacion ca = new Capacitacion(2, 2, 3, "Asd", d);
		cs.editarCapacitacion(ca);
		Capacitacion c2 = cs.obtenerCapacitacion(2);
		assertEquals(3, c2.getParticipantes());
	
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testEliminarCapacitacion() {
		cs.eliminarCapacitacion(5);
		Capacitacion ca = cs.obtenerCapacitacion(5);
		assertEquals(ca, null);
	}

	@Test
	public void testObtenerCapacitacion() {
		Capacitacion ca = cs.obtenerCapacitacion(6);
		Capacitacion c1 = new Capacitacion(6, 6, 26, "Seguridad en el manejo de maquinaria", d2);
		assertEquals (c1.getParticipantes(), ca.getParticipantes());
	}

	@Test
	public void testListarPorCliente() {
		List<Capacitacion> lica = cs.listarPorCliente(1);
		int lista = lica.size();
		assertEquals(2, lista);
	}

	@Test
	public void testListarPorProfesional() {
		List<Capacitacion> lica = cs.listarPorProfesional(1);
		int lista = lica.size();
		assertEquals(2, lista);
	}

}
