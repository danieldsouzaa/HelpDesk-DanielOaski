package es.senac.br.helpdesk_danieloaski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.senac.br.helpdesk.R;

public class TelaLogin extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        // estancia o login e a senha editText
        final EditText editLogin = (EditText)findViewById(R.id.editLogin);
        final EditText editSenha = (EditText)findViewById(R.id.editSenha);

        // estancia o botao logar
        final Button btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // criando uma variavel recebendo o texto digitado no login e senha
                String usuario = editLogin.getText().toString();
                String senha = editSenha.getText().toString();

                // comparando o texto digitado se for igual ele mostra uma msg logado
                if (usuario.equals("admin")&& senha.equals("senha")){

                    // colocando a msg na tela...
                    Toast mensagem = Toast.makeText(getApplicationContext(),"Logado com Sucesso", Toast.LENGTH_LONG);

                    // faz mostrar a mensagem na tela, chama o Toast mensagem
                    mensagem.show();

                    // assim que logar chama a outra tela main2
                    Intent trocaTela = new Intent(getApplicationContext(), TabsActivity.class);

                    startActivity(trocaTela);

                }else{

                    // msg se o usuario e senha estiverem errados
                    Toast erroLogin = Toast.makeText(getApplicationContext(),"Login ou Senha Incorreto", Toast.LENGTH_LONG);

                    // faz mostrar a mensagem na tela, chama o Toast mensagem
                    erroLogin.show();


                }

            }
        });

    }
}