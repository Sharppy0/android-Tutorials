package com.example.undo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    /**
    2 main Stacks 
    undoInt store the int  return&remove when undo Button is Clicked.
    undoKey - each int has a special Key. 
    */
    Stack<Integer> undoInt;
    Stack<Integer> undoKey;

    public static int text1Int = 0;
    public static int text2Int = 0;
    
    TextView text1;
    TextView text2;
    
    Button button1Increase;
    Button button1Decrease;
    Button Button2Increase;
    Button Button2Decrease;
    Button buttonUndo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        undoInt = new Stack<Integer>();
        undoKey = new Stack<Integer>();

          text1 = (TextView) findViewById(R.id.textView_1);
          text2 = (TextView) findViewById(R.id.textView_2);
          text3 = (TextView) findViewById(R.id.textView_undo);

        button1Increase = (Button) findViewById(R.id.button1_increase);
        button1Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoInt.push(text1Int);  // push var  into the stack
                undoKey.push(1);    // push key into the stack

                text1Int++;
                text1.setText("" + text1Int);
            }
        });

        button1Decrease = (Button) findViewById(R.id.button1_decrease);
        button1Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoInt.push(text1Int); 
                undoKey.push(1); 

                if(text1Int == 0) {
                    return;
                }else { text1Int--; }
                text1.setText("" + text1Int);
            }
        });

        Button2Increase = (Button) findViewById(R.id.button2_increase);
        Button2Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoInt.push(text2Int);
                undoKey.push(2);

                text2Int++;
                text2.setText("" + text2Int);
            }
        });

        Button2Decrease = (Button) findViewById(R.id.button2_decrease);
        Button2Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoInt.push(text2Int);
                undoKey.push(2);

                if(text2Int == 0) {
                    return;
                }else { text2Int --; }
                text2.setText("" + text2Int);
            }
        });


        buttonUndo = (Button) findViewById(R.id.button_undo);
        buttonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!undoInt.isEmpty()) { // checks if NOT undoInt Stack empty
                    if (undoKey.peek() == 1) { // checks if the undoKey first elements is equal to 1 without removing the key
                        undoKey.pop(); // remove the key
                        text1Int = (int) undoInt.pop(); // set integer to the stack element and remove from stack.
                        text1.setText("" + text1Int); // change the text
                    } else if (undoKey.peek() == 2) {
                        undoKey.pop();
                        text2Int = (int) undoInt.pop();
                        text2.setText("" + text2Int);
                    }
                }
            }
        });


    }


}
