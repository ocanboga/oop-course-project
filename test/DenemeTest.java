/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tugcan
 */
public class DenemeTest {
    
    public DenemeTest() {
    }
    
    @Test
public void shouldTakeUserInput() { //Burada main methodta aldığımız kullanıcı girdisini JUnit ile test ettik.
    Deneme inputOutput= new Deneme();

        String input = "Mehmet Turksever";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    assertEquals("Mehmet Turksever", inputOutput.kullanicidanGirdiAl());
}
    
}
