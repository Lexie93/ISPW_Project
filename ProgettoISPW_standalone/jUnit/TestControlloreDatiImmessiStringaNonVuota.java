package jUnit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import control.ControlloreDatiImmessi;

@RunWith(value=Parameterized.class)
public class TestControlloreDatiImmessiStringaNonVuota {
	
	private String test;
	
	@Parameters
	public static Collection<String> getTestParameters(){
		return Arrays.asList("aaa","foo","prova","altraProva123");
	}

	public TestControlloreDatiImmessiStringaNonVuota(String test){
		this.test=test;
	}
	
	@Test
	public void testControlloStringaNonVuota() {
		try{
			ControlloreDatiImmessi.controlloStringaNonVuota(test);
		} catch(Exception e){
		fail("Eccezione lanciata per stringa non vuota");
		}
	}

}
