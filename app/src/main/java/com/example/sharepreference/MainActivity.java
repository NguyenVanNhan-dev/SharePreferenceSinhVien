package com.example.sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnXacNhan;
    EditText editID,editName,editClass;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Anhxa();
        sharedPreferences = getSharedPreferences("datalogin",MODE_PRIVATE);
        editID.setText(sharedPreferences.getString("Masinhvien",""));
        editName.setText(sharedPreferences.getString("Tensinhvien",""));
        editClass.setText(sharedPreferences.getString("Lopsinhvien",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked",false));
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = editID.getText().toString().trim();
                String username = editName.getText().toString().trim();
                String lop = editClass.getText().toString().trim();
                    if (masv.equals("22115053122126") && username.equals("Nguyen Van Nhan") && lop.equals("124LTTD03") ){
                        Toast.makeText(MainActivity.this,"Luu thành công",Toast.LENGTH_SHORT).show();
                        if(cbRemember.isChecked()){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("Masinhvien",masv);
                            editor.putString("Tensinhvien",username);
                            editor.putString("Lopsinhvien",lop);
                            editor.putBoolean("checked",true);
                            editor.commit();
                        }else {
                            SharedPreferences. Editor editor = sharedPreferences.edit();
                            editor.putString("Masinhvien",masv);
                            editor.putString("Tensinhvien",username);
                            editor.putString("Lopsinhvien",lop);
                            editor.commit();
                        }

                    }else {
                        Toast.makeText(MainActivity.this, "Lỗi đăng nhap ", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }

    private void Anhxa() {
        btnXacNhan= (Button) findViewById(R.id.btnSave);
        editName =(EditText) findViewById((R.id.edtid));
        editName = (EditText) findViewById((R.id.edtname));
        editClass = (EditText) findViewById((R.id.edtclass));
        cbRemember =(CheckBox) findViewById((R.id.checkBox));
    }
}