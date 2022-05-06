package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import control.ControlloreDatiImmessi;

public class TestControlloreDatiImmessiNumerici {

	@Test
	public void TestControlloNumero() {
		try{
			ControlloreDatiImmessi.controlloNumero("123456", "");
			
		} catch(Exception e){
			fail("Eccezione lanciata per un numero");
		}
		
		try{
			ControlloreDatiImmessi.controlloNumero("non numero", "");
			fail("Eccezione non lanciata per stringa non trasformabile in numero");
			
		} catch(Exception e){
		}
		
		try{
			ControlloreDatiImmessi.controlloNumero("12.43", "");
			fail("Eccezione non lanciata per numero non valido");
			
		} catch(Exception e){
		}
	}
	
	@Test
	public void TestControlloDouble() {
		try{
			ControlloreDatiImmessi.controlloDouble("123456");
			
		} catch(Exception e){
			fail("Eccezione lanciata per un numero");
		}
		
		try{
			ControlloreDatiImmessi.controlloDouble("non numero");
			fail("Eccezione non lanciata per stringa non trasformabile in numero");
			
		} catch(Exception e){
		}
		
		try{
			ControlloreDatiImmessi.controlloDouble("12.43");
			
		} catch(Exception e){
			fail("Eccezione lanciata per numero valido");
		}
	}

}
