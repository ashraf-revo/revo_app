package org.revo.controller

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TextField
import org.revo.Revo
import org.revo.Util.App
import org.revo.domain.Admin

/**
 * Created by revo on 13/11/15.
 */
class RevoRegisterController extends App implements Initializable {

    @FXML
    TextField name
    @FXML
    TextField password

    @Override
    void initialize(URL location, ResourceBundle resources) {
    }

    void init(Revo revo) {
        this.adminRepository = revo.adminRepository
        this.personRepository = revo.personRepository
        this.revo = revo
        this.mainService = revo.mainService
    }

    public void register(ActionEvent actionEvent) {
        adminRepository.save(new Admin(name: name.text, password: password.text, role: adminRepository.count() == 0 ? 0 : 1))
        revo.showLoginPage()
    }

    public void back(ActionEvent actionEvent) {
        revo.showLoginPage()
    }
}
