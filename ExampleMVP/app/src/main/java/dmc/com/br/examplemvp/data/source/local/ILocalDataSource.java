package dmc.com.br.examplemvp.data.source.local;

import java.util.List;

import dmc.com.br.examplemvp.data.model.User;

/**
 * Created by diogo on 30/10/2017.
 */

public interface ILocalDataSource {

    List<User> getAll();

    User getById(String id);

    long insert(User user);

    int delete(String id);

    void update(User user);
}
