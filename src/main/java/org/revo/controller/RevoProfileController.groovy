package org.revo.controller

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import org.controlsfx.control.Notifications
import org.revo.Revo
import org.revo.Util.App
import org.revo.domain.Person
import org.springframework.stereotype.Component

/**
 * Created by revo on 13/11/15.
 */
@Component
class RevoProfileController extends App implements Initializable {
    @FXML
    TableColumn<Person, String> id
    @FXML
    TableColumn<Person, String> name
    @FXML
    TableColumn<Person, String> phone
    @FXML
    TableColumn<Person, Date> date

    @FXML
    TableView<Person> data

    @Override
    void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory { it.value.idProperty }
        name.setCellValueFactory { it.value.nameProperty }
        phone.setCellValueFactory { it.value.phoneProperty }
        date.setCellValueFactory { it.value.dateProperty }
    }

    ObservableList<Person> observableList() {
        FXCollections.observableArrayList(personRepository.findAll().collect {
            new Person(idProperty: new SimpleStringProperty(String.valueOf(it.id)),
                    nameProperty: new SimpleStringProperty(it.name),
                    phoneProperty: new SimpleStringProperty(it.phone),
                    dateProperty: new SimpleObjectProperty<Date>(it.date)
            )
        })
    }

    void init(Revo revo) {
        this.adminRepository = revo.adminRepository
        this.revo = revo
        this.mainService = revo.mainService
        this.personRepository = revo.personRepository
        data.items = observableList()
    }

    void gotoLogin(ActionEvent event) {
        revo.admin = null
        revo.showLoginPage()
    }

    void delete(ActionEvent event) {
        if (revo.admin.role != 0)
            Notifications.create().title("Delete Message").darkStyle().text("You Should Be Admin To Delete Person!").showInformation()
        else {
            if (data.selectionModel.selectedIndex != -1) {
                Long id = new Long(data.selectionModel.selectedItem.idProperty.getValue())
                personRepository.delete(id)
                data.items = observableList()
                Notifications.create().title("Success Message").darkStyle().text("Success Delete A Row!").showInformation()
            } else Notifications.create().title("Select Message").darkStyle().text("You Should Select A Row!").showInformation()
        }
    }

    void update(ActionEvent event) {
        if (revo.admin.role != 0)
            Notifications.create().title("Update Message").darkStyle().text("You Should Be Admin To Update Person!").showInformation()
        else {
            if (data.selectionModel.selectedIndex != -1) {
                Long id = new Long(data.selectionModel.selectedItem.idProperty.getValue())
/********update*******************/
            } else Notifications.create().title("Select Message").darkStyle().text("You Should Select A Row!").showInformation()
        }
    }

    void save(ActionEvent event) {

    }
}
