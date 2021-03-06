package com.cursoandroid.componentesinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultadoCaixa, textoResultadoCheck, textoResultadoRadio;
    private TextView  textoResultadoSwitch,  textoResultadoToggle, textoResultadoSalario;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;
    private Switch switchLembrar;
    private ToggleButton toggleButton;
    private ProgressBar progressBar;
    private int progresso = 0;
    private SeekBar seekBar;


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

        //ProgressBar
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        //SeekBar
        seekBar = findViewById(R.id.seekBar);
        textoResultadoSalario = findViewById(R.id.textoResultadoSalario);

        seekBar();
        radioButton();
        adicionarListener();
    }

    public void seekBar(){

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textoResultadoSalario.setText("Salário R$: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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

        //ProgressBar
        progressBar.setVisibility(View.VISIBLE);
        if( progresso == 1){
            progressBar.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.VISIBLE);
        }

        caixaTexto();
        checkbox();
        radioButton();
        switchL();
        toggle();

        //Toast
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

        //AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( this);
        dialog.setTitle("Limpar campos");
        dialog.setMessage("Os campos serão apagados, aceitar: ");
        dialog.setCancelable(false);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                campoNome.setText("");
                campoEmail.setText("");
                textoResultadoCheck.setText("");
                textoResultadoCaixa.setText("");
                textoResultadoRadio.setText("");
                textoResultadoSwitch.setText("");
                textoResultadoToggle.setText("");

                Toast.makeText(
                        getApplicationContext(),
                        "Os dados foram apagados",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Os dados serão mantidos",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }


}
