package pethersilva.com.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoListActivity extends AppCompatActivity {

    public static final int TODOLIST_ACTIVITY_REQUEST_CODE = 1;
    public static final String LIST_ITEM = "list_item";
    private Toolbar toolbar;
    private Button btnSalvar;
    private EditText txtItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        //TODO 11: Adicionar a toolbar na TodoListActivity
        //TODO 14: Mapear componente do item da lista
        //TODO 15: Adicionar evento de clique no botão
        //TODO 16: Verificar se usuário digitou o item da lista antes de salvar
        //TODO 17: Salvar informação no bundle
        //TODO 18: Retornar para main activity
    }

    //TODO 19: Configurar o clique do botão na back Arrow da toolbar
}