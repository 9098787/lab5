package com.example.lab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        // Находим элементы на экране
        EditText etName = findViewById(R.id.etName);
        Button btnOK = findViewById(R.id.btnOK);

        // Устанавливаем обработчик для кнопки
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введённые данные
                String result = etName.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result); // Отправляем результат в MainActivity
                setResult(RESULT_OK, resultIntent); // Устанавливаем результат
                finish(); // Закрываем NameActivity
            }
        });
    }
}
