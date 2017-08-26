package com.topFifty.questions;

public class ReverseStringWordByWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "The sky is blue";
		String rev = reverse(s);
		System.out.println(rev);
		
	}
	
	public static String reverse(String str){
		String[] array = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=array.length-1;i>=0;--i){
			if(!array[i].equals("")){
				sb.append(array[i]).append(" ");
			}
		}
		return sb.length()==0? "" : sb.substring(0, sb.length()-1);
	}

}
