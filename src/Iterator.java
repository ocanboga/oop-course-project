/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public interface Iterator<E> 
{
    void reset();   // ilk varlığı sıfırla
 
    E next();   // sonraki varlığa eriş
 
    E currentItem();    // şimdiki varlığı al
 
    boolean hasNext();  // sonraki varlık var mı yok mu kontrol et
}
