import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class main {

    public static void main(String[] args) throws IOException {
        String alg = "AES/CBC/PKCS5Padding";
        String aesKey = "abcdefghabcdefghabcdefghabcdefgh"; //32byte
        String aesIv = "0123456789abcdef"; //16byte

        String source = "E:\\Kumoh\\2021\\2학기\\컴퓨터보안\\과제\\4-1 대칭키암호-과제.txt";
        String text = new String(Files.readAllBytes(Paths.get(source)));
        System.out.println("원본 : " + text);

        String encText = "";

        try {

            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(aesIv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            //암호화 실행
            byte[] encrypted1 = cipher.doFinal(text.getBytes("UTF-8")); // 암호화(인코딩 설정)
            encText = Base64.getEncoder().encodeToString(encrypted1); // 암호화 인코딩 후 저장

            System.out.println("암호화 : " + encText);

        } catch (Exception e) {
            System.out.println("암호화 중 오류 발생 ");
            e.printStackTrace();
        }

        try {
            Cipher cipher = Cipher.getInstance(alg);

            SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(aesIv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            //암호 해석
            byte[] decodedBytes = Base64.getDecoder().decode(encText);
            byte[] decrypted = cipher.doFinal(decodedBytes);
            String result = new String(decrypted);

            System.out.println("복호화 : " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}