package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import control.ControlloreDatiImmessi;

public class TestControlloreDatiImmessiControlloLunghezza {
	
	@Test
	public void testControlloLunghezzaMassimaStringa() {
		try{
			ControlloreDatiImmessi.controlloLunghezzaMassima("stringa corta", 20, "");
			
		} catch(Exception e){
			fail("Eccezione lanciata per stringa non troppo lunga");
		}
		
		try{
			ControlloreDatiImmessi.controlloLunghezzaMassima("stringa lunga", 5, "");
			fail("Eccezione non lanciata per stringa troppo lunga");
			
		} catch(Exception e){
		}
	}
	
	@Test
	public void testControlloLunghezzaMinimaStringa() {
		try{
			ControlloreDatiImmessi.controlloLunghezzaMinima("stringa lunga", 5, "");
			
		} catch(Exception e){
			fail("Eccezione lanciata per stringa non troppo corta");
		}
		
		try{
			ControlloreDatiImmessi.controlloLunghezzaMinima("stringa corta", 20, "");
			fail("Eccezione non lanciata per stringa troppo corta");
			
		} catch(Exception e){
		}
	}

}
