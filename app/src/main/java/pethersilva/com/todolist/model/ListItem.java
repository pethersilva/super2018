package pethersilva.com.todolist.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "listitems_table")
public class ListItem {

    public ListItem(String item) {
        this.item = item;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "item")
    @NonNull
    private String item;

    public int getUid() {
        return uid;
    }

    @NonNull
    public String getItem() {
        return item;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setItem(@NonNull String item) {
        this.item = item;
    }
}