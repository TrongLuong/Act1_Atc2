package com.example.act1_atc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TONG = 0;
    public static final int HIEU = 0;
    public static final int Tinh = 0;


    Button sendata;
    TextView tTin;
    EditText tuoi, ten;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendata = (Button) findViewById(R.id.buttonMain);
        tTin = (TextView) findViewById(R.id.textView_tt);
        tuoi = (EditText) findViewById(R.id.editText_tuoi);
        ten = (EditText) findViewById(R.id.editText_name);

        sendata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //khai báo intent để gọi qua màng hình 2
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //truyền kiểu Bundle
                Bundle b = new Bundle();
                //đưa dữ liệu vào hộp
                b.putString("so1", ten.getText().toString());
                b.putString("so2", tuoi.getText().toString());
                //bundel gói dữ liệu lại thành 1 hộp, r dùng extra gửi nó đi
                intent.putExtra("dulieu", b);

                //truyền intent

                startActivityForResult(intent,Tinh);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // requestCode là định danh khi gửi
        // resultCode là định danh của Activity khác gửi cho
        // Nếu b đang ở ChildActivity mà ấn nút Back thì data sẽ nhận giá trị rỗng
        // mà đã là giá trị rỗng thì đoạn code dưới sẽ bị lỗi ngay
        if (data == null) {
            return;
        }
        // lấy giá trị kết quả
        if(requestCode ==Tinh) {
            Bundle bundle = data.getBundleExtra("HCN");
            int kq = bundle.getInt("KetQua");
            // nếu dữ liệu trả về có định danh là TÔNg
            if (resultCode == TONG)
                tTin.setText("Tổng là: " + kq);
            else

                tTin.setText("Hiệu là: " + kq);

        }
    }

}
