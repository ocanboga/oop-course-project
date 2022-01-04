/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 90545
 */


import java.util.ArrayList;
import java.util.List;


public class Composite implements Calisan{
        private List<Calisan> calisanListesi = new ArrayList<Calisan>();
       
    @Override
    public void calisanDetaylariniGoster() 
    {
        for(Calisan calisan:calisanListesi)
        {
            calisan.calisanDetaylariniGoster();
        }
    }
       
    public void calisanEkle(Calisan calisan)
    {
        calisanListesi.add(calisan);
    }
       
    public void calisanSil(Calisan calisan)
    {
        calisanListesi.remove(calisan);
    }
    @Override
    public int maasaBak(){
        for(Calisan calisan:calisanListesi)
        {
            
        }
        return -1;
    }
}
