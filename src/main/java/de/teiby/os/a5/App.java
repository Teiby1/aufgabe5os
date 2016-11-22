package de.teiby.os.a5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
		try {
			String in = new BufferedReader(new InputStreamReader(System.in)).readLine();
			in = in.toUpperCase();
			System.out.println(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
