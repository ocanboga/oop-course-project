
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 05190000072_05190000764
 */
 public class TXTReader implements FileReader {
    static {
        Registry.register( "xml", new XMLReader() );
    }

    @Override
     public BufferedReader readFile() {
         try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("girdi.txt"),StandardCharsets.UTF_8));
            return br;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TXTReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
     }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Bu tipi desteklemek için gerekli verileri girin."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


 }
