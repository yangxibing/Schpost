package com.schpost.Util;

import java.io.UnsupportedEncodingException;
import java.io.*;

public class EncodingTool {  
    public  String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("UTF-8"), "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            
            return null;  
        }  
    }  
    
    public void print(String str)
	{
		System.out.print(str);
		
	}
    

    public static void main(String[] args){
    	
    	
    	EncodingTool one = new EncodingTool();
         one.print("HElloWorld");
    }
   
}  
