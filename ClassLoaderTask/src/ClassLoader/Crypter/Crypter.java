package ClassLoader.Crypter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class Crypter {
    public static void crypt(String inputFilePath, String outputFilePath) {
        try {
            int current_byte = 0;
            byte[] raw_data = Files.readAllBytes(Paths.get(inputFilePath));
            byte[] crypted_data = new byte[raw_data.length];
            for (byte fbite : raw_data)
                crypted_data[current_byte++] = CryptLists.cryptList1.get(fbite+128);
            Files.write(Paths.get(outputFilePath), crypted_data, WRITE, CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(String inputFilePath, String outputFilePath){
        try{
            byte[] crypted_data = Files.readAllBytes(Paths.get(inputFilePath));
            byte[] raw_data = new byte[crypted_data.length];
            int current_byte = 0;
            for (byte fbite : crypted_data)
                raw_data[current_byte++] = (byte) ((byte) CryptLists.cryptList1.indexOf(fbite)- 128);
            Files.write(Paths.get(outputFilePath), raw_data, WRITE, CREATE);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
