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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Deneme {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
        int satirSayisi = 0;
        BufferedReader br = new TXTReader().readFile(); //Burada dosya okuma işlemi yapılıyor biz bu projede TXT formatında dosya açtık ancak -->
        //<-- daha sonra başka türde dosyalar (örnek olarak XML ve Excel ekledik) veya databaseler açılabilir. (Detaylar için sınıfın kendisine bakın.
        String satir;
            while((satir=br.readLine())!=null){
            String[] bol=satir.split(",");
            //girdi txt dosyasını utf-8 formatıyla açmaya çalışıyoruz eğer açabilirsek açtıktan sonra her satır için işlem yapıyoruz
            //her satır için işlem yaparken de satırdaki elementleri virgüllerindne ayırıp bir arraya atıyoruz
            //bu durumda bizim standart yapımız şu şekilde gözükecektir
            //ARRAY INDEX -> 0 - D,M | 1 - AD SOYAD | 2 - MAAS | 3 - BAGLI OLDUGU KISI
            if(bol[0].equals("D")){ //dosyayı okurken her D girdisine sahip olan için bir direktor oluştur
                Direktor yeniMemur = new Direktor(bol[1],Integer.parseInt(bol[2]),bol[0],bol[3]); //String isim, int maas, String pozisyon,String baglanti
            }
            else if(bol[0].equals("M")){ //dosyayı okurken her M girdisine sahip olan için bir Memur oluştur
                Memur yeniDirektor = new Memur(bol[1],Integer.parseInt(bol[2]),bol[0],bol[3]);                
            }
            else{ //Dosya açma işlemi başta hatalıysa burada da kullanıcıyı bilgilendirdik.
                System.out.println("Hata dosya işlenemedi...");
                System.out.println("Dosyanın doğru konumda olduğundan emin olun!");
                System.out.println("Dosya'nın içeriğinin doğru şekilde yazıldığından emin olun!");
                
            }
                  
        }
        
    
        
        System.out.println("Verilen dosya/database başarı ile okundu.");
        Composite compositeTip = new Composite(); //composite tipimizi oluşturduk artık atadığımı şeyleri bu üst tipten
        //çekebilir ve değerlerine bakabiliriz.
        Scanner scannerObj = new Scanner(System.in);  // Girdi almak için scanner
        //Buradan sonrası projede verilen isimlerin yazdırılması ve bir takım string, açıklama ve düzenleme işlemleri.
        System.out.println("Enter tuşuna bastığınızda öncelikle projede istenilen kişilerin bilgileri yazdırılacaktır.");
        System.out.println("Ardından kendiniz de bir isim girerek verilere bakabilirsiniz.");
        String gecisTusu = scannerObj.nextLine(); // beklemek için boş input
        //PROJEDE İSTENEN ÇIKTILAR
        System.out.println("MUSTAFA TURKSEVER'İN BİLGİLERİ:");
        compositeTip.aranacakCalisanAyarla("Mustafa Turksever");
        compositeTip.calisanDetaylariniGoster();
        
        System.out.println("OĞUZ DEMİR'İN BİLGİLERİ:");
        compositeTip.aranacakCalisanAyarla("Oguz Demir");
        compositeTip.calisanDetaylariniGoster();
        
        System.out.println("AHMET EGELİ'NİN BİLGİLERİ:");
        compositeTip.aranacakCalisanAyarla("Ahmet Egeli");
        compositeTip.calisanDetaylariniGoster();
        
        System.out.println("");
        System.out.println("Verilecek tabloda MAVİ: Direktor, SİYAH: Memur'ları ifade etmektedir.");
        System.out.println("Lütfen geçerli bir kullanıcı adını eksiksiz bir şekilde girin.(Tablonun üstündeki bilgilendirmeyi okuyarak renklerin ne ifade ettiğini öğrenebilirsiniz.)");
       
        String calisanAdi = scannerObj.nextLine();
        System.out.println("Girdiğiniz isme göre dosya/database tarandı bilgiler şu şekildedir:");
        compositeTip.aranacakCalisanAyarla(calisanAdi);
        compositeTip.calisanDetaylariniGoster();
        
    
    }
}  

