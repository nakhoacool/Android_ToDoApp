package tdtu.finalproject.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText registerEmail, registerPassword, registerConfirmPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> {
            String email = registerEmail.getText().toString().trim();
            String password = registerPassword.getText().toString().trim();
            String confirmPassword = registerConfirmPassword.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                registerEmail.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                registerPassword.setError("Password is required");
                return;
            }
            if (TextUtils.isEmpty(confirmPassword)) {
                registerConfirmPassword.setError("Confirm password is required");
                return;
            }
            if (!password.equals(confirmPassword)) {
                registerConfirmPassword.setError("Password does not match");
                return;
            } else {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String error = task.getException().toString();
                        Toast.makeText(RegisterActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}