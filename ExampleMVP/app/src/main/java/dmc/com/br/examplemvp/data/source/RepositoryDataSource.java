package dmc.com.br.examplemvp.data.source;

import java.util.List;

/**
 * Created by diogo on 30/10/2017.
 */

public interface RepositoryDataSource<T> {

    List<T> getAll();

    T getById(String id);

    long insert(T type);

    int delete(String id);

    void update(T type);

}
