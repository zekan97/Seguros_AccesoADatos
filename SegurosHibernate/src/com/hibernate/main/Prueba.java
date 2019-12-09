package com.hibernate.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.modelo.Seguro;
import com.hibernate.utilidades.Utilidades;

public class Prueba {

	public static void main(String[] args) {
		Seguro seguro = new Seguro();
		seguro.setIdSeguro(9);
		seguro.setNif("01674193T");
	//	seguro.setNombre("ose");
		//seguro.setApe1("Jorge");
		//seguro.setApe2("Ramirez");
		//seguro.setEdad(22);
		//Ejercicio 3
		
		if(seguro.getEdad() >= 18) {
			seguro.setMayorEdad(true);
		} else {
			seguro.setMayorEdad(false);
		}
		
		//seguro.setSexo(1);
		//seguro.setCasado("Y");
		//seguro.setNumHijos(0);
		//seguro.setFechaCreacion(new Date());
		//seguro.setTipoSeguro("HOGAR");
		
		//Ejercicio 5
		
        try {
        	String date_s = new Date().toString();
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
	        seguro.setFechaNacimiento(dt1.parse(date_s));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Ejercicio 6
        try {
        	String date_s2 = new Date().toString();
            SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss");
			seguro.setHoraContacto(dt1.parse(date_s2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//insertarSeguro(seguro);
		//borrarSeguro(seguro);
		//actualizaSeguro(seguro);
		leerSeguros();
		

	}

	////////////////////////////////////////////////////////////////////
	
	private static void borrarSeguro(Seguro seguro) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.delete(seguro);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error");
		} finally {
			
			session.close();
		}
		
	}

	////////////////////////////////////////////////////////////
	
	private static void insertarSeguro(Seguro seguro) {
		Session session = Utilidades.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(seguro);
		session.getTransaction().commit();
		System.out.println("Seguro=" + seguro.getIdSeguro());
		Utilidades.getSessionFactory().close();
		
	}
	
	////////////////////////////////////////////////////////////////
	
	public static void actualizaSeguro(Seguro seguro) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(seguro);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error");
		} finally {
			session.close();
		}

	}

	////////////////////////////////////////////////////////////////
	
	public static void leerSeguros() {
        try{
        Session session = Utilidades.getSessionFactory().openSession();
        session.beginTransaction();
        List<Seguro> result = (List<Seguro>)session.createQuery("from Seguro").list();
        //List<Seguro> seguro =session.createQuery("select * from seguro;").list();
        session.getTransaction().commit();
        System.out.println(result.toString());
        session.close();
        } catch(HibernateException ex){
            System.out.println(ex.getMessage());
        } 

	}
}
