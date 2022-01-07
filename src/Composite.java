/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class Composite implements Calisan {
    private Memur tempMemur = new Memur(); //memur ve 
    private Direktor tempDirektor = new Direktor(); // direktörden verileri çekebilmek için boş objeler oluşturup statik arrayleri çektik
    private Calisan[] birlesikArray = arrayBirlestir(tempMemur.memurSayisiniAl(),tempDirektor.direktorSayisiniAl()
            ,tempMemur.memurlariAl(),tempDirektor.direktorleriAl()); //direktör ve memurdan gelen arrayleri kendi metodumuz ile birleştirdik
    private List<Calisan> calisanListesi = new CalisanList(birlesikArray); //kendi oluşturduğumuz liste tipiyle (kendi iterotorumuzu içeren) -->
    // --> işlem yapacağımız için arraylerimizi listeye atadık ve arraylerle işimizi bitirdik
    private String aranacakCalisan;

    
    public Composite(String aranacakCalisan){ //input ile aramak istersek arayacağımız çalışanımız burada
        this.aranacakCalisan = aranacakCalisan;
    }
    
    public Composite(){
        
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
                    System.out.println("");
                    calisan.calisanDetaylariniGoster();
                    toplamMaliyet += hepsininAltindakileriBul(calisan);
                    
                    System.out.println("");
                    System.out.println("**********************");
                    System.out.println("EKİBİN TOPLAM MALİYETİ = "+toplamMaliyet);
                    System.out.println("**********************");
                    System.out.println("");
                }
                else if(calisan.pozisyonBak().equals("M")){
                    toplamMaliyet+= calisan.maasaBak();
                    calisan.calisanDetaylariniGoster();
                    
                    System.out.println("");
                    System.out.println("**********************");
                    System.out.println("KİŞİNİN TOPLAM MALİYETİ = "+toplamMaliyet);
                    System.out.println("**********************");
                    System.out.println("");
                }
            }
            calisan = iterator.next();
        }  
    }
    
    public void aranacakCalisanAyarla(String aranacakCalisan){
        this.aranacakCalisan = aranacakCalisan;
    }
    
    private Calisan[] arrayBirlestir(int memurSayisi, int direktorSayisi, Calisan[] memurArrayi, Calisan[] direktorArrayi){
        Calisan[] birlesikArray = new Calisan[memurSayisi + direktorSayisi];  //iki arrayin toplamı büyüklükte yeni bir array oluşturduk
        System.arraycopy(memurArrayi, 0, birlesikArray, 0, memurSayisi);  
        System.arraycopy(direktorArrayi, 0, birlesikArray, memurSayisi, direktorSayisi);  
        return birlesikArray;
    }
    
    private int hepsininAltindakileriBul(Calisan calisan){
        int toplamMaliyet = 0;
        for(int i = 0; i<birlesikArray.length;i++){
            if(calisan.ismeBak().contains(birlesikArray[i].baglantiBak())){
                toplamMaliyet += birlesikArray[i].maasaBak();
                System.out.println("");
                birlesikArray[i].calisanDetaylariniGoster();  
                toplamMaliyet+=altindakileriBul(i);
                            
               }                                                        
            }
        return toplamMaliyet;
    }
    
    private int altindakileriBul(int index){
        int toplamMaliyet = 0;
        for(int j = 0; j<birlesikArray.length;j++){
            if(birlesikArray[index].ismeBak().contains(birlesikArray[j].baglantiBak())){
                toplamMaliyet += birlesikArray[j].maasaBak();
                System.out.println("");
                birlesikArray[j].calisanDetaylariniGoster();
                toplamMaliyet+=altindakileriBul(j);
        }
        
    }
        return toplamMaliyet;
    }
    
    
    //İnterface yapısında hata almamak için gerekli exceptionlar alttadır.
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

    
}
