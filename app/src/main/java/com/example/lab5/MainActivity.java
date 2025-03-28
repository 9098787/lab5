package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим элементы на экране
        TextView tvName = findViewById(R.id.tvName);
        Button btnName = findViewById(R.id.btnName);

        // Устанавливаем обработчик на кнопку
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Открываем NameActivity при клике на кнопку
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivityForResult(intent, REQUEST_CODE); // Запускаем активити с ожиданием результата
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) { // Проверяем, что это наш запрос
            if (resultCode == RESULT_OK) { // Если результат успешный
                // Получаем данные, переданные из NameActivity
                String result = data.getStringExtra("result");
                TextView tvName = findViewById(R.id.tvName);
                tvName.setText(result); // Обновляем TextView
                Toast.makeText(this, "Returned: " + result, Toast.LENGTH_SHORT).show(); // Показываем результат
            }
        }
    }
}
