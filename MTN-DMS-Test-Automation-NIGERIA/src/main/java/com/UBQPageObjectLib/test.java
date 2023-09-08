package com.UBQPageObjectLib;



public class test {
public static void main(String[] args) {
String s = "11.0";
	s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
System.out.println(s);

	
}
}
