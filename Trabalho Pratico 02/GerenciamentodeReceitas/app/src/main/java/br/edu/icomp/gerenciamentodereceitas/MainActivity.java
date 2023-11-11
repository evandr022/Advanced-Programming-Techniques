package br.edu.icomp.gerenciamentodereceitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("PlainText", "onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("PlainText", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("PlainText", "onResume");
    }

    public void clickCadastro(View view){
        Intent intent = new Intent(this, activity_cadastro.class);
        startActivity(intent);
    }

    public void clickConsulta(View view){
        Intent intent = new Intent(this, activity_consulta.class);
        startActivity(intent);
    }

    public void clickRelatorio(View view){
        Intent intent = new Intent(this, activity_relatorio.class);
        startActivity(intent);
    }
}