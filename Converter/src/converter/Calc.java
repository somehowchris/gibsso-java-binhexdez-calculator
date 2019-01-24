/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.math.BigInteger;

/**
 *
 * @author chris
 */
public class Calc {
    
    public String binToHex(int bin){

        int byteLength = 4;
        int bitStartPos = 0, bitPos = 0;
        String hexString = "";
        String bitStream = bin+"";
        int sum = 0;

        if(bitStream.length()%4 !=0){
             int tempCnt = 0;
             int tempBit = bitStream.length() % 4;           
             while(tempCnt < (byteLength - tempBit)){
                 bitStream = "0" + bitStream;
                 tempCnt++;
             }
        }

        while(bitStartPos < bitStream.length()){
            while(bitPos < byteLength){
                sum = (int) (sum + Integer.parseInt("" + bitStream.charAt(bitStream.length()- bitStartPos -1)) * Math.pow(2, bitPos)) ;
                bitPos++;
                bitStartPos++;
            }
            if(sum < 10)
                 hexString = Integer.toString(sum) + hexString;
            else 
                 hexString = (char) (sum + 55) + hexString;

            bitPos = 0;
            sum = 0;
        }
        return hexString;
    }
    public int binToDez(int bin){
        int decNum = 0;
        int remainer;
        int multi = 1;
        
        while(bin != 0){
            remainer = bin % 10;
            decNum = decNum + remainer * multi;
            multi = multi * 2;
            bin = bin / 10;
        }
        return decNum;
    }
    
    static String dezToBin(int no){
        StringBuilder result = new StringBuilder();
        int i =0;
        while (no > 0){
            result.append(no%2);
            i++;
            no = no/2;
        }
        return result.reverse().toString();
    }
    
    public static int hexToDez(String hex){  
        String digits = "0123456789ABCDEF";  
        hex = hex.toUpperCase();  
        int val = 0;  
        for (int i = 0; i < hex.length(); i++)  
        {  
            char c = hex.charAt(i);  
            int d = digits.indexOf(c);  
            val = 16*val + d;  
        }  
        return val;  
    } 
    
    public static String dezToHex(int decimal){    
        int rem;  
        String hex="";   
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        while(decimal>0){  
            rem=decimal%16;   
            hex=hexchars[rem]+hex;   
            decimal=decimal/16;  
        }  
        return hex;  
    }  
    
    static String hexToBin(String s) {
        String preBin = new BigInteger(s, 16).toString(2);
        Integer length = preBin.length();
        if (length < 8) {
            for (int i = 0; i < 8 - length; i++) {
                preBin = "0" + preBin;
            }
        }
        return preBin;
    }
}
