package pethersilva.com.todolist.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import pethersilva.com.todolist.model.ListItem;

import java.util.List;

@Dao
public interface ListItemDao {

    @Query("SELECT * from listitems_table")
    List<ListItem> getAll();

    @Insert
    void insertAll(ListItem... itens);

    @Delete
    void delete(ListItem item);
}
