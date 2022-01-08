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
    public static Calisan[] direktorArr = new Calisan[0]; //daha rahat işleyebilmek için kullanıcının atadığı her direktoru bir arraye alıyoruz
    private static int direktorSayac = 0; //gerekirse kaç direktor girdisi yapıldığını görebilmek için sayaç
    
    //Yazıları renkendirmek istedik. Bunlar için kodlar:
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    public Direktor(String isim, int maas, String pozisyon, String baglanti){ //constructor
        this.adSoyad = isim;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.baglanti = baglanti;
        Direktor tempCalisan = new Direktor(isim,maas,pozisyon,baglanti,1); //kullanıcının oluşturduğunun kopyası olan bir çalışan oluşturup bunu arrayimize ekliyoruz
        arrayeEkle(tempCalisan);
    }
    
    public Direktor(String isim, int maas, String pozisyon,String baglanti,int temp){ //constructor temp obje oluşturmak için bir yapı
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
        System.out.println(ANSI_BLUE+"İsim = "+ismeBak()+ANSI_RESET);  
        System.out.println(ANSI_BLUE+"Maaş = "+maasaBak()+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Pozisyon = "+pozisyonBak()+ANSI_RESET);
        if(baglantiBak().equals("Root")){ //rootsa kimseye bağlı olmadığını belirttik
            System.out.println(ANSI_BLUE+"Bağlı olduğu kişi = "+"Bağlı olduğu bir kişi yok bu kişi en üst rütbeli birisidir."+ANSI_RESET);
        }
        else{
            System.out.println(ANSI_BLUE+"Bağlı olduğu kişi = "+baglantiBak()+ANSI_RESET);
        }
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
    //kullanıcının oluşturduğu direktorleri daha sonra kullanmak üzere array'e ekliyoruz.
    private void arrayeEkle(Calisan calisan){ 
        this.direktorArr = arrayBoyutuArttır(this.direktorArr);
        this.direktorArr[direktorSayac] = calisan;
        this.direktorSayac +=1;
    }
    
    public int direktorSayisiniAl(){
        return direktorSayac;
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
