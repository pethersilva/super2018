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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(this);

        //TODO 04: Adicionar a toolbar na MainActivity
        //TODO 25: Buscar dados do banco de dados
        //TODO 26: Configurar o adapter na lista
        //TODO 27: Configurar o click no item da lista
        super.onCreate(savedInstanceState);
    }

    //TODO 05: Adicione os itens de menu na toolbar
    //TODO 06: Adicione uma ação para o item add do menu
    //TODO 20: Receber o retorno com a informação da TodoListActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == TodoListActivity.TODOLIST_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            //TODO 21: Salvar informação no banco de dados e setar o novo adapter
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //TODO 24: Criar um adapter preparar os dados e passar para a view.
}
