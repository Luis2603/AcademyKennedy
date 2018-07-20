package model.entity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import model.entity.Pension;
import model.entity.Recibo;



@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Alumno {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private String names;
	@Persistent private String apellidos;
	@Persistent private String edad;
	@Persistent private String degree;
	@Persistent private String DNI;
	@Persistent private String email;

	
	@Persistent private Date created;
	@Persistent private Date birth;
	@Persistent private boolean gender;
	@Persistent private int age;
	//LocalDateTime current_date=LocalDateTime.now(ZoneId.of("America/Lima"));
	private ArrayList<Pension> pensiones;
	@Persistent
	private String monto;
	private ArrayList<Recibo> recibos;
	private ArrayList<Date> fechas;
	
	public Alumno(String email,String names,String apellidos,String dni,boolean gender,Date birth,String degree,String edad) {
		super();
		this.email = email;
		this.names = names;
		this.apellidos = apellidos;
		DNI = dni;
		this.gender = gender;
		this.birth = birth;
		this.degree = degree;
		this.edad = edad;
		
		this.created = new Date();
		
		pensiones=new ArrayList<Pension>();
		this.renovPensiones(pensiones);
		recibos=new ArrayList<Recibo>();
		
		
	}
	public Alumno(String names,String monto) {
		super();
		
		this.names = names;
		this.monto=monto;
		
		pensiones=new ArrayList<Pension>();
		this.renovPensiones(pensiones);
		recibos=new ArrayList<Recibo>();
		
		
	}
	public void renovPensiones(ArrayList<Pension>p){
		p.add(new Pension("Marzo"));
		p.add(new Pension("Abril"));
		p.add(new Pension("Mayo"));
		p.add(new Pension("Junio"));
		p.add(new Pension("Julio"));
		p.add(new Pension("Agosto"));
		p.add(new Pension("Septiembre"));
		p.add(new Pension("Octubre"));
		p.add(new Pension("Noviembre"));
		p.add(new Pension("Diciembre"));
		
	}
	
	public ArrayList<Pension> getPensiones(){
		return pensiones;
	}
	public void setPensiones(ArrayList<Pension> p){
		this.pensiones=p;
	}
	public Pension getPension(String m){
		int i=0;
		Pension p=new Pension();
		for(i=0;i<pensiones.size();i++){
			if(pensiones.get(i).getMes().equals(m))
				p=pensiones.get(i);
		}
		return p;
	}
	
	public void addRecibo(Recibo rec){
		Recibo nuevo=rec;
		this.recibos.add(nuevo);
	}
	public ArrayList<Recibo> getRecibos(){
		return recibos;
	}
	public void setRecibos(ArrayList<Recibo> r){
		this.recibos=r;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	/*
	public int getAge() {
		return age;
	}
	public void setAge(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd//MM//yyyy" );
		String a=sdf.format(date);
		String a1=a.substring(0,a.indexOf("/"));
		String b=a.substring(a.indexOf(a1),a.length());
		String a2=a.substring(a.indexOf(a1)+1,b.indexOf("/"));
		String c=a.substring(a.indexOf(a2),a.length());
		String a3=a.substring(a.indexOf(a2)+1,a.length());
		String d=sdf.format(current_date);
		String d1=a.substring(0,d.indexOf("/"));
		String e=a.substring(d.indexOf(d1),d.length());
		String d2=d.substring(d.indexOf(d1)+1,e.indexOf("/"));
		String f=d.substring(d.indexOf(d2),d.length());
		String d3=d.substring(d.indexOf(d2)+1,d.length());
		age=Integer.parseInt(d3)-Integer.parseInt(a3);
		}
		*/
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	
}
	


