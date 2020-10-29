package StreamTask.Cryptor;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class XorCryptor {
    public static String xor_encrypt(String message, String key) {
        try {
            if (message == null || key == null) return null;
            char[] newmsg = new char[message.length()];
            for (int i = 0; i < message.length(); i++)
                newmsg[i] = (char) (message.charAt(i) ^ key.charAt(i %  key.length()));
            return new BASE64Encoder().encodeBuffer(new String(newmsg).getBytes());
        } catch (Exception e) {
            return null;
        }
    }


    public static String xor_decrypt(String message, String key){
        try {
            if (message==null || key==null ) return null;
            BASE64Decoder decoder = new BASE64Decoder();
            message = new String(decoder.decodeBuffer(message));
            char[] newmsg=new char[message.length()];
            for (int i=0; i<message.length(); i++){
                newmsg[i]=(char)(message.charAt(i)^key.charAt(i%key.length()));
            }
            return new String(newmsg);
        }
        catch (Exception e ) {
            return null;
        }
    }
}
