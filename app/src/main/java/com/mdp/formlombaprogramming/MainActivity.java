package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etNoWhatsapp, etAlamat, etPassword, etPin;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbJenisKelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNoWhatsapp = findViewById(R.id.et_no_whatsapp);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);

        rgJenisKelamin = findViewById(R.id.rg_jk);

        btnDaftar = findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String nowhatsapp = etNoWhatsapp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();


                int jeniskelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(jeniskelaminID);

                String jeniskelamin = rbJenisKelamin.getText().toString();

                if(nama.trim().equals(""))
                {
                    etNama.setError("Nama Tidak Boleh Kosong !");
                }
                else if(nowhatsapp.trim().equals(""))
                {
                    etNoWhatsapp.setError("Nomor Whatsapp Tidak Boleh Kosong !");
                }
                else if(alamat.trim().isEmpty())
                {
                    etAlamat.setError("Alamat Tidak Boleh Kosong !");
                }
                else if(password.trim().isEmpty())
                {
                    etPassword.setError("Password Tidak Boleh Kosong !");
                }
                else if(pin.trim().isEmpty())
                {
                    etPin.setError("Pin Tidak Boleh Kosong !");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNoWhatsapp", nowhatsapp);
                    intent.putExtra("varAlamat", alamat);
                    intent.putExtra("varJenisKelamin", jeniskelamin);
                    startActivity(intent);
                }

            }
        });
    }

    // Method untuk mengosongkan edittext dan segala text
    // alt + insert
    // CTRL + O
    // Pilih onResume();

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etNoWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
        etNama.requestFocus();
    }
}