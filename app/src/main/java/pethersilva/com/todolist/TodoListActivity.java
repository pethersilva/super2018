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
        //TODO 12: Adicionar a toolbar na TodoListActivity
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //TODO 15: Mapear componente do item da lista
        txtItem = findViewById(R.id.textViewItem);

        //TODO 16: Adicionar evento de clique no botão
        btnSalvar = findViewById(R.id.buttonSave);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 17: Verificar se usuário digitou o item da lista antes de salvar
                if  (txtItem.getEditableText().toString().isEmpty()) {
                    Toast.makeText(TodoListActivity.this, "Insira o item da lista para salvar", Toast.LENGTH_LONG).show();
                } else {
                    //TODO 18: Salvar informação no bundle
                    Intent data = new Intent();
                    data.putExtra(LIST_ITEM, txtItem.getEditableText().toString());
                    //TODO 19: Retornar para main activity
                    setResult(Activity.RESULT_OK, data);
                    finish();
                }
            }
        });
    }

    //TODO 20: Configurar o clique do botão na back Arrow da toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}