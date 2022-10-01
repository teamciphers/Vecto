package com.example.vecto;

import android.os.Bundle;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class signup extends AppCompatActivity {


    private Button hp;
    EditText name, email_id, new_password, enrollment_no,phone_no;
    String Name1,email1,pass1,enrollment,phone;
    FirebaseDatabase rootnode;
    DatabaseReference reference,reference_alldata;
    FirebaseAuth mAuth;
    private UserHelperClass uhc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        hp = (Button) findViewById(R.id.btn_homepage);

        name = findViewById(R.id.name_signup_input);
        new_password = findViewById(R.id.password_signup_input);
        email_id = findViewById(R.id.email_id_signup_input);
        enrollment_no = findViewById(R.id.enrollment_signup_no_input);
        phone_no = findViewById(R.id.phone_signup_no_input);

        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                reference = rootnode.getReference("Users");
                reference_alldata = rootnode.getReference("All_data");
                Name1 = name.getText().toString();
                email1 = email_id.getText().toString();
                pass1 = new_password.getText().toString();
                enrollment  = enrollment_no.getText().toString();
                phone  = phone_no.getText().toString();

                if(Name1.isEmpty()) {
                    name.setError("Please set a user name");
                    name.requestFocus();
                } else if (email1.isEmpty()) {
                    email_id.setError("Please enter an email id");
                    email_id.requestFocus();
                }else if(pass1.isEmpty()) {
                    new_password.setError("Please set an password");
                    new_password.requestFocus();
                } else if(enrollment.isEmpty()) {
                    enrollment_no.setError("Please set an password");
                    enrollment_no.requestFocus();
                } else if(phone.isEmpty()) {
                    phone_no.setError("Please set an password");
                    phone_no.requestFocus();}
                else {
                    mAuth.createUserWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String uid = mAuth.getUid();
                                Toast.makeText(signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                uhc = new UserHelperClass(Name1, email1, pass1,uid, enrollment, phone);

                                openhomepage();


                            } else {
                                Toast.makeText(signup.this, "Could Not sign you Up", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
        private void openhomepage() {
            Intent i = new Intent(signup.this, HomePage.class);
            reference.child(mAuth.getUid()).setValue(uhc);
            reference_alldata.child(mAuth.getUid()).setValue(uhc);
            startActivity(i);
        }
}