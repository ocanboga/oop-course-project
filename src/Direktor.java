/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
*/


public class Direktor implements Calisan { //Calisan interface'ni alan direktor tipinde bir calisan olusturduk
    private String adSoyad; //direktor tipindeki calisanın gerekli bilgilerini almak icin atamaları yaptık
    private int maas; 
    private String pozisyon;
    private String baglanti;
    public static Calisan[] direktorArr = new Calisan[0];
    private static int direktorSayac = 0;
    
    public Direktor(String isim, int maas, String pozisyon, String baglanti){ //constructor
        this.adSoyad = isim;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.baglanti = baglanti;
        Direktor tempCalisan = new Direktor(isim,maas,pozisyon,baglanti,1);
        arrayeEkle(tempCalisan);
    }
    
    public Direktor(String isim, int maas, String pozisyon,String baglanti,int temp){ //constructor temp obje oluşturmak için
        this.adSoyad = isim;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.baglanti = baglanti;
    }
    
    public Direktor(){
        
    }
    
    @Override
    public void calisanDetaylariniGoster() //cikti icin print
    {
        System.out.println(" ");    
        System.out.println("Name ="+ismeBak());  
        System.out.println("Salary ="+maasaBak());  
        System.out.println(" ");  
    }
   
    @Override
    public int maasaBak()
    {
        return maas;
    }
    
    public void maasAyarla(int yeniMaas){
        this.maas = yeniMaas;
    }
    
    @Override
    public String ismeBak(){
        return adSoyad;
    }
    
    @Override
    public String pozisyonBak(){
        return pozisyon;
    }
    
    @Override
    public String baglantiBak(){
        return baglanti;
    
    }
    public Calisan[] direktorleriAl(){
        return direktorArr;
    }
    
    private void arrayeEkle(Calisan calisan){
        this.direktorArr = arrayBoyutuArttır(this.direktorArr);
        this.direktorArr[direktorSayac] = calisan;
        this.direktorSayac +=1;
    }
    
    public int direktorSayisiniAl(){
        return direktorSayac;
    }
    
    private static Calisan[] arrayBoyutuArttır(Calisan[] array){
        Calisan[] yeniArray = new Calisan[array.length + 1];//ekeleyeğimiz her element için arrayin büyüklüğünü 1 arttırdık
        for(int i = 0; i < array.length; i++)
        {
            yeniArray[i] = array[i];//eski elemanları yeni arraye kopyaladık
        }
        return yeniArray;
    }
}
