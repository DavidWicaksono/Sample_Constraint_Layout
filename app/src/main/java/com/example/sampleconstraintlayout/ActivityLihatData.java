package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {

    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "David":
                tvnama.setText("David w");
                tvnomor.setText("082222222222");
                break;
            case "Baba" :
                tvnama.setText("Baba b");
                tvnomor.setText("083333333333");
                break;
            case "Nana" :
                tvnama.setText("Nana n");
                tvnomor.setText("084444444444");
                break;
            case "Sasa" :
                tvnama.setText("Sasa s");
                tvnomor.setText("085555555555");
                break;
            case "Yana" :
                tvnama.setText("Yana y");
                tvnomor.setText("086666666666");
                break;
            case "Dapa" :
                tvnama.setText("Dapa d");
                tvnomor.setText("087777777777");
                break;
            case "Gaga" :
                tvnama.setText("Gaga g");
                tvnomor.setText("088888888888");
                break;
            case "Vava" :
                tvnama.setText("Vava v");
                tvnomor.setText("089999999999");
                break;
            case "Tata" :
                tvnama.setText("Tata t");
                tvnomor.setText("080000000000");
                break;
            case "Wawa" :
                tvnama.setText("Wawa w");
                tvnomor.setText("081212121212");
                break;
        }
    }
}