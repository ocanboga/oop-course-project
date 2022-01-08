/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class CalisanIterator implements Iterator<Calisan> { //Kendi "List" tipimizde gerekli verilerin kontrolünü
                                                            //sağlayabilmek için kendi iteratorımızı oluşturduk.
     
    private Calisan[] calisanlar; //döndüreceğimiz arrayi ve pozisyon değerini oluşturduk
    private int pozisyon;
     
    public CalisanIterator(Calisan[] calisanlar) //constructor
    {
        this.calisanlar = calisanlar;
        pozisyon = 0;
    }
 
    @Override
    public void reset() { //pozisyonu sıfırla
        pozisyon = 0;
    }
 
    @Override
    public Calisan next() {  //pozisyonu arttırıp sonrakine geç
        return calisanlar[pozisyon++];
    }
 
    @Override
    public Calisan currentItem() { //şimdiki varlığı döndür
        return calisanlar[pozisyon];
    }
 
    @Override
    public boolean hasNext() { //sonraki var mı kontrol et yoksa false varsa true döndür
        if(pozisyon >= calisanlar.length)
            return false;
        return true;
    }
}
