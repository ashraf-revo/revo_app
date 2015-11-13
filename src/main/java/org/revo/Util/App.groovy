package org.revo.Util

import org.revo.Repository.AdminRepository
import org.revo.Repository.PersonRepository
import org.revo.Revo
import org.revo.Service.MainService

/**
 * Created by revo on 13/11/15.
 */
abstract class App {
    AdminRepository adminRepository
    PersonRepository personRepository
    Revo revo
    MainService mainService


}
