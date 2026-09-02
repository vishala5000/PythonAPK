package com.pythonapk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);

        textView.setText("Starting Python...");
        textView.setTextSize(22);

        setContentView(textView);

        try {
            Python python = Python.getInstance();

            PyObject module = python.getModule("app");

            PyObject result = module.callAttr("main");

            textView.setText(String.valueOf(result));

        } catch (Exception e) {

            textView.setText(
                    "Python Error:\n\n" +
                    e.getMessage()
            );

            e.printStackTrace();
        }
    }
}
