/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public class CalisanList implements List<Calisan> //Kendi iteratorımız ile dönebileceğimiz bir liste türü oluşturduk
                                                //bu liste türü Calisan tipinde bir array alıp bunları listeye attıktan
                                                //sonra üzerinde iterator ile işlem yapılmasını sağlıyor.
{
    private Calisan[] calisanlar; //calisanlar arrayi oluşturduk
     
    public CalisanList(Calisan[] calisanlar) //constructor
    {
        this.calisanlar = calisanlar;
    }
     
    @Override
    public Iterator<Calisan> iterator() { //interface'den iteratoru alıp yeni bir iterator oluşturduk
        return new CalisanIterator(calisanlar);
    }
}