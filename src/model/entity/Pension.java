package model.entity;

import java.util.ArrayList;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Pension {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String mes;
	@Persistent
	private double monto;
	@Persistent
	private double cancelado;
	@Persistent
	private double saldo;
	
	public Pension(){
		
	}
	public Pension(String m){
		this.mes=m;
		this.monto=200;
		this.cancelado=0;
		this.saldo=monto;
	}
	
	public String getMes(){
		return mes;
	}
	public void setMes(String m){
		this.mes=m;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double mo){
		this.monto=mo;
	}
	public double getCancelado() {
		return cancelado;
	}
	public void setCancelado(double c) {
		cancelado=c;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double s) {
		saldo=s;
	}
	@Override
	public String toString() {
		String resp = mes + " : " + saldo;  
		return resp;
	}

	
}
