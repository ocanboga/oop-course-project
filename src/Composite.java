/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class Composite implements Calisan {
    private Memur tempMemur = new Memur();
    private Direktor tempDirektor = new Direktor();
    private Calisan[] birlesikArray = arrayBirlestir(tempMemur.memurSayisiniAl(),tempDirektor.direktorSayisiniAl()
            ,tempMemur.memurlariAl(),tempDirektor.direktorleriAl());
    private List<Calisan> calisanListesi = new CalisanList(birlesikArray);
    private String aranacakCalisan;

    
    public Composite(String aranacakCalisan){
        this.aranacakCalisan = aranacakCalisan;
    }
    
    @Override
    public void calisanDetaylariniGoster() {
        
        Iterator<Calisan> iterator = calisanListesi.iterator(); 
        
          while(iterator.hasNext())  { 
            int toplamMaliyet = 0;
            Calisan calisan = iterator.currentItem();
            if(aranacakCalisan.equals(calisan.ismeBak())){
                if(calisan.pozisyonBak().equals("D")){
                    toplamMaliyet += calisan.maasaBak();
                    calisan.calisanDetaylariniGoster();
                    for(int i = 0; i<birlesikArray.length;i++){
                        if(calisan.ismeBak().contains(birlesikArray[i].baglantiBak())){
                           toplamMaliyet += birlesikArray[i].maasaBak();
                           birlesikArray[i].calisanDetaylariniGoster();  
                        }
                    }
                    System.out.println("EKİBİN TOPLAM MALİYETİ = "+toplamMaliyet);
                }
                else if(calisan.pozisyonBak().equals("M")){
                    System.out.println("İsim ="+calisan.ismeBak());  
                    System.out.println("Maaş ="+calisan.maasaBak()); 
                }
            }
            calisan = iterator.next();
        }  
    }
    
    @Override
    public int maasaBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz.");     }

    @Override
    public String ismeBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz.");     }
    @Override
    public String pozisyonBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz.");     }

    @Override
    public String baglantiBak() {
        throw new UnsupportedOperationException("Bu sınıfla bu fonksiyon kullanılamaz.");     }
    
    private Calisan[] arrayBirlestir(int memurSayisi, int direktorSayisi, Calisan[] memurArrayi, Calisan[] direktorArrayi){
        Calisan[] birlesikArray = new Calisan[memurSayisi + direktorSayisi];  //iki arrayin toplamı büyüklükte yeni bir array oluşturduk
        System.arraycopy(memurArrayi, 0, birlesikArray, 0, memurSayisi);  
        System.arraycopy(direktorArrayi, 0, birlesikArray, memurSayisi, direktorSayisi);  
        return birlesikArray;
    }

    
}
