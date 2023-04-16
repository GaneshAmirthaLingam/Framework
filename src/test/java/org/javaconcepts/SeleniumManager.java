package org.javaconcepts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

import org.openqa.selenium.Beta;

import io.cucumber.java.an.E;

@Beta
public class SeleniumManager {

	
		private static final Logger LOG = Logger.getLogger(SeleniumManager.class.getName());
	
		private static final String SELENIUM_MANAGER = "selenium-manager";
		
		private static final String EXE = ".exe";
		
		private static final String INFO = "INFO\t";
		
		private static SeleniumManager manager;
		
		private File binary;
	
	//Wrapper for the Selenium Manager binary.
		
		public SeleniumManager() {
			Runtime.getRuntime().addShutdownHook (new Thread());{
				if(binary != null && binary.exists()){
					try {
						Files.delete(binary.toPath());
					} catch (IOException e) {
						LOG.warning(String.format("%s deleting temporal file: %s",
								e.getClass().getSimpleName(), e.getMessage()));
					
				}
				
				};
		}
	
		}
		
		

}