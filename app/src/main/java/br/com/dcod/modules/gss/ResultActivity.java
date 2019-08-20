package br.com.dcod.modules.gss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent reportIntent = getIntent();

        if(reportIntent != null) {
            int idServico = reportIntent.getIntExtra("idServico", 0);
            int idContrato = reportIntent.getIntExtra("idContrato", 0);
            int qtdeAuditorias = reportIntent.getIntExtra("qtdeAuditorias", 0);
            int qtdeAuditoriasViaveis = reportIntent.getIntExtra("qtdeAuditoriasViaveis", 0);
            int qtdeAuditoriasInviaveis = reportIntent.getIntExtra("qtdeAuditoriasInviaveis", 0);
            String tempoMedioAuditorias = reportIntent.getStringExtra("tempoMedioAuditorias");
            String observacao = reportIntent.getStringExtra("observacao");

            String message = "Serviço " + idServico + " do contrato " + idContrato + " finalizado." +
                    "\nAuditorias realizadas com sucesso: " + qtdeAuditoriasViaveis + " de " + qtdeAuditorias +
                    " (" + qtdeAuditoriasInviaveis + " inviáveis)." +
                    "\nTempo médio de captura: " + tempoMedioAuditorias +
                    "\nObservação: " + observacao;

            ((TextView) findViewById(R.id.report)).setText(message);
        }

    }
}
