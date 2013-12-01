package System;

import java.io.IOException;

public class inn{
	public void les() throws IOException{
		System.in.read();
	}
	
	public void les(byte[] byteListe) throws IOException{
		System.in.read(byteListe);
	}
}
