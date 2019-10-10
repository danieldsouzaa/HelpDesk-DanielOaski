package es.senac.br.helpdesk_danieloaski;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import es.senac.br.helpdesk.R;
import es.senac.br.helpdesk_danieloaski.api.ChamadoTask;
import es.senac.br.helpdesk_danieloaski.api.OnEventListener;
import es.senac.br.helpdesk_danieloaski.model.Chamado;


public class TabAberto extends Fragment {


    ListView listaMsgAbertas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_aberto, container, false);

        final List<Chamado> chamadosListaAberto = new ArrayList<Chamado>();

        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {

            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "ABERTO ", Toast.LENGTH_LONG).show();

                Gson gson = new Gson();

                Chamado[] chamados = gson.fromJson(result, Chamado[].class);

                for (Chamado chamado: chamados){
                    if(chamado.getStatus().toLowerCase().equals("aberto")){

                        chamadosListaAberto.add(chamado);

                    }

                ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(),
                        android.R.layout.simple_list_item_1, chamadosListaAberto);

                listaMsgAbertas = (ListView) view.findViewById(R.id.listAberto);

                listaMsgAbertas.setAdapter(adapter);

            }
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        chamadoTask.execute();


        return view;
    }
}


/* codigo anterior

public class TabAberto extends Fragment {


    ListView listaMsgAbertas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_aberto, container, false);

        listaMsgAbertas = (ListView) view.findViewById(R.id.listAberto);

        List<Mensagem> mensagems = new ArrayList<Mensagem>();

        for(int i=0; i<20; i++)
            mensagems.add(new Mensagem(1L, "Mensagem " + i, Status.ENVIADA));

        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(),
                android.R.layout.simple_list_item_1, mensagems);

        listaMsgAbertas.setAdapter(adapter);


        return view;
    }
}

 */

