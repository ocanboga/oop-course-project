/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class Composite implements Calisan { 
    /*
    Composite tipimiz Memur ve Direktor tipi gibi bir "leaf"(dal olarak bahsedeceğiz.). Bu dal Memur ve Direktor
    tipinin birleşik haline benzer olarak düşünülebilir. Tam olarak birleşik olmamasının sebebi aslında Memur,
    Direktor ve Composite olarak yazdığımız 3 dal Calisan'da birleşiyor (Esas aldığımız Composite Pattern'de olduğu gibi).
    Bu sınıf Memur ve Direktor tipindeki verileri alıp bunları -isminden de anlaşılabileceği gibi- birleştirip işlem
    görebilmesini sağlıyor. Memur ve Direktor tiplerini alırken bu tiplerin yapısını hiçbir şekilde bozmuyor ve bu
    tiplere karışmıyor. İşlemlerin nasıl yapıldığını aşağıdan inceleyebilirsiniz.
    */
    private Memur tempMemur = new Memur(); //memur ve -->
    private Direktor tempDirektor = new Direktor(); // <-- direktörden verileri çekebilmek için boş objeler oluşturup statik arrayleri çektik
    private Calisan[] birlesikArray = arrayBirlestir(tempMemur.memurSayisiniAl(),tempDirektor.direktorSayisiniAl()
            ,tempMemur.memurlariAl(),tempDirektor.direktorleriAl()); //direktör ve memurdan gelen arrayleri kendi metodumuz ile birleştirdik
    private List<Calisan> calisanListesi = new CalisanList(birlesikArray); //kendi oluşturduğumuz liste tipiyle (kendi iterotorumuzu içeren) -->
    // <-- işlem yapacağımız için arraylerimizi listeye atadık ve arraylerle işimizi bitirdik
    private String aranacakCalisan;

    
    public Composite(String aranacakCalisan){ //input ile aramak istersek arayacağımız çalışanımız burada
        this.aranacakCalisan = aranacakCalisan;
    }
    
    public Composite(){ //Eğer sadece composite yapısına erişmek istersek atamasız bir obje de oluşturabiliriz.
        
    }
    
    @Override
    public void calisanDetaylariniGoster() {
        
        Iterator<Calisan> iterator = calisanListesi.iterator(); //Kendi iterator sınıfımızdan iterator oluşturduk.
        
          while(iterator.hasNext())  { //daha önceden oluşturduğumuz kendi listemizi kendi iteratorımız ile dönüyoruz liste bitene kadar dolaşıyoruz.
            int toplamMaliyet = 0;    //Toplam maliyeti hesaplamak için atama
            Calisan calisan = iterator.currentItem(); //ilk kişiyi aldık
            
            if(aranacakCalisan.equals(calisan.ismeBak())){ //kullanıcının girdiği isim listede varsa işlem yapıyor
                
                if(calisan.pozisyonBak().equals("D")){ //eğer aranan kişi direktor ise direktor ve altındakileri sırasıyla hem yazdırıp hem de maaşlarını alıyoruz
                    toplamMaliyet += calisan.maasaBak(); //ilk kişinin maaşını al
                    System.out.println("");
                    calisan.calisanDetaylariniGoster();
                    toplamMaliyet += hepsininAltindakileriBul(calisan); //detaylar için metoda bakın
                    
                    System.out.println("");
                    System.out.println("**********************");
                    System.out.println("EKİBİN TOPLAM MALİYETİ = "+toplamMaliyet);
                    System.out.println("**********************");
                    System.out.println("");
                }
                else if(calisan.pozisyonBak().equals("M")){ //aranan kişi memur ise sadece onun bilgilerini gösterir.
                    toplamMaliyet+= calisan.maasaBak();
                    calisan.calisanDetaylariniGoster();
                    
                    System.out.println("");
                    System.out.println("**********************");
                    System.out.println("KİŞİNİN TOPLAM MALİYETİ = "+toplamMaliyet);
                    System.out.println("**********************");
                    System.out.println("");
                }
            }
            calisan = iterator.next(); //sonraki calisana geç
        }  
    }
    
    public void aranacakCalisanAyarla(String aranacakCalisan){
        this.aranacakCalisan = aranacakCalisan;
    }
    
    private Calisan[] arrayBirlestir(int memurSayisi, int direktorSayisi, Calisan[] memurArrayi, Calisan[] direktorArrayi){ //aldığımız memurları ve direktorleri tek bir arraye topluyoruz
        Calisan[] birlesikArray = new Calisan[memurSayisi + direktorSayisi];  //iki arrayin toplamı büyüklükte yeni bir array oluşturduk
        System.arraycopy(memurArrayi, 0, birlesikArray, 0, memurSayisi);  //array kopyalama işlemleri
        System.arraycopy(direktorArrayi, 0, birlesikArray, memurSayisi, direktorSayisi);  
        return birlesikArray;
    }
    
    private int hepsininAltindakileriBul(Calisan calisan){ //ilk kişi döndükten sonra onun altındaki (hemen altında bulunan) kişileri döndürür
        int toplamMaliyet = 0;
        for(int i = 0; i<birlesikArray.length;i++){
            if(calisan.ismeBak().contains(birlesikArray[i].baglantiBak())){
                toplamMaliyet += birlesikArray[i].maasaBak();
                System.out.println("");
                birlesikArray[i].calisanDetaylariniGoster();  
                toplamMaliyet+=altindakileriBul(i); //daha alt katmandakileri bulmaya geçiyoruz
                            
               }                                                        
            }
        return toplamMaliyet;
    }
    
    private int altindakileriBul(int index){ //bu metod altında birileri çalışabilen kişiler için altındaki çalışanları bulur. Çalışan kalmayıncaya kadar recursive bir şekilde çalışır.
        int toplamMaliyet = 0;
        for(int j = 0; j<birlesikArray.length;j++){
            if(birlesikArray[index].ismeBak().contains(birlesikArray[j].baglantiBak())){
                toplamMaliyet += birlesikArray[j].maasaBak();
                System.out.println("");
                birlesikArray[j].calisanDetaylariniGoster();
                toplamMaliyet+=altindakileriBul(j); //revursive
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
