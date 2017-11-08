package dmc.com.br.examplemvp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by diogo on 18/10/2017.
 */

public class Database extends SQLiteOpenHelper {

    private static int VERSION = 1;

    public Database(Context context, String name) {
        super(context, name, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ")
                .append(UserContract.TABLE_NAME).append(" ( ")
                .append(UserContract._ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ")
                .append(UserContract.COLUMN_FIRST_NAME).append(" TEXT NOT NULL, ")
                .append(UserContract.COLUMN_LAST_NAME).append(" TEXT NOT NULL, ")
                .append(UserContract.COLUMN_EMAIL).append(" TEXT NOT NULL")
                .append(") ");

        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}