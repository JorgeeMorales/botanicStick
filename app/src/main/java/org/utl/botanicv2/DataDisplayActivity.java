package org.utl.botanicv2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.utl.botanicv2.R;

public class DataDisplayActivity extends AppCompatActivity {

    private static DataDisplayActivity instance;
    private TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        instance = this;

        textViewData = findViewById(R.id.textViewData);

        if (getIntent().hasExtra("data")) {
            String receivedData = getIntent().getStringExtra("data");
            textViewData.append(receivedData + "\n");
        }
    }

    public static DataDisplayActivity getInstance() {
        return instance;
    }

    public void updateData(String newData) {
        textViewData.append(newData + "\n");
    }
}
