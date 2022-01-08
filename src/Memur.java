/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class Memur implements Calisan { //Calisan interface'ni alan direktor tipinde bir calisan olusturduk
    private String adSoyad; //direktor tipindeki calisanın gerekli bilgilerini almak icin atamaları yaptık
    private int maas; 
    private String pozisyon;
    private String baglanti;
    public static Calisan[] memurArr = new Calisan[0];//daha rahat işleyebilmek için kullanıcının atadığı her direktoru bir arraye alıyoruz
    private static int memurSayac = 0; //gerekirse kaç direktor girdisi yapıldığını görebilmek için sayaç
    
    //Çıktıları renkendirmek istedik. Bunlar için kodlar:
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    public Memur(String isim, int maas, String pozisyon,String baglanti){ //constructor
        this.adSoyad = isim;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.baglanti = baglanti;
        Memur tempCalisan = new Memur(isim,maas,pozisyon,baglanti,1); //kullanıcının oluşturduğunun kopyası olan bir çalışan oluşturup bunu arrayimize ekliyoruz
        arrayeEkle(tempCalisan);
    }
    
    public Memur(String isim, int maas, String pozisyon,String baglanti,int temp){ //constructor temp obje oluşturmak için
        this.adSoyad = isim;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.baglanti = baglanti;
    }
    
    public Memur(){
        
    }
    
    @Override
    public void calisanDetaylariniGoster() //cikti icin print
    {
        System.out.println("İsim = "+ismeBak()+ANSI_RESET);  
        System.out.println("Maaş = "+maasaBak()+ANSI_RESET);
        System.out.println("Pozisyon = "+pozisyonBak()+ANSI_RESET);
        System.out.println("Bağlı olduğu kişi = "+baglantiBak()+ANSI_RESET);
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
    
    public Calisan[] memurlariAl(){
        return memurArr;
    }
    
    //kullanıcının oluşturduğu direktorleri daha sonra kullanmak üzere array'e ekliyoruz.
    private void arrayeEkle(Calisan calisan){
        this.memurArr = arrayBoyutuArttır(this.memurArr);
        this.memurArr[memurSayac] = calisan;
        this.memurSayac +=1;
    }
    
    public int memurSayisiniAl(){
        return memurSayac;
    }
    //Java'da array önceden boyutu tanımlı olduğu için bellekte çok fazla yer tutmamak adına ve arrayi 
    //dinamik kılmak adına burada arrayimize 
    //her çalışan eklendiğinde arrayimizin boyutunu arttırıyoruz (başta 0 boyutunda array ile başladık).
    private static Calisan[] arrayBoyutuArttır(Calisan[] array){
        Calisan[] yeniArray = new Calisan[array.length + 1];//ekeleyeğimiz her element için arrayin büyüklüğünü 1 arttırdık
        for(int i = 0; i < array.length; i++)
        {
            yeniArray[i] = array[i];//eski elemanları yeni arraye kopyaladık
        }
        return yeniArray;
    }
}
