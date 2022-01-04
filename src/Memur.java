/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class Memur implements Calisan{
    private String adSoyad; //direktor tipindeki calisanın gerekli bilgilerini almak icin atamaları yaptık
    private int maas; 
    private String pozisyon;
    
    public Memur(String adSoyad, int maas, String pozisyon){ //constructor
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.pozisyon = pozisyon;
        
    }
    
    @Override
    public void calisanDetaylariniGoster() //cikti icin print
    {
        System.out.println(adSoyad+" "+maas+" ");
    }
    
    public int maasaBak()
    {
        return maas;
    }
}
