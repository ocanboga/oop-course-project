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
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            if(bol[0].equals("D")){
                Direktor yeniMemur = new Direktor(bol[1],Integer.parseInt(bol[2]),bol[0],bol[3]); //String isim, int maas, String pozisyon,String baglanti
            }
            else if(bol[0].equals("M")){
                Memur yeniDirektor = new Memur(bol[1],Integer.parseInt(bol[2]),bol[0],bol[3]);                
            }
            else{
                System.out.println("Hata dosya işlenemedi...");
                System.out.println("Dosyanın doğru konumda olduğundan emin olun!");
                System.out.println("Dosya'nın içeriğinin doğru şekilde yazıldığından emin olun!");
                
            }
                  
        }
        
    }
        catch(Exception e){
            System.out.println("Bilinmeyen hata konsolu kontrol edin.");
        }
        System.out.println("Verilen dosya/database başarı ile okundu.");
        
        Scanner scannerObj = new Scanner(System.in);  // Girdi almak için scanner
        System.out.println("Lütfen geçerli bir kullanıcı adını eksiksiz bir şekilde girin.");
        String calisanAdi = scannerObj.nextLine();
        
        System.out.println("Girdiğiniz isme göre dosya/database tarandı bilgiler şu şekildedir:");
      
        Composite compositeTip = new Composite(calisanAdi);
        compositeTip.calisanDetaylariniGoster();
        
    }
}
