package com.example.mtlstool;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloViewController {

    @FXML
    private TextField accessId;

    @FXML
    private TextField accessTime;

    @FXML
    private TextField accessOrigin;

    @FXML
    private TextField accessUri;

    @FXML
    private TextField accessSignature;

    @FXML
    private TextArea payload;

    @FXML
    private Button generateMtls;

    @FXML
    private TextField xAilosCertificate;

    @FXML
    private TextField accessData;

    @FXML
    private ComboBox<String> ambientes;

    private Ambiente ambiente;

    @FXML
    protected void onGenerateMtls() throws Exception {
        System.out.println(ambientes.getValue());
        ScreenActions screenActions = new ScreenActions(ambiente);
        accessId.setText(screenActions.generateUUID());
        accessTime.setText(screenActions.generateTimestampSinceEpoch());
        screenActions.encryptCertificate(xAilosCertificate, accessData);
        accessSignature.setText(screenActions.digitalAsign(mountAssignatureMessage()));
    }

    @FXML
    protected void verifyPayload(){
        if (!payload.getText().trim().isEmpty() && ambiente != null) {
            generateMtls.setDisable(false);
            generateMtls.setText("Generate \"MTLS\" Request");
        }else {
            generateMtls.setDisable(true);
            generateMtls.setText("Fill the payload");
        }
    }

    private String mountAssignatureMessage() {
        String message = "";
        message += accessId.getText() + ":";
        message += accessTime.getText() + ":";
        message += accessOrigin.getText() + ":";
        message += accessUri.getText() + ":";
        message += payload.getText().replaceAll("\\s", "") + ":";
        message += xAilosCertificate.getText() + accessData.getText();
        return message;
    }

    public void carregarAmbientes() {
        if (ambientes.getItems().size() > 0) {
            ambientes.getItems().clear();
        }
        for (Ambiente ambiente : Ambiente.values()) {
            ambientes.getItems().add(ambiente.toString());
        }
        ambientes.getSelectionModel().selectFirst();
        ambiente = Ambiente.valueOf(ambientes.getValue());
        verifyPayload();

    }
}