package jUnit;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import database.ArticoloDao;
import entity.Articolo;

public class TestArticoloDao {

	@Test
	public void testCercaPerUtente() {
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			String u="Alex";
			Vector<Articolo> articoli= aDao.cercaPerUtente(u);
		
			assertTrue(!articoli.isEmpty());
		
			for(int i=0;i<articoli.size();i++){
				assertEquals(u.toLowerCase(),articoli.get(i).getVenditore().trim().toLowerCase());
			}
		
			u="";
			articoli=aDao.cercaPerUtente(u);
		
			assertTrue(articoli.isEmpty());
			} catch(Exception e) {
				fail(e.getMessage());
			}
		
	}
	
	@Test
	public void testCreaArticolo(){
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			aDao.creaArticolo("testNome", "testDescrizione", "123", "venditoreNonEsistente");
			fail("Eccezione non lanciata");
			
		} catch(Exception e) {
		}
	}
	
	@Test
	public void testCerca(){
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			Vector<Articolo> articoli=aDao.cerca("orologio");
			
			assertEquals(articoli.get(0).getID(),(Integer) 30);
			assertEquals(articoli.get(0).getDescrizione().trim(),"orologio nuovo marca Swatch. Analogico, colore blu.");
			assertEquals(articoli.get(0).getPrezzo(),"119.99");
			assertEquals(articoli.get(0).getVenditore().toLowerCase().trim(),"alex");
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetArticolo(){
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			Articolo articolo=aDao.getArticolo(30);
			
			assertEquals(articolo.getNome().toLowerCase().trim(),"orologio");
			assertEquals(articolo.getDescrizione().trim(),"orologio nuovo marca Swatch. Analogico, colore blu.");
			assertEquals(articolo.getPrezzo(),"119.99");
			assertEquals(articolo.getVenditore().toLowerCase().trim(),"alex");
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testRimuoviArticolo(){
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			aDao.rimuoviArticolo((int) -1);
			fail("Eccezione non lanciata");
			
		} catch(Exception e) {
		}
		
	}
	
	//@Ignore
	@Test
	public void testModificaArticolo(){
		
		ArticoloDao aDao= ArticoloDao.getSingletonInstance();
		
		try{
			aDao.modificaArticolo((int) 29, "orologio", "testDescrizione", "123");
			fail("Eccezione non lanciata");
			
		} catch(Exception e) {
		}
		
	}

}