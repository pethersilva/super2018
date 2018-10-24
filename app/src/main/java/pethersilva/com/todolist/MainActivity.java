package pethersilva.com.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.widget.*;
import pethersilva.com.todolist.dao.AppDatabase;
import pethersilva.com.todolist.model.ListItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private final String TAG = "MainActivity";
    private AppDatabase database;
    private List<ListItem> items;
    private ListView listView;
    private ListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(this);

        //TODO 05: Adicionar a toolbar na MainActivity
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO 26: Buscar dados do banco de dados
        items = database.listItemDao().getAll();

        //TODO 27: Configurar o adapter na lista
        listView = findViewById(R.id.listview);
        listItemAdapter = new ListItemAdapter(this, items);
        listView.setAdapter(listItemAdapter);

        //TODO 28: Configurar o click no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "Clicado na posição: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        super.onCreate(savedInstanceState);
    }

    //TODO 06: Adicione os itens de menu na toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //TODO 07: Adicione uma ação para o item add do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_adicionar) {
            Toast.makeText(MainActivity.this, "Botão adicionar clicado", Toast.LENGTH_LONG).show();
            //TODO 08: Criar a Activity para preencher dados da lista
            //TODO 10: Chamar a Activity criada
            Intent todoListActivity = new Intent(this, TodoListActivity.class);
            startActivityForResult(todoListActivity, TodoListActivity.TODOLIST_ACTIVITY_REQUEST_CODE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO 21: Receber o retorno com a informação da TodoListActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == TodoListActivity.TODOLIST_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            //TODO 22: Salvar informação no banco de dados
            String item = data.getStringExtra(TodoListActivity.LIST_ITEM);
            ListItem listItem = new ListItem(item);
            database.listItemDao().insertAll(listItem);
            items = database.listItemDao().getAll();
            listItemAdapter = new ListItemAdapter(this, items);
            listView.setAdapter(listItemAdapter);
            Log.d(TAG, item);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //TODO 25: Criar um adapter preparar os dados e passar para a view.
    private class ListItemAdapter extends ArrayAdapter<ListItem> {

        private final Activity context;
        private List<ListItem> listItems;

        public ListItemAdapter(Activity context, List<ListItem> items) {
            super(context, R.layout.listview_row, items);
            this.context = context;
            this.listItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = this.context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listview_row, null, true);
            TextView textView = rowView.findViewById(R.id.txtlist_item);
            textView.setText(listItems.get(position).getItem());
            return  textView;
        }
    }
}
