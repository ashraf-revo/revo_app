package org.revo.domain

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Transient

/**
 * Created by revo on 13/11/15.
 */
@Entity
@Canonical
class Admin {
    @Id
    @GeneratedValue
    Long id
    String name
    String password
    int role=1
}
