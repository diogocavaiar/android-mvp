package dmc.com.br.examplemvp.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by diogo on 18/10/2017.
 */

public class UserContract implements BaseColumns {
    public static final String TABLE_NAME = "USER";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
}
