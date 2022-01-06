/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 90545
 */
public class Composite implements Calisan {
    private Memur tempMemur = new Memur();
    private Direktor tempDirektor = new Direktor();
    private Calisan[] birlesikArray = arrayBirlestir(tempMemur.memurSayisiniAl(),tempDirektor.direktorSayisiniAl()
            ,tempMemur.memurlariAl(),tempDirektor.direktorleriAl());
    private List<Calisan> calisanListesi = new CalisanList(birlesikArray);
    
    @Override
    public void calisanDetaylariniGoster() {
        
        Iterator<Calisan> iterator = calisanListesi.iterator(); 
        
          while(iterator.hasNext())  {  
            int toplamMaliyet = 0;
            Calisan calisan = iterator.next();
            if(calisan.pozisyonBak() == "D"){
                toplamMaliyet += calisan.maasaBak();
                for(int i = 0; i<birlesikArray.length;i++){
                    if(birlesikArray[i].baglantiBak() == calisan.ismeBak()){
                       toplamMaliyet += birlesikArray[i].maasaBak();
                       birlesikArray[i].calisanDetaylariniGoster();  
                    }
                }
                System.out.println("EKİBİN TOPLAM MALİYETİ = "+toplamMaliyet);
            }
            else if(calisan.pozisyonBak() == "M"){
                calisan.calisanDetaylariniGoster();
            }
        }  
    }

    @Override
    public int maasaBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz."); 
    }

    @Override
    public String ismeBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz."); 
    }

    @Override
    public String pozisyonBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz."); 
    }
    @Override
    public String baglantiBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz."); 
    }
    
    
    private Calisan[] arrayBirlestir(int memurSayisi, int direktorSayisi, Calisan[] memurArrayi, Calisan[] direktorArrayi){
        Calisan[] birlesikArray = new Calisan[memurSayisi + direktorSayisi];  //iki arrayin toplamı büyüklükte yeni bir array oluşturduk
        System.arraycopy(memurArrayi, 0, birlesikArray, 0, memurSayisi);  
        System.arraycopy(direktorArrayi, 0, birlesikArray, memurSayisi, direktorSayisi);  
        return birlesikArray;
    }
    
}
