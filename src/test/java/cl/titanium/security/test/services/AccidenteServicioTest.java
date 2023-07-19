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

import cl.titanium.security.interfaces.AccidenteServicio;
import cl.titanium.security.model.Accidente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccidenteServicioTest {
	
	@Autowired
	AccidenteServicio acc;
	Calendar c = Calendar.getInstance();
	Date d;
	Date d2;

	@Before
	public void setUp() throws Exception {
		
		c.set(2020, 6, 24);
		d = new Date(c.getTimeInMillis());
		c.add(Calendar.DAY_OF_MONTH, -15);
		d2 = new Date(c.getTimeInMillis());
		
	}
	
	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testIngresarAccidente() {
		List<Accidente> listaInicial = acc.obtenerAccidentesPorCliente(1);
		int contInicial = listaInicial.size();
		Accidente a = new Accidente(1, d, "Bandido", "Sala virtual", "Programando", "Se fracturó un dedo de tanto CRTL+F");
		acc.ingresarAccidente(a);
		List<Accidente> listaFinal = acc.obtenerAccidentesPorCliente(1);
		int contFinal = listaFinal.size();
		assertEquals(contInicial + 1, contFinal);
	}

	@Test
	public void testObtenerAccidente() {
		Accidente a = acc.obtenerAccidente(7);
		assertEquals("Mario Larenas", a.getInvolucrado());
	}

	@Test
	public void testObtenerAccidentesPorCliente() {
		List<Accidente> lista = acc.obtenerAccidentesPorCliente(2);
		assertEquals(2, lista.size());
	}

	@Test
	public void testObtenerAccidentesPorClienteYFecha() {
		List<Accidente> lista = acc.obtenerAccidentesPorClienteYFecha(2, d);
		assertEquals(1, lista.size());
	}

	@Test
	public void testObtenerAccidentesPorProfesional() {
		List<Accidente> lista = acc.obtenerAccidentesPorProfesional(1);
		assertEquals(3, lista.size());
	}

	@Test
	public void testObtenerAccidentesPorProfesionalYFecha() {
		List<Accidente> lista = acc.obtenerAccidentesPorProfesionalYFecha(1, d);
		assertEquals(2, lista.size());
	}

	@Test
	public void testObtenerAccidentesPorFecha() {
		List<Accidente> lista = acc.obtenerAccidentesPorFecha(d2, d);
		assertEquals(1, lista.size());
	}

	@Test
	@DirtiesContext
	@Sql(scripts="classpath:SecurityTitaniumTest-data.sql", executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testModificarAccidente() {
		Accidente a = acc.obtenerAccidente(9);
		a.setLugar("Minera");
		acc.modificarAccidente(a);
		a = acc.obtenerAccidente(9);
		assertEquals("Minera", a.getLugar());
	}

}
