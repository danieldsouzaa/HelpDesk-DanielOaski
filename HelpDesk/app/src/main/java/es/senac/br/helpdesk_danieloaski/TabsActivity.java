package es.senac.br.helpdesk_danieloaski;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import es.senac.br.helpdesk.R;

public class TabsActivity extends AppCompatActivity {

    // criação de variavel
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override // metodo
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_activity);// chamando a classe xml


        //estanciou
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        // chamando
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabAberto(), "Aberto");
        adapter.addFragment(new TabSolucao(), "Solução");
        adapter.addFragment(new TabFechado(), "Fechado");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // estancia o botao logar
        final FloatingActionButton btnChamado = (FloatingActionButton)findViewById(R.id.floatingBtnChamado);

        btnChamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // assim que logar chama a outra tela
                Intent trocaTela = new Intent(getApplicationContext(), TelaChamado.class);

                startActivity(trocaTela);

                // colocando a msg na tela...
                Toast cliqueMsg = Toast.makeText(getApplicationContext(),"Abrir Chamado", Toast.LENGTH_LONG);

                // faz mostrar a mensagem na tela, chama o Toast mensagem
                cliqueMsg.show();
            }
        });

    }
}
