package br.com.dcod.modules.gss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String LEGACY_AUDIT_ACTION = "br.com.dcod.droid.action.AUDIT";
    public static final String AUDIT_ACTION = "systems.decode.droid.action.AUDIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String requestId = ((EditText) findViewById(R.id.reqReqId)).getText().toString();
                String groupId = ((EditText) findViewById(R.id.reqGroupId)).getText().toString();
                String routeId = ((EditText) findViewById(R.id.reqRouteId)).getText().toString();

                requestDecodeRoute(requestId, groupId, routeId, AUDIT_ACTION);
            }
        });

        findViewById(R.id.legacyGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String requestId = ((EditText) findViewById(R.id.reqReqId)).getText().toString();
                String groupId = ((EditText) findViewById(R.id.reqGroupId)).getText().toString();
                String routeId = ((EditText) findViewById(R.id.reqRouteId)).getText().toString();

                requestDecodeRoute(requestId, groupId, routeId, LEGACY_AUDIT_ACTION);
            }
        });

        ((EditText) findViewById(R.id.reqReqId)).setText(getNewRequestId());

    }

    private String getNewRequestId() {
        return "" + (100000 + new Random().nextInt(900000));
    }

    private void requestDecodeRoute(String requestId, String groupId, String routeId, String action) {

        /* Configure the intent with the required parameters */
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(action);
        intent.putExtra("module", "aegea-gss");

        /* Module-specific content */
        intent.putExtra("idServico","" + requestId);
        intent.putExtra("idContrato","50");
        intent.putExtra("nrRota", groupId + "/" + routeId);
        intent.putExtra("cdEquipe","E1");
        intent.putExtra("nmEquipe","Equipe 1");

        intent.putExtra("idFuncionario","10");
        intent.putExtra("nmNome","Pedro");
        intent.putExtra("nrMatricula","M1020");

        /* Start Decode application */
        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(MainActivity.this,
                    "Solicitando isServico " + requestId + "\nGrupo " + groupId + " na Rota " + routeId,
                    Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Nenhuma aplicação encontrada com o intent-filter \"br.com.dcod.droid.action.AUDIT\".\nO aplicativo Decode está instalado?", Toast.LENGTH_LONG).show();
        }
    }
}
