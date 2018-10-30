package com.example.richi.springbootrestmongodb.filterjson;

public class EdadFilter {

	@Override
	public boolean equals(Object obj) {

		System.out.println("obj" + obj);
		if (obj == null || !(obj instanceof Integer)) {
			return false;
		}
		
		//date should be in the past
		int date = (int) obj;
		if( date == 0 || date >= 100 ) return true;
		else return false;
	}

}
