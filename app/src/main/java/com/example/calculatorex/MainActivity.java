package com.example.calculatorex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC,
                    btnDel, btnPlus, btnMinus, btnMulti, btnDot, btnEquals, btnDivide;
    private TextView textViewResult, textViewHistory;
    private String number = null;
    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.btnDot);
        btnEquals = findViewById(R.id.btnEquals);

        btnPlus = findViewById(R.id.btnPlus);
        btnMulti = findViewById(R.id.btnMulti);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator)
                {
                    if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void numberClick(String view)
    {
        if (number == null)
        {
            number = view;
        }
        else
        {
            number = number + view;
        }

        textViewResult.setText(number);
        operator = true;
    }

    public void plus()
    {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textViewResult.setText(""+firstNumber);
    }

    public void minus()
    {
        if (firstNumber == 0)
        {
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        textViewResult.setText(""+firstNumber);
    }

    public void multiply()
    {
        if (firstNumber == 0)
        {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }

        textViewResult.setText(""+firstNumber);
    }

    public void divide()
    {
        if (firstNumber == 0)
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }

        textViewResult.setText(""+firstNumber);
    }
}