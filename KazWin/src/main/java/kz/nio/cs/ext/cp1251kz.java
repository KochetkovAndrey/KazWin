/*
 * cp1251kz.java, v: 0.0.1. 2018
 * Copyright (C) 2016 Andrey Kochetkov
 * 
 * File: cp1251kz.java
 * Description: Charset for supporting kazakh code page 1251.
 * Author's email: kochetkov_andrey@mail.ru 
 */

package kz.nio.cs.ext;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.SingleByte;

public class cp1251kz extends Charset implements HistoricallyNamedCharset{
	
	public cp1251kz() {
		super( "cp1251kz", KazakhCharset.aliasesFor( "cp1251kz" ) );
	}
	
	public cp1251kz( String canonicalName, String[] aliases ) {
		super( canonicalName, aliases );
	}

	@Override
	public boolean contains(Charset cs ) {
		return cs instanceof cp1251kz;
	}

	@Override
	public CharsetDecoder newDecoder() {
		return new SingleByte.Decoder( this, b2c );
	}

	@Override
	public CharsetEncoder newEncoder() {
		
		return new SingleByte.Encoder( this, c2b, c2bIndex );
	}

	@Override
	public String historicalName() {
		return "cp1251kz";
	}
	
	public char[] getEncoderIndex1() {
		return c2bIndex;
	}
	
	public char[] getEncoderIndex2() {
		return c2b;
	}
	
	public String getDecoderSingleByteMappings() {
		return b2cTable;
		
	}
	
	private static String b2cTable = 
	/* Кодировка 1251
	        "\u0402\u0403\u201A\u0453\u201E\u2026\u2020\u2021" +      // 0x80 - 0x87
	        "\u20AC\u2030\u0409\u2039\u040A\u040C\u040B\u040F" +      // 0x88 - 0x8f
	 */            
	/* Кодировка 1251-k            
	        "\u04B0\u0492\u201A\u0493\u201E\u2026\u2020\u2021" +      // 0x80 - 0x87
	        "\u20AC\u2030\u04E8\u2039\u04A2\u049A\u04BA\u04AE" +      // 0x88 - 0x8f
	*/            
	        "\u0402\u0403\u201A\u0453\u201E\u2026\u2020\u2021" +      // 0x80 - 0x87
	        "\u20AC\u2030\u0409\u2039\u040A\u049A\u04BA\u040F" +      // 0x88 - 0x8f
	            
	/* Кодировка 1251
	        "\u0452\u2018\u2019\u201C\u201D\u2022\u2013\u2014" +      // 0x90 - 0x97
	        "\uFFFD\u2122\u0459\u203A\u045A\u045C\u045B\u045F" +      // 0x98 - 0x9f
	*/
	/* Кодировка 1251-k            
	        "\u04B1\u2018\u2019\u201C\u201D\u2022\u2013\u2014" +      // 0x90 - 0x97
	        "\uFFFD\u2122\u04E9\u203A\u04A3\u049B\u04BB\u04AF" +      // 0x98 - 0x9f
	*/
	        "\u0452\u2018\u2019\u201C\u201D\u2022\u2013\u2014" +      // 0x90 - 0x97
	        "\uFFFD\u2122\u0459\u203A\u045A\u049B\u04BB\u045F" +      // 0x98 - 0x9f
	            
	/* Кодировка 1251
	        "\u00A0\u040E\u045E\u0408\u00A4\u0490\u00A6\u00A7" +      // 0xa0 - 0xa7
	        "\u0401\u00A9\u0404\u00AB\u00AC\u00AD\u00AE\u0407" +      // 0xa8 - 0xaf
	*/            
	/* Кодировка 1251-k
	        "\u00A0\u040E\u045E\u0496\u00A4\u04B2\u00A6\u00A7" +      // 0xa0 - 0xa7
	        "\u0401\u00A9\u0404\u00AB\u00AC\u00AD\u00AE\u0407" +      // 0xa8 - 0xaf
	*/           
    //      "\u00A0\u04B0\u04B1\u04D8\u00A4\u04E8\u00A6\u00A7" +      // 0xa0 - 0xa7
	        "\u00A0\u04B0\u04B1\u04D8\u00A4\u04E8\u00A6\u00A7" +      // 0xa0 - 0xa7
	        "\u0401\u00A9\u0492\u00AB\u00AC\u00AD\u00AE\u04AE" +      // 0xa8 - 0xaf
	/* Кодировка 1251
	        "\u00B0\u00B1\u0406\u0456\u0491\u00B5\u00B6\u00B7" +      // 0xb0 - 0xb7
	        "\u0451\u2116\u0454\u00BB\u0458\u0405\u0455\u0457" +      // 0xb8 - 0xbf
	*/            
	/* Кодировка 1251-k
	        "\u00B0\u00B1\u0406\u0456\u0491\u00B5\u00B6\u00B7" +      // 0xb0 - 0xb7
	        "\u0451\u2116\u0454\u00BB\u0458\u0405\u04D9\u0457" +      // 0xb8 - 0xbf
	*/    
	        "\u00B0\u00B1\u0406\u0456\u04E9\u00B5\u00B6\u00B7" +      // 0xb0 - 0xb7
	        "\u0451\u2116\u0493\u00BB\u04D9\u04A2\u04A3\u04AF" +      // 0xb8 - 0xbf
	            
	        "\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417" +      // 0xc0 - 0xc7
	        "\u0418\u0419\u041A\u041B\u041C\u041D\u041E\u041F" +      // 0xc8 - 0xcf
	        "\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427" +      // 0xd0 - 0xd7
	        "\u0428\u0429\u042A\u042B\u042C\u042D\u042E\u042F" +      // 0xd8 - 0xdf
	        "\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437" +      // 0xe0 - 0xe7
	        "\u0438\u0439\u043A\u043B\u043C\u043D\u043E\u043F" +      // 0xe8 - 0xef
	        "\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447" +      // 0xf0 - 0xf7
	        "\u0448\u0449\u044A\u044B\u044C\u044D\u044E\u044F" +      // 0xf8 - 0xff
	        "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007" +      // 0x00 - 0x07
	        "\b\t\n\u000B\f\r\u000E\u000F"                     +      // 0x08 - 0x0f
	        "\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017" +      // 0x10 - 0x17
	        "\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F" +      // 0x18 - 0x1f
	        "\u0020\u0021\"\u0023\u0024\u0025\u0026\'"         +      // 0x20 - 0x27
	        "\u0028\u0029\u002A\u002B\u002C\u002D\u002E\u002F" +      // 0x28 - 0x2f
	        "\u0030\u0031\u0032\u0033\u0034\u0035\u0036\u0037" +      // 0x30 - 0x37
	        "\u0038\u0039\u003A\u003B\u003C\u003D\u003E\u003F" +      // 0x38 - 0x3f
	        "\u0040\u0041\u0042\u0043\u0044\u0045\u0046\u0047" +      // 0x40 - 0x47
	        "\u0048\u0049\u004A\u004B\u004C\u004D\u004E\u004F" +      // 0x48 - 0x4f
	        "\u0050\u0051\u0052\u0053\u0054\u0055\u0056\u0057" +      // 0x50 - 0x57
	        "\u0058\u0059\u005A\u005B\\\u005D\u005E\u005F"     +      // 0x58 - 0x5f
	        "\u0060\u0061\u0062\u0063\u0064\u0065\u0066\u0067" +      // 0x60 - 0x67
	        "\u0068\u0069\u006A\u006B\u006C\u006D\u006E\u006F" +      // 0x68 - 0x6f
	        "\u0070\u0071\u0072\u0073\u0074\u0075\u0076\u0077" +      // 0x70 - 0x77
	        "\u0078\u0079\u007A\u007B\u007C\u007D\u007E\u007F" ;      // 0x78 - 0x7f
	private final static char[] b2c = b2cTable.toCharArray();
	private final static char[] c2b = new char[ 0x500 ];
	private final static char[] c2bIndex = new char[ 0x100 ];
	
	static {
		char[] b2cMap = b2c;
		char[] c2bNR  = null;
		SingleByte.initC2B( b2cMap, c2bNR, c2b, c2bIndex );
	}
  
}
