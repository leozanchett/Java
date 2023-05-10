import com.diebold.servcore.encryption.rsa.RSAUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.FileReader;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Main {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        String texto = "confia!";
        String publicKeyFile = "C:\\log\\servcore-public.pem";
        String privateKeyFile = "C:\\log\\servcore-private.pem";
        PublicKey publicKey = (PublicKey) loadKey(publicKeyFile, X509EncodedKeySpec.class, "RSA", "PUBLIC");
        PrivateKey privateKey = (PrivateKey) loadKey(privateKeyFile, PKCS8EncodedKeySpec.class, "RSA", "PRIVATE");
        String textoCriptado = realizarEncrypt(privateKey, texto);
        realizarDecrypt(publicKey, textoCriptado);
    }

    private static <T extends KeySpec> Key loadKey(String keyFile, Class<T> keySpecClass, String algorithm, String type) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        PemReader reader = new PemReader(new FileReader(keyFile));
        PemObject pemObject = reader.readPemObject();
        byte[] keyBytes = pemObject.getContent();
        reader.close();

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        T keySpec = keySpecClass.cast(keyFactory.getKeySpec(
                type.equals("PUBLIC") ? keyFactory.generatePublic(new X509EncodedKeySpec(keyBytes)) : keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes)),
                keySpecClass
        ));
        return type.equals("PUBLIC") ? keyFactory.generatePublic(keySpec) : keyFactory.generatePrivate(keySpec);
    }

    private static String realizarEncrypt(PrivateKey privateKey, String texto) throws GeneralSecurityException, IOException {
        long t = System.nanoTime();
        System.out.println("Inicio da criptografia: " + (System.nanoTime() - t) / 1000000.0f);

        t = System.nanoTime();
        String parametroCriptado = RSAUtils.encrypt(privateKey, texto);
        System.out.println("Valor criptografado: " + parametroCriptado);
        System.out.println("Fim da criptografia: " + (System.nanoTime() - t) / 1000000.0f);
        return parametroCriptado;
    }

    private static void realizarDecrypt(PublicKey publicKey, String parametroCriptado) throws GeneralSecurityException, IOException {
        long t = System.nanoTime();
        System.out.println("Inicio da descriptografia: " + (System.nanoTime() - t) / 1000000.0f);

        t = System.nanoTime();
        String parametroDescriptografado = RSAUtils.decrypt(publicKey, parametroCriptado);
        System.out.println("Valor descriptografado: " + parametroDescriptografado);
        System.out.println("Fim da descriptografia: " + (System.nanoTime() - t) / 1000000.0f);
    }
}
