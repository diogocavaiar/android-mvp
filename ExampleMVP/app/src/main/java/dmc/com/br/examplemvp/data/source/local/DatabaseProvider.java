package dmc.com.br.examplemvp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.VisibleForTesting;

/**
 * Created by diogo on 18/10/2017.
 */

public class DatabaseProvider {

    private static Database database;

    private DatabaseProvider() {}

    public static void init(Context context) {
        database = new Database(context, "EXAMPLEMVP.db");
    }

    public static SQLiteDatabase getReadableDatabase() {
        return database.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase() {
        return database.getWritableDatabase();
    }

    @VisibleForTesting
    public static void clearTables() {
        getWritableDatabase().execSQL("DELETE FROM " + UserContract.TABLE_NAME);
    }

    @VisibleForTesting
    public static void initDatabaseInMemory(Context context) {
        database = new Database(context, null);
    }

}
