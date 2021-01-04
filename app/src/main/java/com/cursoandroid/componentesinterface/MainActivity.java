package com.cursoandroid.componentesinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Caixas de Texto
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        //CheckBox
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        //RadioButton
        sexoMasculino = findViewById(R.id.radioButtonMasculino);
        sexoFeminino = findViewById(R.id.radioButtonFeminino);

        opcaoSexo = findViewById(R.id.radioGroupSexo);

        radioButton();
    }

    public void radioButton(){

        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonMasculino){
                    textoResultado.setText("Masculino");
                }else if(checkedId == R.id.radioButtonFeminino){
                    textoResultado.setText("Feminino");
                }

            }
        });

     /*   if(sexoMasculino.isChecked()){
            textoResultado.setText("Masculino");
        }else{
            textoResultado.setText("Feminino");
        }
      */

    }

    public void enviar(View view){

        //checkbox();

        radioButton();

        /*
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultado.setText("Nome: " + nome + ", E-mail: " + email);

     */
    }

    public void checkbox(){

        String texto = "";
        if(checkVerde.isChecked()){
            //String corSelecionada = checkVerde.getText().toString();
            //texto = corSelecionada;
            texto = "- Verde Selecionado ";
        }if(checkBranco.isChecked()){
            texto = texto + "- Branco Selecionado ";
        }if(checkVermelho.isChecked()){
            texto = texto + "- Vermelho Selecionado ";
        }
        textoResultado.setText( texto);

    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");
        textoResultado.setText("");
    }

}
