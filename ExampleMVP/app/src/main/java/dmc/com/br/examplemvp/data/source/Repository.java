package dmc.com.br.examplemvp.data.source;

import java.util.List;

import dmc.com.br.examplemvp.data.model.User;
import dmc.com.br.examplemvp.data.source.local.LocalDataSource;

/**
 * Created by diogo on 30/10/2017.
 */

public class Repository implements RepositoryDataSource<User> {

    private LocalDataSource localDataSource;

    public Repository(LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public List<User> getAll() {
        return localDataSource.getAll();
    }

    @Override
    public User getById(String id) {
        return localDataSource.getById(id);
    }

    @Override
    public long insert(User user) {
        return localDataSource.insert(user);
    }

    @Override
    public int delete(String id) {
        return localDataSource.delete(id);
    }

    @Override
    public void update(User user) {
        localDataSource.update(user);
    }
}
