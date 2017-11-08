package dmc.com.br.examplemvp.data.source.local;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dmc.com.br.examplemvp.data.model.User;

/**
 * Created by diogo on 18/10/2017.
 */

public class LocalDataSource implements ILocalDataSource {

    @Override
    public List<User> getAll() {
        List<User> listUser = new ArrayList<>();

        final Cursor cursor = DatabaseProvider.getReadableDatabase().query(UserContract.TABLE_NAME, new String[]{UserContract.COLUMN_FIRST_NAME, UserContract.COLUMN_LAST_NAME, UserContract.COLUMN_EMAIL},
        null,
        null,
        null,
        null,
        null);

        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    listUser.add(new User(cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_FIRST_NAME)),
                            cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_LAST_NAME)),
                            cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_EMAIL))));
                } while(cursor.moveToNext());
            }
            cursor.close();
        }

        return listUser;
    }

    @Override
    public User getById(String id) {
        String[] whereArgs = new String[] {id};
        String whereClause = UserContract._ID + "= ?";

        Cursor cursor = DatabaseProvider.getReadableDatabase()
                .query(UserContract.TABLE_NAME, new String[]{
                                UserContract._ID,
                                UserContract.COLUMN_FIRST_NAME,
                                UserContract.COLUMN_LAST_NAME,
                                UserContract.COLUMN_EMAIL},
                        whereClause,
                        whereArgs,
                        null,
                        null,
                        null);

        if (cursor != null) {
            if(cursor.moveToFirst()) {
                User user = new User(cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_FIRST_NAME)),
                        cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_LAST_NAME)),
                        cursor.getString(cursor.getColumnIndex(UserContract.COLUMN_EMAIL)));
                user.setUserId(cursor.getString(cursor.getColumnIndex(UserContract._ID)));
                return user;
            }
        }
        return null;
    }

    @Override
    public long insert(User user) {
        ContentValues cv = new ContentValues();
        cv.put(UserContract.COLUMN_FIRST_NAME, user.getFirstName());
        cv.put(UserContract.COLUMN_LAST_NAME, user.getLastName());
        cv.put(UserContract.COLUMN_EMAIL, user.getEmail());

        return DatabaseProvider.getReadableDatabase().insert(UserContract.TABLE_NAME, null, cv);
    }

    @Override
    public int delete(String id) {
        String[] whereArgs = new String[] {id};
        String whereClause = UserContract._ID + " = ? ";

        return DatabaseProvider.getWritableDatabase().delete(UserContract.TABLE_NAME, whereClause, whereArgs);
    }

    @Override
    public void update(User user) {
        ContentValues cv = new ContentValues();
        cv.put(UserContract.COLUMN_FIRST_NAME, user.getFirstName());
        cv.put(UserContract.COLUMN_LAST_NAME, user.getLastName());
        cv.put(UserContract.COLUMN_EMAIL, user.getEmail());

        String[] whereArgs = new String[] {user.getUserId()};
        String whereClause = UserContract._ID + "= ?";

        DatabaseProvider.getWritableDatabase().update(UserContract.TABLE_NAME, cv, whereClause, whereArgs);
    }
}
