package org.current.nextguidely;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Breader {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 5);
		
		
		while ( true ) {
			int c = bufferedReader.read();
			if ( c == -1 ) break;
			if ( bufferedReader.ready() ) {
				System.out.println(bufferedReader.lines());
			}
		}
	}
}
