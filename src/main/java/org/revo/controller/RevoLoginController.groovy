package org.revo.controller

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import org.controlsfx.control.Notifications
import org.revo.Revo
import org.revo.Util.App
import org.springframework.stereotype.Component

/**
 * Created by revo on 13/11/15.
 */
@Component
class RevoLoginController extends App implements Initializable {
    @FXML
    TextField name
    @FXML
    PasswordField password

    void init(Revo revo) {
        this.adminRepository = revo.adminRepository
        this.revo = revo
        this.mainService = revo.mainService
        this.personRepository = revo.personRepository
    }

    @Override
    void initialize(URL location, ResourceBundle resources) {
    }


    void gotoLogin(ActionEvent event) {
        if (mainService.CheckLogin(name.text, password.text)) {
            revo.showProfilePage()
            revo.admin = adminRepository.findByNameAndPassword(name.text, password.text).get()
        } else Notifications.create().title("Login Message").darkStyle().text("Make Sure Name and Password Are Correct !").showInformation()
    }

    void gotoRegister(ActionEvent event) {
        revo.showRegisterPage()
    }
}
