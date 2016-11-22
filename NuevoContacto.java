package com.sebastian.mascotas;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class NuevoContacto extends AppCompatActivity {
    // Definición de objetos
    TextInputLayout TILnombre;
    TextInputLayout TILcorreo;
    TextInputLayout TILdescripcion;
    TextInputEditText TIEnombre;
    TextInputEditText TIEcorreo;
    TextInputEditText TIEdescripcion;
    private ImageButton btnStar;
    // Java Mail
    private Properties props;
    private Session session;


    // Definicón de variables
    String ETnombre;
    String ETemail;
    String ETdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Boton star
        btnStar = (ImageButton)findViewById(R.id.btnStar);

        Button btnEnviar = (Button) findViewById(R.id.BTenviar);

        TILnombre = (TextInputLayout)findViewById(R.id.TILnombre);
        TILcorreo = (TextInputLayout)findViewById(R.id.TILemail);
        TILdescripcion = (TextInputLayout)findViewById(R.id.TILdescripcion);
        TIEnombre = (TextInputEditText)findViewById(R.id.TIEnombre);
        TIEcorreo = (TextInputEditText)findViewById(R.id.TIEemail);
        TIEdescripcion = (TextInputEditText)findViewById(R.id.TIEdescripcion);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adquisición de datos
                ETnombre =  TILnombre.getEditText().getText().toString();
                ETemail =  TILcorreo.getEditText().getText().toString();
                ETdescripcion =  TILdescripcion.getEditText().getText().toString();
                Toast.makeText(getBaseContext(),"Contacto creado",Toast.LENGTH_SHORT).show();

                // Java Mail
                props = new Properties();
                props.put("mail.smtp.host", "smtp.live.com");
                //Session session = Session.getInstance(props, null);
                Session session = Session.getInstance(props,null);

                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom("sgalvis1@hotmail.com");
                    msg.setRecipients(Message.RecipientType.TO,
                            "sgalvis1@hotmail.com");
                    msg.setSubject("JavaMail hello world example");
                    msg.setSentDate(new Date());
                    msg.setText("Hello, world!\n");
                    Transport.send(msg, "sgalvis1@hotmail.com","sebas2293");
                    System.out.println("sending");
                } catch (MessagingException mex) {
                    System.out.println("send failed, exception: " + mex);
                }


            }
        });

        // Accion de boton de Star
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(NuevoContacto.this,Main2Activity.class);
                startActivity(i3);
            }
        });

    }

    // Menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }
    // Opciones de menú opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.MeContacto:
                Intent i4 = new Intent(this,NuevoContacto.class);
                startActivity(i4);
                break;

            case R.id.MeInformacion:
                Intent i5 = new Intent(this,Informacionapp.class);
                startActivity(i5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
