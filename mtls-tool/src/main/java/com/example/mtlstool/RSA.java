package com.example.mtlstool;

import com.diebold.servcore.encryption.rsa.RSAUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.Cipher;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


public class RSA {

    private static final int MAX_BLOCK_SIZE = 200;
    private Ambiente ambiente;
    public RSA(Ambiente ambiente) {
        Security.addProvider(new BouncyCastleProvider());
        this.ambiente = ambiente;
    }

    public String encrypt(String xAilosCertificate) throws GeneralSecurityException, IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String rsa_file = "";
        switch (this.ambiente){
            case HOMOL,TEST:
                rsa_file = "RSA_TEST.txt";
                break;
            case PROD:
                rsa_file = "RSA_QA.txt";
                break;
        }
        String  pathRSA = classLoader.getResource(rsa_file).getPath();
        PublicKey publicKey = (PublicKey) loadKey(pathRSA, X509EncodedKeySpec.class, "RSA", "PUBLIC");

        String certificadoCriptografado = realizarEncrypt(publicKey, xAilosCertificate);
        return certificadoCriptografado;
    }

    private String realizarEncrypt(PublicKey publicKey, String texto) throws GeneralSecurityException, IOException {
        long t = System.nanoTime();
        System.out.println("Inicio da criptografia: " + (System.nanoTime() - t) / 1000000.0f);
        t = System.nanoTime();

        byte[] messageBytes = texto.getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        List<byte[]> cipherTexts = new ArrayList<>();
        for (int i = 0; i < messageBytes.length; i += MAX_BLOCK_SIZE) {
            byte[] block = Arrays.copyOfRange(messageBytes, i, i + MAX_BLOCK_SIZE);
            byte[] cipherText = cipher.doFinal(block);
            cipherTexts.add(cipherText);
        }
        byte[] encryptedBytes = concatByteArrays(cipherTexts);
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Valor criptografado: " + encryptedMessage);
        System.out.println("Fim da criptografia: " + (System.nanoTime() - t) / 1000000.0f);
        return encryptedMessage;
    }

    private static byte[] concatByteArrays(List<byte[]> arrays) {
        int totalLength = arrays.stream().mapToInt(a -> a.length).sum();
        byte[] result = new byte[totalLength];
        int destPos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, destPos, array.length);
            destPos += array.length;
        }
        return result;
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


}