package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import control.ControlloreDatiImmessi;

public class TestControlloreDatiImmessiControlloEMail {

	@Test
	public void TestControlloEMail() {
		try{
			ControlloreDatiImmessi.controlloEMail("EmailValida@123.it", "");
			
		} catch(Exception e){
			fail("Eccezione lanciata per una email valida");
		}
		
		try{
			ControlloreDatiImmessi.controlloNumero("EmailSenzaChiocciola.com", "");
			fail("Eccezione non lanciata per Email senza chiocciola");
			
		} catch(Exception e){
		}
		
		try{
			ControlloreDatiImmessi.controlloNumero("EmailSenzaPunto@123", "");
			fail("Eccezione non lanciata per Email senza punto");
			
		} catch(Exception e){
		}
		
	}

}
