package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.HashExample;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class loginController {
@FXML
    private TextField userField;
@FXML
    private  TextField passwordField;
private final String storedUser="thanhtanle";
private final String storedHashedPassword;

    {
        try {
            storedHashedPassword = HashExample.hash("tan123");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginhandle(ActionEvent event)
{
    try {
        if(userField.getText().equals(storedUser)&&HashExample.hash(passwordField.getText()).equals(storedHashedPassword))
        {

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Chúc mừng bạn đã đăng nhập thành công");
            alert.show();
        }
        else {
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Sai tài khoản hoặc mật khẩu");
            alert1.show();
        }
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}

}
