package pethersilva.com.todolist.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import pethersilva.com.todolist.model.ListItem;

@Database(entities = {ListItem.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;

    public abstract ListItemDao listItemDao();

    public static AppDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "todolist_db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

}
