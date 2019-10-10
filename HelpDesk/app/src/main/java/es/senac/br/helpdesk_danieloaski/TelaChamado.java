package es.senac.br.helpdesk_danieloaski;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import es.senac.br.helpdesk.R;
import es.senac.br.helpdesk_danieloaski.api.APIService;
import es.senac.br.helpdesk_danieloaski.api.ApiUtils;
import es.senac.br.helpdesk_danieloaski.model.Chamado;
import es.senac.br.helpdesk_danieloaski.model.Status;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class TelaChamado extends AppCompatActivity {

    private APIService mAPIService;
    private TextView mResponseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_chamado);

        final EditText edtMensagem = (EditText) findViewById(R.id.edt_mensagem);
        Button btnEnviarMensagem = (Button) findViewById(R.id.btn_enviar_mensgem);

        mAPIService = ApiUtils.getService();

        btnEnviarMensagem.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {

             String mensagem = edtMensagem.getText().toString().trim();

             Chamado chamado = new Chamado();
             chamado.setDescricao(mensagem);

                if (!TextUtils.isEmpty(mensagem)) {
                    enviarMensagem(chamado, getApplicationContext());
                }


            }
        });
    }

    public void enviarMensagem(Chamado chamado, final Context context) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date dataAbertura = new Date();
        mAPIService = ApiUtils.getService();

        Map<String, String> jsonParams = new ArrayMap<>();
        jsonParams.put("descricao", chamado.getDescricao());
        jsonParams.put("status", Status.ABERTO.toString());
        jsonParams.put("dataAbertura", dataAbertura.getTime()+"");

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<ResponseBody> response = mAPIService.salvarMensagem(body);

        response.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse)
            {
                try
                {
                    Toast.makeText(context, "Mensagem Enviada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TelaChamado.this, TabsActivity.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable)
            {
                // other stuff...
                Toast.makeText(context, "O Envio da mensagem falhou!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
