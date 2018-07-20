package model.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Recibo {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String codigo;
	@Persistent
	private String nombre;
	@Persistent
	private int numero;
	@Persistent
	private int año;
	@Persistent
	private int mes;
	@Persistent
	private int dia;
	@Persistent
	private String concepto;
	@Persistent
	private double monto;
	@Persistent
	private double cancelado;
	@Persistent
	private double saldo;
				
	public Recibo() {
		
	}
	public Recibo(String co,String al,String con,double m,double c,double s) {
		this.codigo=co;
		this.nombre=al;
		this.numero=800100;
		this.concepto=con;
		this.monto=m;
		this.cancelado=c;
		this.saldo=s;
		Calendar fecha = Calendar.getInstance();
        this.año = fecha.get(Calendar.YEAR);
        this.mes=fecha.get(Calendar.MONTH)+1;
        this.dia=fecha.get(Calendar.DAY_OF_MONTH);
	}
	public String getCodigo(){
		return this.codigo;
	}
	public void setCodigo(String cod){
		this.codigo=cod;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String n){
		this.nombre=n;
	}
	public int getNumero(){
		return this.numero;
	}
	public void setNumero(int nu){
		this.numero=nu;
	}
	public String getConcepto(){
		return this.concepto;
	}
	public void setConcepto(String c){
		this.concepto=c;
	}
	public double getMonto(){
		return this.monto;
	}
	public void setMonto(double m){
		this.monto=m;
	}
	public double getCancelado(){
		return this.cancelado;
	}
	public void setCancelado(double c){
		this.cancelado=c;
	}
	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double s){
		this.saldo=s;
	}
	public int getAño(){
		return this.año;
	}
	public int getMes(){
		return this.mes;
	}
	public int getDia(){
		return this.dia;
	}
	
	public Key getKey() {
		return key;
	}
	
	
}
