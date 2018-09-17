/*
 * KazakhChzrset.java, v: 0.0.1 2018
 * Copyright: (C) 2018 Andrey Kochetkov
 */

package kz.nio.cs.ext;


import sun.nio.cs.AbstractCharsetProvider;

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;

import sun.misc.VM;


public class KazakhCharset extends AbstractCharsetProvider{
	
	static volatile SoftReference<KazakhCharset> instance = null;

	private boolean initialized = false;
	
	public KazakhCharset(){
		super( "kz.nio.cs.ext" );
		//charset( "cp1251kz", "cp1251kz", new String [ ] { "cp1251kz", "CP1251KZ", "cp1251", "CP1251", "CP1251kz", "cp1251KZ" } );
		charset( "cp1251kz", "cp1251kz", new String [ ] { "cp1251kz", "CP1251KZ", "CP1251kz", "cp1251KZ" } );
		instance = new SoftReference<KazakhCharset>( this );
	}
	protected void init(){
		if ( initialized == true ) {
			 return;
		}
		if ( !VM.isBooted() ){
			 return;
		}
		initialized = true;
	}
	public static String[] aliasesFor( String charsetName ){
		SoftReference<KazakhCharset> sr = instance;
		KazakhCharset sc = null;
		if ( sr != null ) {
			 sc = (KazakhCharset) sr.get();
		}
		if ( sc == null ) {
			 sc       = new KazakhCharset();
			 instance = new SoftReference<KazakhCharset>( sc );
		}
		return sc.aliases( charsetName );
	}
	/**
	 * Converting in cp1251kz
	 * Конвертация в cp1251kz  
	 * @param sUTF8 incoming string in UTF8/входящая строка в UTF8
	 * @return returning param in cp1251kz/возвращает param в cp1251kz 
	 */
	public static String convertUTF8ToCp1251Kz(String sUTF8){
		try {
			return new String(sUTF8.getBytes("cp1251kz"), "cp1251");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * Converting in UTF8
	 * Конвертация в UTF8  
	 * @param sCp1251Kz incoming string in cp1251kz/входящая строка в cp1251kz
	 * @return returning param in UTF8/возвращает param в UTF8 
	 */
	public static String convertCp1251KzToUTF8(String sCp1251Kz){
		try {
			return new String(sCp1251Kz.getBytes("cp1251"), "cp1251kz");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
