package de.wicketpraxis.components;

import java.io.Serializable;

public class BigContainer implements Serializable{
	
	private byte[] data;

	public BigContainer(int size) {
		data=new byte[size];
	}
}
