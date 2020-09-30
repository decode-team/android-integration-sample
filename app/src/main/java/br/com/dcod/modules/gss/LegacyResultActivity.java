package br.com.dcod.modules.gss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LegacyResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legacy_result);

        Intent reportIntent = getIntent();

        if(reportIntent != null) {
            int idServico = reportIntent.getIntExtra("idServico", 0);
            int idContrato = reportIntent.getIntExtra("idContrato", 0);
            int qtdeAuditorias = reportIntent.getIntExtra("auditoriaLeituraQtdeAuditorias", 0);
            int qtdeAuditoriasViaveis = reportIntent.getIntExtra("auditoriaLeituraQtdeAuditoriasViaveis", 0);
            int qtdeAuditoriasInviaveis = reportIntent.getIntExtra("auditoriaLeituraQtdeAuditoriasInviaveis", 0);
            String tempoMedioAuditorias = reportIntent.getStringExtra("auditoriaLeituraTempoMedioAuditorias");
            String observacao = reportIntent.getStringExtra("auditoriaLeituraObservacao");

            String message = "Serviço " + idServico + " do contrato " + idContrato + " finalizado." +
                    "\nAuditorias realizadas com sucesso: " + qtdeAuditoriasViaveis + " de " + qtdeAuditorias +
                    " (" + qtdeAuditoriasInviaveis + " inviáveis)." +
                    "\nTempo médio por captura: " + tempoMedioAuditorias +
                    "\nObservação: " + observacao;

            ((TextView) findViewById(R.id.report)).setText(message);
        }
    }
}