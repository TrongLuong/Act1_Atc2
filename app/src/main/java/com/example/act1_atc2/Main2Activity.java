package com.example.act1_atc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txtkq;
    Button cong, tru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtkq = (TextView) findViewById(R.id.textView2);
        cong = (Button) findViewById(R.id.button_cong);
        tru = (Button) findViewById(R.id.button_tru);

        //nhận dữ liệu extra
        Intent intent = getIntent();
        //nhận kiểu extra
        // String s = intent.getStringExtra("dl");

        //nhận kiểu bulde
        Bundle b2 = intent.getBundleExtra("dulieu");
        final String s1 = b2.getString("so1");
        final String s2 = b2.getString("so2");
        txtkq.setText("Đã nhận dữ liệu " + s1 + " và " + s2);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s01 = Integer.parseInt(s1);
                int s02 = Integer.parseInt(s2);
                int tong = s01 + s02;
                sendToMain(tong, MainActivity.TONG);
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s01 = Integer.parseInt(s1);
                int s02 = Integer.parseInt(s2);
                int hieu = s01 - s02;
                sendToMain(hieu, MainActivity.HIEU);
            }
        });
    }

    public void sendToMain(int value, int resultcode) {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putInt("KetQua", value);
        intent.putExtra("HCN", bundle);
        setResult(resultcode, intent); // phương thức này sẽ trả kết quả cho Activity1
        finish(); // Đóng Activity hiện tại
    }
}
