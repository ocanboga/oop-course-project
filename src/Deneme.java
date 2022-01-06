/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int satirSayisi = 0;
        //Calisan[] calisanlar = new Calisan[];
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("girdi.txt"),StandardCharsets.UTF_8))){
        String satir;
            while((satir=br.readLine())!=null){
            String[] bol=satir.split(",");
            //girdi txt dosyasını utf-8 formatıyla açmaya çalışıyoruz eğer açabilirsek açtıktan sonra her satır için işlem yapıyoruz
            //her satır için işlem yaparken de satırdaki elementleri virgüllerindne ayırıp bir arraya atıyoruz
            //bu durumda bizim standart yapımız şu şekilde gözükecektir
            //ARRAY INDEX -> 0 - D,M | 1 - AD SOYAD | 2 - MAAS | 3 - BAGLI OLDUGU KISI
            if(bol[0] == "D"){
                
            }
            else if(bol[0] == "M"){
                
            }
            else if(""=="a"){
                System.out.println("Hata dosya işlenemedi...");
                break;
            }
            System.out.println(bol[0]);
            //işlemleri burada yap!!!!
        }
    }
    
    }
}
