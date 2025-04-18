package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.AESUtil;
import model.RSAUtil;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class EncryptableController {
    @FXML
    RadioButton AES;
    @FXML
    RadioButton RSA;
    @FXML
    TextField input;
    @FXML
    TextField output;
    @FXML
    TextField output2;

    KeyPair keyPair;

    {
        try {
            keyPair = RSAUtil.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();
    public void change(ActionEvent e) throws Exception {
        if (AES.isSelected()) {
            String xaucanmahoa = input.getText();
            AESUtil aesUtil = new AESUtil();
            try {
                String xaudamahoa = aesUtil.encrypt(xaucanmahoa);
                output.setText(xaudamahoa);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (RSA.isSelected()) {
            String xaucanmahoa=input.getText();


            RSAUtil rsaUtil=new RSAUtil(publicKey,privateKey);
            try {
                String xaudamahoa= rsaUtil.encrypt(xaucanmahoa);
                output.setText(xaudamahoa);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        } else {
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Vui lòng chọn thuật toán mã hoá");
            alert1.show();


        }

    }
    public void chooseAES(ActionEvent e)
    {
        reset();
    }
    public void chooseRSA(ActionEvent e)
    {
        reset();
    }
    public void reset()
    {
        input.setText(null);
        output.setText(null);
        output2.setText(null);
    }
    public void decrypt(ActionEvent e) throws Exception {
        if (AES.isSelected()) {
           String xaudamahoa=output.getText();
           AESUtil aesUtil=new AESUtil();
            try {
                String xaudagiaimahoa = aesUtil.decrypt(xaudamahoa);
                output2.setText(xaudagiaimahoa);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (RSA.isSelected()) {
            String xaudamahoa=output.getText();

            RSAUtil rsaUtil=new RSAUtil(publicKey,privateKey);
            try {
                String xaudagiaima= rsaUtil.decrypt(xaudamahoa);
                output2.setText(xaudagiaima);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        } else {
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Vui lòng chọn thuật toán mã hoá");
            alert1.show();


        }

    }

}
