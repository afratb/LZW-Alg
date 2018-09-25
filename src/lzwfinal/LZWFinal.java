/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzwfinal;

//import java.util.HashMap;

import java.util.ArrayList;

//import java.util.Map;

public class LZWFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        compress();
         asc();
         Skstrma("TOBEORNOTTOBEORNOT");
    }//lzw
    static int szsay = 256;
static public ArrayList<sozluk> lst = new ArrayList<sozluk>();    
    public static void asc(){
        for(int i=0;i<256;i++){
            sozluk sz = new sozluk();
            sz.deger= i;
            sz.say=0;
            char b = (char) i;
            sz.karakter = String.valueOf(b);
            lst.add(sz);
        }
    }
    static class sozluk {
        int deger;
        String karakter;
        int say;
    }
    static int i=0;
    static public StringBuffer strb = new StringBuffer();
    public static void Skstrma(String metin){
        for(i=0;i<metin.length();i++)
        {
            int kac = recurs(String.valueOf(metin.charAt(i)),metin);
            System.out.print(kac+"  ");
        } 
        
    }
   
    static public int recurs(String k,String metin){
        int bok = strb.length();
        Boolean bul =false;
        int kac = 0;
        for(int j=0;j<lst.size();j++)
        {   
            if(lst.get(j).karakter.equals(String.valueOf(k)) && lst.get(j).say==0)
            { 
                lst.get(j).say++;strb.delete(0, bok); bul=true; kac=j;}
        }
        if(bul==false && strb.length()==0){
            i++;
            strb.append(k + metin.charAt(i));
            return recurs(String.valueOf(strb), metin);
        }
        else if(bul==false && strb!=null){
//            i++;
//            strb.append(k + metin.charAt(i));
            sozluk sz = new sozluk();
            sz.deger= szsay;
            sz.say=0;
            sz.karakter = String.valueOf(strb);
            lst.add(sz);
            strb.delete(0, bok);
            return szsay++;
        }
        
        
        return kac;
       
    }
}
