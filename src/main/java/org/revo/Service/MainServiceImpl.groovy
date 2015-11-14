package org.revo.Service

import org.revo.Repository.AdminRepository
import org.revo.Repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by revo on 13/11/15.
 */
@Service
@Transactional
class MainServiceImpl implements MainService {
    @Autowired
    AdminRepository adminRepository
    @Autowired
    PersonRepository personRepository

    @Override
    boolean CheckLogin(String name, String password) {
        adminRepository.findByNameAndPassword(name, password).present
    }

    @Override
    void SerializeData(String Path) {
        println Path
        new File(Path).withObjectOutputStream { out ->
            out << personRepository.findAll()
        }
    }

    @Override
    void DeSerializeData(String Path) {
        new File(Path).withObjectInputStream { stream ->
            stream.eachObject {
                personRepository.deleteAll()
                personRepository.save(it)
            }
        }
    }
}
