
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
Excel tipi olan ".xls" tipi okunmak isterse registerı kullanarak bu dosya okunduğunda veya yazıldığında
ne yapılacığını bu sınıf belirler. Başka tiplerde kullanmak için aynı sınıf yapısı kullanılabilir.
Dosya okunması için oluşturduğumuz FileReader interfacini kullanıyoruz
*/
public class ExcelReader implements FileReader {
    static {
        Registry.register( "xls", new ExcelReader() );
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