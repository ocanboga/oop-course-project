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
    
    public Direktor(String isim, int maas, String pozisyon){ //constructor
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.pozisyon = pozisyon;
        
    }
    
    @Override
    public void calisanDetaylariniGoster() //cikti icin print
    {
        System.out.println(adSoyad+" "+maas+" ");
    }
   
    @Override
    public int maasaBak()
    {
        return maas;
    }
    
        public void calisanEkle(Calisan calisan)
    {
        calisanListesi.add(calisan);
    }
    @Override
    public void calisanSil(Calisan calisan)
    {
        calisanListesi.remove(calisan);
    }
    
}
