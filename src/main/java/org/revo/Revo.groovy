package org.revo

import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage
import org.revo.Repository.AdminRepository
import org.revo.Repository.PersonRepository
import org.revo.Service.MainService
import org.revo.controller.RevoLoginController
import org.revo.controller.RevoProfileController
import org.revo.controller.RevoRegisterController
import org.revo.domain.Admin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by revo on 13/11/15.
 */
@SpringBootApplication
class Revo extends AbstractJavaFxApplicationSupport {
    @Autowired
    AdminRepository adminRepository
    @Autowired
    PersonRepository personRepository
    @Autowired
    MainService mainService
    Admin admin
    Stage stage
    private final String LightTheme = "/revo/css/JMetroDarkTheme.css"
    private final String DarkTheme = "/revo/css/JMetroLightTheme.css"
    private final String Main = "/revo/css/main.css"


    public static void main(String[] args) {
        launchApp(Revo.class, args)
    }

    @Override
    void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage
        stage.title = "Revo Hello Worled"
        stage.maximized = true
        stage.resizable = false
        showLoginPage()
        primaryStage.show()

    }

    void showLoginPage() {
        admin = null
        RevoLoginController ctrl = setContent("/revo/fxml/login.fxml")
        ctrl.init(this)
    }

    void showProfilePage() {
        RevoProfileController ctrl = setContent("/revo/fxml/profile.fxml")
        ctrl.init(this)
    }

    void showRegisterPage() {
        RevoRegisterController ctrl = setContent("/revo/fxml/register.fxml")
        ctrl.init(this)
    }

    Initializable setContent(String s) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(s))
        Pane page = loader.load()
        Scene scene = new Scene(page, stage.width, stage.height - 30)
        stage.scene = scene
        scene.stylesheets.add(LightTheme)
        scene.stylesheets.add(Main)
        loader.controller
    }
}
