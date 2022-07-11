package co.com.sodimac.ini.sodimac.rest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import com.google.common.annotations.Beta;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;


public class LecturaProps {
	
	private String props="";
	
	public String myProperties() {

	try  {
			File fl=new File("src/main/resources/misprops.properties");
			
			//Load properties
	        loadProperties(fl);
	        
	       //save properties with new token
	        saveProperties(fl);
	        System.out.println("After saving properties: " + props);
	       
	        
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	finally {
		 return props;
	}
		
	}
	
	private void saveProperties(File f) throws IOException
    {
		Properties prop = new Properties();
        FileOutputStream fr = new FileOutputStream(f);
        
        String nuevoTk=randomToken();
        prop.setProperty("mitoken", nuevoTk);
        String propsVar=prop.getProperty("mitoken");
               
        prop.store(fr, propsVar);
        props=propsVar;
        fr.close();
       
    }

    private void loadProperties(File f)throws IOException
    {
    	Properties prop = new Properties();
        FileInputStream fi=new FileInputStream(f);
        prop.load(fi);
        
        // get the property value and print it out
        String propVar=prop.getProperty("mitoken");
        System.out.println("Mi token actual es:"+propVar);
        
        fi.close();
        System.out.println("After Loading properties: " + prop);
    }
	
	/**
	 * Generador de token
	 * @return
	 */
	private String  randomToken()
	{
		String tokenGenerated = RandomStringUtils.randomAlphanumeric(10);

	    System.out.println("new Token "+tokenGenerated);
	    return tokenGenerated;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String bye()
	{
		return "Consumo Exitoso, bye";
	}
	
}
