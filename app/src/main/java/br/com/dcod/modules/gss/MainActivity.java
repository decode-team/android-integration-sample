package br.com.dcod.modules.gss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Configure the intent with the required parameters */
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction("br.com.dcod.droid.action.AUDIT");
                intent.putExtra("module", "aegea-gss");

                /* Module-specific content */
                intent.putExtra("idServico","100");
                intent.putExtra("idContrato","50");
                intent.putExtra("nrRota","A/1");
                intent.putExtra("cdEquipe","E1");
                intent.putExtra("nmEquipe","Equipe 1");

                intent.putExtra("idFuncionario","10");
                intent.putExtra("nmNome","Pedro");
                intent.putExtra("nrMatricula","M1020");

                /* Start Decode application */
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Nenhuma aplicação encontrada com o intent-filter \"br.com.dcod.droid.action.AUDIT\".\nO aplicativo Decode está instalado?", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
