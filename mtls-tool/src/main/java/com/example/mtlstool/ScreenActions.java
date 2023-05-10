package com.example.mtlstool;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Scanner;
import java.util.UUID;

public class ScreenActions {

    private Ambiente ambiente;
    public ScreenActions(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    public String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public String generateTimestampSinceEpoch() {
        long epoch = System.currentTimeMillis();
        return String.valueOf(epoch);
    }

    public String digitalAsign(String mensagem) throws Exception {
        AssinaturaDigital assinaturaDigital = new AssinaturaDigital();
        return assinaturaDigital.gerarAssinatura(mensagem);
    }

    public void encryptCertificate(TextField xAilosCertificate, TextField accessData) throws GeneralSecurityException, IOException {
        // 1. Gerar um UUID
        final String randomUUID = generateUUID();
        final String base64 = Base64.getEncoder().encodeToString(randomUUID.getBytes());
        final String base64FirstPart = base64.substring(0, 15);

        // 2. Acessar o ceritificado criptografado
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String certificadoCriptografado = "";
        switch (this.ambiente){
            case HOMOL:
                certificadoCriptografado = "certificado_prod_criptografado.txt";
                break;
            case PROD:
                certificadoCriptografado = "certificado_qa_criptografado.txt";
                break;
            case TEST:
                certificadoCriptografado = "certificado_test_criptografado.txt";
                break;
        }
        InputStream inputStream = classLoader.getResourceAsStream(certificadoCriptografado);
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
        String conteudo = scanner.useDelimiter("\\A").next();
        scanner.close();

        // 3. Concatenar 15 primeiros caracteres do UUID com o conteúdo do certificado
        String ailosCertificate = base64FirstPart + conteudo;

        // 4. Encriptar em RSA
        RSA rsa = new RSA(this.ambiente);
        String certificateRSAEncrypted = rsa.encrypt(ailosCertificate);
        String part1 = certificateRSAEncrypted.substring(0, certificateRSAEncrypted.length() / 2);
        String part2 = certificateRSAEncrypted.substring(certificateRSAEncrypted.length() / 2);
        xAilosCertificate.setText(part1);
        accessData.setText(part2);
    }

}
