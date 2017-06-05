package test.enjoyor.com.acdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by lz on 2017/6/5.
 */
@Database(entities = {User.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
