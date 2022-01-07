
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 90545
 */
public class Registry {
    static Map<String,FileReader> reg = new HashMap<String,FileReader>();

    public static void register(String ext, FileReader fr ) {
        reg.put( ext, fr );
    }
}
