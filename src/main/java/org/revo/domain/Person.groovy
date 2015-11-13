package org.revo.domain

import groovy.transform.Canonical
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty

import javax.persistence.*

/**
 * Created by revo on 13/11/15.
 */
@Canonical
@Entity
class Person {
    @Id
    @GeneratedValue
    Long id
    String name
    String phone
    @Temporal(TemporalType.DATE)
    Date date = new Date()
    @Transient
    SimpleStringProperty idProperty
    @Transient
    SimpleStringProperty nameProperty
    @Transient
    SimpleStringProperty phoneProperty
    @Transient
    SimpleObjectProperty<Date> dateProperty

}
