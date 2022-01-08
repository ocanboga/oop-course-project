
import java.io.BufferedReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
/*
Database tipi olan ".xml" tipi okunmak isterse registerı kullanarak bu dosya okunduğunda veya yazıldığında
ne yapılacığını bu sınıf belirler. Başka tiplerde kullanmak için aynı sınıf yapısı kullanılabilir.
Dosya okunması için oluşturduğumuz FileReader interfacini kullanıyoruz
*/
 public class XMLReader implements FileReader {
    static {
        Registry.register( "xml", new XMLReader() );
    }

    @Override
    public BufferedReader readFile() {
        throw new UnsupportedOperationException("Bu tipi desteklemek için gerekli verileri girin."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Bu tipi desteklemek için gerekli verileri girin."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


 }
