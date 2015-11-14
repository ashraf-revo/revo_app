package org.revo.Service;

/**
 * Created by revo on 13/11/15.
 */
public interface MainService {
    boolean CheckLogin(String name, String password);

    void SerializeData(String Path);

    void DeSerializeData(String Path);

}
