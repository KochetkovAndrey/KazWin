/*
 * KazakhCharsetStringConversionTest.java, v: 0.0.1 2016
 * Copyright: (C) 2018 Andrey Kochetkov
 */
package kz.nio.cs.ext.test;

import static org.junit.Assert.*;

import org.junit.Test;
import kz.nio.cs.ext.KazakhCharset;

public class KazakhCharsetStringConversionTest {

	@Test
	public void testAliasesFor() {
		//assertArrayEquals("Unexpected aliases", new String [ ] { "cp1251kz", "CP1251KZ", "cp1251", "CP1251", "CP1251kz", "cp1251KZ" }, KazakhCharset.aliasesFor("cp1251kz"));
		assertArrayEquals("Unexpected aliases", new String [ ] { "cp1251kz", "CP1251KZ", "CP1251kz", "cp1251KZ" }, KazakhCharset.aliasesFor("cp1251kz"));
	}
	@Test
	public void testConversionString(){
		String sSource = "\u049A\u04BA\u049B\u04BB\u04B0\u04B1\u04D9\u04E8\u04E9\u0492\u0493\u04AE\u04AF\u04A2\u04A3\u04D8";
		//String sSource = "ӘәІіҢңҒғҮүҰұҚқӨөҺһ";
		String sCp1251kz = "";
		String sUTF8     = ""; 
		sCp1251kz = KazakhCharset.convertUTF8ToCp1251Kz(sSource);
		System.out.println("UTF8 => cp1251kz " + sSource + " => " + sCp1251kz);
		sUTF8 = KazakhCharset.convertCp1251KzToUTF8(sCp1251kz);
		System.out.println("cp1251kz => UTF8 " + sCp1251kz + " => " + sUTF8);
		assertEquals("Wrong convertion ", sSource, sUTF8);
	}
}
