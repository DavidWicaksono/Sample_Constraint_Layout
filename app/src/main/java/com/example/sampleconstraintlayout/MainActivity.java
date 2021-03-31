package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    String correct_edemail = "admin@gmail.com";
    String correct_edpassword = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //validasi input
                if (TextUtils.isEmpty(edemail.getText().toString()) || TextUtils.isEmpty(edpassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Email dan Password Salah", Toast.LENGTH_LONG).show();
                } else if (edemail.getText().toString().equals(correct_edemail)) {
                    //check password
                    if (edpassword.getText().toString().equals(correct_edpassword)) {
                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_LONG).show();
                }

                if (nama.equals(email) && password.equals(pass)) {
                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                    //Membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel password dengan kunci "b"
                    //dan masukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"\
                    //dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah actiity dari mainactivity ke HomeActivity
                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasi
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);
                } else {
                    //membuat variabel toast dan membuat toast dan menampilkan pesan "Login gagal

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Gagal", Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                }
            }
        });
    }
}