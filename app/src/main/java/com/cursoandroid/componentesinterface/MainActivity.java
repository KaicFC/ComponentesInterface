package com.cursoandroid.componentesinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultadoCaixa, textoResultadoCheck, textoResultadoRadio;
    private TextView  textoResultadoSwitch,  textoResultadoToggle;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;
    private Switch switchLembrar;
    private ToggleButton toggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Caixas de Texto
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultadoCaixa = findViewById(R.id.textoResultadoCaixa);

        //CheckBox
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);
        textoResultadoCheck = findViewById(R.id.textoResultadoCheck);

        //RadioButton
        sexoMasculino = findViewById(R.id.radioButtonMasculino);
        sexoFeminino = findViewById(R.id.radioButtonFeminino);
        textoResultadoRadio = findViewById(R.id.textoResultadoRadio);

        opcaoSexo = findViewById(R.id.radioGroupSexo);

        //Switch
        switchLembrar = findViewById(R.id.switchLembrar);
        textoResultadoSwitch = findViewById(R.id.textoResultadoSwitch);

        //ToggleButton
        toggleButton = findViewById(R.id.toggleButton);
        textoResultadoToggle = findViewById(R.id.textoResultadoToggle);

        radioButton();
        adicionarListener();
    }

    public void radioButton(){
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.radioButtonMasculino){
                textoResultadoRadio.setText("Masculino");
            }else if(checkedId == R.id.radioButtonFeminino){
                textoResultadoRadio.setText("Feminino");
            }
            }
        });
    }

    public void adicionarListener(){
        switchLembrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textoResultadoSwitch.setText("Lembrar dados");
                }else{
                    textoResultadoSwitch.setText("Não lembrar dados");
                }
            }
        });
    }


    public void enviar(View view){

        caixaTexto();
        checkbox();
        radioButton();
        switchL();
        toggle();

        Toast.makeText(
                getApplicationContext(), "Enviado com sucesso!", Toast.LENGTH_SHORT
        ).show();

    }

    public void caixaTexto(){

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultadoCaixa.setText("Nome: " + nome + ", E-mail: " + email);
    }

    public void checkbox(){

        String texto = "";
        if(checkVerde.isChecked()){
            texto = "- Verde Selecionado ";
        }else if(checkBranco.isChecked()){
            texto = texto + "- Branco Selecionado ";
        }else if(checkVermelho.isChecked()){
            texto = texto + "- Vermelho Selecionado ";
        }
        textoResultadoCheck.setText(texto);
    }

    public void switchL(){

        if(switchLembrar.isChecked()){
            textoResultadoSwitch.setText("Lembrar dados");
        }else{
            textoResultadoSwitch.setText("Não lembrar dados");
        }
    }

    public void toggle(){

        if(toggleButton.isChecked()){
            textoResultadoToggle.setText("Aceito");
        }else{
            textoResultadoToggle.setText("Não aceito");
        }

    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");
        textoResultadoCheck.setText("");
        textoResultadoCaixa.setText("");
        textoResultadoRadio.setText("");
        textoResultadoSwitch.setText("");
        textoResultadoToggle.setText("");
    }




}
