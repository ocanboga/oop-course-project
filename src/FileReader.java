
import java.io.BufferedReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
public interface FileReader { //BufferedReader ile dosya okuyacağımız için interface'miz bunu register ile kullanacağız
                               //Bu şekilde Strategy Pattern'i kullanıp istediğimiz tipte dosyaları okuyabiliriz.

  BufferedReader readFile();
   void writeFile();
}
