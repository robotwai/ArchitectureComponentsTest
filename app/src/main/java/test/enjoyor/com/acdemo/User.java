package test.enjoyor.com.acdemo;

/**
 * Created by lz on 2017/6/5.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class  User {
    @PrimaryKey
    private int id;
    private String name;
    private String lastName;
}
