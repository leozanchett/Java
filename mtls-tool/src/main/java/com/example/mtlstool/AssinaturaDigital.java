package com.example.mtlstool;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AssinaturaDigital {


    public String gerarAssinatura(String mensagem) throws Exception {
        Signature sig = Signature.getInstance("SHA256withECDSA");

        // Carregando o conteúdo do arquivo de chave privada
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("chave_privada_assinatura.pem");
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String chavePrivadaString = scanner.hasNext() ? scanner.next() : "";
        scanner.close();

        // Convertendo a string em uma instância de chave privada
        chavePrivadaString = chavePrivadaString.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] chavePrivadaBytes = Base64.getDecoder().decode(chavePrivadaString);
        PKCS8EncodedKeySpec chavePrivadaSpec = new PKCS8EncodedKeySpec(chavePrivadaBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey priKey = keyFactory.generatePrivate(chavePrivadaSpec);

        // Inicializando Obj Signature com a Chave Privada
        sig.initSign(priKey);

        // Gerar assinatura
        sig.update(mensagem.getBytes());
        byte[] assinatura = sig.sign();
        return Base64.getEncoder().encodeToString(assinatura);
    }

}
