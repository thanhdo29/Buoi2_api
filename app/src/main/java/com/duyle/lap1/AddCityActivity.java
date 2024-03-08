package com.duyle.lap1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCityActivity extends AppCompatActivity {
    private EditText etCityName, etState, etCountry, etPopulation;
    private Button btnAddCity;
    FirebaseFirestore db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        etCityName = findViewById(R.id.edtCityName);
        etState = findViewById(R.id.edtState);
        etCountry = findViewById(R.id.edtCountry);
        etPopulation = findViewById(R.id.edtPopulation);
        btnAddCity = findViewById(R.id.btnAddCity);

        db=FirebaseFirestore.getInstance();

        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = etCityName.getText().toString().trim();
                String state = etState.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String populationStr = etPopulation.getText().toString().trim();

                if (!cityName.isEmpty() && !state.isEmpty() && !country.isEmpty() && !populationStr.isEmpty()) {
                    int population = Integer.parseInt(populationStr);

                    Map<String, Object> cityData = new HashMap<>();
                    cityData.put("name", cityName);
                    cityData.put("state", state);
                    cityData.put("country", country);
                    cityData.put("population", population);

                    db.collection("cities")
                            .add(cityData)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AddCityActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(AddCityActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(AddCityActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
