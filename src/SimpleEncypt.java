import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimpleEncypt {

public static String EncryptString(String planeString){

    String unencrypt = planeString;
    String encryptString = null;

    try{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(unencrypt.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<bytes.length;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        encryptString = sb.toString();

        System.out.println(encryptString);

    }
    catch (NoSuchAlgorithmException e)
    {
        e.printStackTrace();
    }
    return encryptString;
}

}
