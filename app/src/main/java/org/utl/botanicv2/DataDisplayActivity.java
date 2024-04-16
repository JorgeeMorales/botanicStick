package org.utl.botanicv2;

import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.utl.botanicv2.R;

public class DataDisplayActivity extends AppCompatActivity {

    private static DataDisplayActivity instance;
    private TextView textViewData;

    private TextView txtTemperatura;

    private TextView txtHumedad;

    private TextView txtTierra;

    private Button btnMonitorear;
    public static ArrayList<JSONObject> dataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dataList = new ArrayList<>();
        setContentView(R.layout.activity_data_display);
        instance = this;
        txtTemperatura=findViewById(R.id.txtTemperatura);
        txtHumedad=findViewById(R.id.txtHumedad);
        txtTierra=findViewById(R.id.txtTierra);
        btnMonitorear=findViewById(R.id.btnMonitorear);


        if (getIntent().hasExtra("data")) {
            String receivedData = getIntent().getStringExtra("data");
            //textViewData.append(receivedData + "\n");
        }
    }

    public static DataDisplayActivity getInstance() {
        return instance;
    }


    public void updateData(String newData) throws JSONException {
        // Crear un objeto JSON a partir de newData
        JSONObject newObject = new JSONObject(newData);

        // Agregar el nuevo objeto JSON a la lista
        dataList.add(newObject);

        // Limpiar los campos de texto
        txtTemperatura.setText("");
        txtHumedad.setText("");

        // Obtener el primer objeto JSON de la lista
        JSONObject primerObjeto = dataList.get(0);

        // Obtener los valores de humedad, temperatura e índice del primer objeto
        double humedad = primerObjeto.getDouble("humedad");
        double temperatura = primerObjeto.getDouble("temperatura");
        double indice = primerObjeto.getDouble("indice");

        // Mostrar los valores en los campos de texto
        txtHumedad.append(String.valueOf(humedad));
        txtTemperatura.append(String.valueOf(temperatura));

        // Imprimir la lista para verificar los cambios
        System.out.println("Data: " + dataList);

        // Limpiar la lista para futuras actualizaciones
        dataList.clear();
    }





}
