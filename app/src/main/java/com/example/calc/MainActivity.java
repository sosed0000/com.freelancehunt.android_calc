package com.example.calc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    // Змінні для вашого калькулятора
    private TextView resultTextView;
    private Button historyButton;
    private List<String> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        historyButton = findViewById(R.id.historyButton);
        history = new ArrayList<>();

        // Налаштування обробників подій для кнопок
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHistoryDialog();
            }
        });

        // Цифрові кнопки
        int[] numberButtonIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButtonClick(v);
                }
            });
        }

// Операційні кнопки
        int[] operationButtonIds = {R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonPower};

        for (int id : operationButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOperationButtonClick(v);
                }
            });
        }

// Кнопка очищення
        Button clearButton = findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClick();
            }
        });

// Кнопка знаку числа
        Button signButton = findViewById(R.id.buttonSign);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignButtonClick();
            }
        });

// Кнопка рівності
        Button equalButton = findViewById(R.id.buttonEqual);
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClick();
            }
        });

// Кнопки зміни системи числення
        Button binaryButton = findViewById(R.id.buttonBinary);
        binaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBinaryButtonClick();
            }
        });

        Button octalButton = findViewById(R.id.buttonOctal);
        octalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOctalButtonClick();
            }
        });

        Button hexButton = findViewById(R.id.buttonHex);
        hexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHexButtonClick();
            }
        });

    }

    private void showHistoryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Історія");

        View view = getLayoutInflater().inflate(R.layout.dialog_history, null);
        RecyclerView recyclerView = view.findViewById(R.id.historyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HistoryAdapter historyAdapter = new HistoryAdapter(history);
        recyclerView.setAdapter(historyAdapter);

        builder.setView(view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void onHexButtonClick() {

    }

    private void onOctalButtonClick() {

    }

    private void onBinaryButtonClick() {

    }

    private void onEqualButtonClick() {

    }

    private void onSignButtonClick() {
    }

    private void onClearButtonClick() {

    }

    private void onNumberButtonClick(View v) {
        // Ваш код для обробки натискання цифрових кнопок
    }

    private void onOperationButtonClick(View v) {
        // Ваш код для обробки натискання кнопок операцій
    }

}