package com.dcmomis.utils;

import java.io.InputStream;
import java.util.Properties;

import com.sun.org.apache.xalan.internal.xsltc.compiler.SourceLoader;

public class initUtils {
	
	public static void main(String args[]) throws Exception { 
		loadProperties();
	}
    public static Properties loadProperties() throws Exception{
        Properties p=new Properties();

        SourceLoader.class.getClassLoader();
//		InputStream is=ClassLoader.getSystemResourceAsStream("config.properties");
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        p.load(is);
        System.out.println(p);
        return p;
    }
}
