package cl.titanium.security.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="COBRO_SEQ", sequenceName="COBRO_SEQ")
public class Cobro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COBRO_SEQ")
	@Column(name="id_pago")
	int id_pago;
	@Column
	int id_cliente;
	@Column
	int n_factura;
	@Column
	Date fecha_limite;
	@Column
	Date fecha_de_pago;
	
	
	public Cobro() {
	}

	
	public Cobro(int id_pago, int id_cliente, int n_factura, Date fecha_limite, Date fecha_de_pago) {
		this.id_pago = id_pago;
		this.id_cliente = id_cliente;
		this.n_factura = n_factura;
		this.fecha_limite = fecha_limite;
		this.fecha_de_pago = fecha_de_pago;
	}

	
	public Cobro(int id_cliente, int n_factura, Date fecha_limite, Date fecha_de_pago) {
		super();
		this.id_cliente = id_cliente;
		this.n_factura = n_factura;
		this.fecha_limite = fecha_limite;
		this.fecha_de_pago = fecha_de_pago;
	}

	//get an set
	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getN_factura() {
		return n_factura;
	}

	public void setN_factura(int n_factura) {
		this.n_factura = n_factura;
	}

	public Date getFecha_limite() {
		return fecha_limite;
	}

	public void setFecha_limite(Date fecha_limite) {
		this.fecha_limite = fecha_limite;
	}

	public Date getFecha_de_pago() {
		return fecha_de_pago;
	}

	public void setFecha_de_pago(Date fecha_de_pago) {
		this.fecha_de_pago = fecha_de_pago;
	}
	
	
	
	

	
	
}
