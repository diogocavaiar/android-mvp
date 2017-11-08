package dmc.com.br.examplemvp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import dmc.com.br.examplemvp.data.model.User;
import dmc.com.br.examplemvp.data.source.Repository;
import dmc.com.br.examplemvp.data.source.RepositoryDataSource;
import dmc.com.br.examplemvp.data.source.local.DatabaseProvider;
import dmc.com.br.examplemvp.data.source.local.LocalDataSource;

/**
 * Created by diogo on 31/10/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class UserRepositoryLocalTest {

    RepositoryDataSource<User> repositoryLocal;

    @Before
    public void setup() {
        DatabaseProvider.initDatabaseInMemory(RuntimeEnvironment.application);
        repositoryLocal = new Repository(new LocalDataSource());
    }

    @Test
    public void whenCallInsertMethod_shouldSaveDataInTheDatabase() {
        repositoryLocal.insert(new User("Diogo", "Cavaiar", "diogo_su@hotmail.com"));

        List<User> repositoryLocalAll = repositoryLocal.getAll();
        Assert.assertEquals(1, repositoryLocalAll.size());
    }

    @Test
    public void whenInsertANewUser_shouldReturnTheUserIdSaved() {
        long id = repositoryLocal.insert(new User("Luiz", "Wagner", "lw-cavaiar@tete.com"));

        Assert.assertEquals(1L, id);
    }

    @Test
    public void whenDeleteAUser_shouldReturnTheNumberOfLinesAffected() {
        repositoryLocal.insert(new User("Diogo", "Cavaiar", "diogo.mironc@gmail.com"));
        long deleteId = repositoryLocal.insert(new User("Ana", "Maria", "anamaria@gmail.com"));


        int rowsAffected = repositoryLocal.delete(String.valueOf(deleteId));

        Assert.assertEquals(1, rowsAffected);
    }

    @Test
    public void whenCallUpdate_shouldUpdateAUserStopLoss() {
        User user = new User("Diogo", "Cavaiar", "diogo.mironc@gmail.com");
        long idInserted = repositoryLocal.insert(user);

        user.setUserId(String.valueOf(idInserted));
        user.setLastName("Miron Cavaiar");
        repositoryLocal.update(user);

        User userUpdated = repositoryLocal.getById(String.valueOf(idInserted));
        Assert.assertEquals("Miron Cavaiar", userUpdated.getLastName());
    }


    @After
    public void tearDown() {
        DatabaseProvider.clearTables();
    }

}
