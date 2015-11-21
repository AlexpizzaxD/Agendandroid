package com.android.alejandroid.tabs;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class AgregarRegistros extends AppCompatActivity implements OnClickListener{

    /*Declarando las variables a usar*/
    EditText input_usuario, input_nombre, input_numero, input_numero_alternativo, input_correo;
    TextInputLayout input_layout_usuario, input_layout_nombre, input_layout_numero, input_layout_numero_alternativo,
            input_layout_correo;
    Button btn_guardar;

    RadioGroup radiogroup;
    RadioButton rb_docente, rb_alumno, rb_otro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_registros);

        /*
            Iniciamos las variables 'input_layout' e 'input' y buscamos su referencia mediante su id
        */
        input_layout_usuario = (TextInputLayout) findViewById(R.id.input_layout_usuario);
        input_layout_nombre = (TextInputLayout) findViewById(R.id.input_layout_nombre);
        input_layout_numero = (TextInputLayout) findViewById(R.id.input_layout_numero);
        input_layout_numero_alternativo = (TextInputLayout) findViewById(R.id.input_layout_numero_alternativo);
        input_layout_correo = (TextInputLayout) findViewById(R.id.input_layout_correo);

        input_usuario = (EditText) findViewById(R.id.input_usuario);
        input_nombre = (EditText) findViewById(R.id.input_nombre);
        input_numero = (EditText) findViewById(R.id.input_numero);
        input_numero_alternativo = (EditText) findViewById(R.id.input_numero_alternativo);
        input_correo = (EditText) findViewById(R.id.input_correo);

        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(this);

        /*
            Agregamos un TextChangeListener a los input
        */
        input_usuario.addTextChangedListener(new MiTextWatcher(input_usuario));
        input_nombre.addTextChangedListener(new MiTextWatcher(input_nombre));
        input_numero.addTextChangedListener(new MiTextWatcher(input_numero));
        input_correo.addTextChangedListener(new MiTextWatcher(input_correo));

        /*
            Iniciamos las variables para el Radiougroup y los Radiobuttons
        */
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        rb_docente = (RadioButton) findViewById(R.id.rb_docente);
        rb_alumno = (RadioButton) findViewById(R.id.rb_alumno);
        rb_otro = (RadioButton) findViewById(R.id.rb_otro);
    }

    @Override
    public void onClick(View v) {
        enviarFormulario();
    }

    private void enviarFormulario() {
        if(!validarUsuario() && !validarNombre() && !validarCorreo() && !validarNumero() && !validarRadiogroup()){
            Snackbar
                    .make(findViewById(R.id.activity_registro), "Hey! Asegurate de llenar todos los datos", Snackbar.LENGTH_LONG)
                    .show();
        }
        else if(validarUsuario() && validarNombre() && validarCorreo() && validarNumero() && validarRadiogroup()){
            Snackbar
                    .make(findViewById(R.id.activity_registro), "Datos guardados :D", Snackbar.LENGTH_LONG)
                    .setAction("Volver al inicio", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    })
                    .show();
        }
    }

    private boolean validarUsuario() {
        if (input_usuario.getText().toString().trim().isEmpty()) {
            input_layout_usuario.setError(getString(R.string.error_msn_usuario));
            requestFocus(input_usuario);
            return false;
        } else {
            input_layout_usuario.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarNombre() {
        if (input_nombre.getText().toString().trim().isEmpty()) {
            input_layout_nombre.setError(getString(R.string.error_msn_nombre));
            requestFocus(input_nombre);
            return false;
        } else {
            input_layout_nombre.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarCorreo() {
        String correo = input_correo.getText().toString().trim();

        if (correo.isEmpty() || !esCorreoValido(correo)) {
            input_layout_correo.setError(getString(R.string.error_msn_correo));
            requestFocus(input_correo);
            return false;
        } else {
            input_layout_correo.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validarNumero() {
        if (input_numero.getText().toString().trim().isEmpty()) {
            input_layout_numero.setError(getString(R.string.error_msn_numero));
            requestFocus(input_numero);
            return false;
        } else {
            input_layout_numero.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validarRadiogroup(){
        if (radiogroup.getCheckedRadioButtonId() == -1){
            Snackbar
                    .make(findViewById(R.id.activity_registro), "Hey! Asegurate de llenar todos los datos", Snackbar.LENGTH_LONG)
                    .show();
        }
        else{
            Snackbar
                    .make(findViewById(R.id.activity_registro), "Hey! Asegurate de llenar todos los datos", Snackbar.LENGTH_LONG)
                    .show();
        }
        return true;
    }

    private static boolean esCorreoValido(String correo) {
        return !TextUtils.isEmpty(correo) && android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MiTextWatcher implements TextWatcher {

        private View view;

        private MiTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_usuario:
                    validarUsuario();
                    break;

                case R.id.input_nombre:
                    validarNombre();
                    break;

                case R.id.input_numero:
                    validarNumero();
                    break;

                case R.id.input_correo:
                    validarCorreo();
                    break;
            }
        }
    }
}
