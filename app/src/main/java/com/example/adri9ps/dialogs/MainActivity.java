package com.example.adri9ps.dialogs;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    int dia, mes, año, hora, minutos;
    private TextView txtFecha;
    private TextView txtHora;
    private TextView txtColor;
    private Button seleccionarFecha;
    private Button seleccionarHora;
    private Button seleccionarColor;

    DatePickerDialog dialogoFecha;
    TimePickerDialog dialogoHora;
    AlertDialog.Builder dialogoColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtHora = (TextView) findViewById(R.id.txtHora);
        txtColor = (TextView) findViewById(R.id.txtColor);
        seleccionarFecha = (Button) findViewById(R.id.btn_fecha);
        seleccionarHora = (Button) findViewById(R.id.btn_hora);
        seleccionarColor = (Button) findViewById(R.id.btn_color);


        //Fecha
        dialogoFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dia = dayOfMonth;
                mes = month;
                año = year;
                txtFecha.setText("Fecha: " + dayOfMonth + "/" + (month+1) + "/" + year);



            }
        },0,0,0);

        //Hora
        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Al aceptar la hora
                hora = hourOfDay;
                minutos = minute;
                txtHora.setText("Hora: " + hourOfDay + ":" + minute);


            }
        }, 00,00,false);

        //Añadimos colores
        final String[] colors_array = new String[3];

        colors_array[0] = "Azul";
        colors_array[1] = "Verde";
        colors_array[2] = "Rojo";

        //Colores
        dialogoColores = new AlertDialog.Builder(this);
        dialogoColores.setTitle("Selecciona un color")
                .setItems(colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Al seleccionar algun elemento
                        txtColor.setText("Color: " + colors_array[which]);
                    }
                });
        dialogoColores.create();
        //Botones
        seleccionarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoFecha.show();
            }
        });

        seleccionarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoHora.show();
            }
        });

        seleccionarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoColores.show();
            }
        });
    }
}
