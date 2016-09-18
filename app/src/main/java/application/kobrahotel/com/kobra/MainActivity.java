package application.kobrahotel.com.kobra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.User) EditText user;
    @Bind(R.id.Password) EditText password;
    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;
    private String UserLogin = "admin";
    private String UserPassword = "123456";
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("K Hotel");
        mToolbar.setLogo(R.drawable.city);
//        mToolbar.setSubtitle("Hotel");

        mToolbarBottom = (Toolbar) findViewById(R.id.inc_tb_botton);
        mToolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

                return true;
            }
        });
    }

    @OnClick(R.id.Enter)
    public void doLogin(View v) {

        String username = user.getText().toString();
        String userpassword = password.getText().toString();

        if(username.length()==0 && userpassword.length()==0 ){
            user.setError("Campo obrigatório");
            password.setError("Campo obrigatório");
        }
        else if(username.length()==0){
            user.setError("Campo obrigatório");
        }
        else if(password.length() == 0){
            password.setError("Campo obrigatório");
        }
        else if(username.equals(UserLogin) && userpassword.equals(UserPassword)){

            Intent intent = new Intent(getApplicationContext(), ContentsActivity.class);
            startActivity(intent);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso");
            builder.setMessage("Usuário ou senha incorreta");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    alerta.hide();
                }
            });
            alerta = builder.create();
            alerta.show();
        }
    }

}
