package SergioCosano.ProyectoFinal.Utils;

import SergioCosano.ProyectoFinal.App;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Utils {
    public static String encryptSHA256 (String s){
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA256");
            md.update(s.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : md.digest()) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {

        }
        return result;
    }

    public static void addCssAndIcon(Stage scene, String css_file){
        if(css_file.equals("Login") || css_file.equals("primary")){
            if(css_file.equals("Login")) {
                scene.getScene().getStylesheets().add(String.valueOf(App.class.getResource("/SergioCosano/css/login.css")));
            }else{
                scene.getScene().getStylesheets().add(String.valueOf(App.class.getResource("/SergioCosano/css/mainpage.css")));
            }
        }
        scene.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("icon.png"))));
    }
}
