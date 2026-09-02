package com.pythonapk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(30, 30, 30, 30);
        textView.setText("Starting Python...");

        setContentView(textView);

        runPython();
    }

    private void runPython() {
        try {
            Python python = Python.getInstance();

            PyObject app = python.getModule("app");

            PyObject result = app.callAttr("main");

            textView.setText(
                    result != null
                            ? result.toString()
                            : "Python finished successfully."
            );

        } catch (Exception e) {

            textView.setText(
                    "Python Error:\n\n" +
                    e.toString()
            );

            e.printStackTrace();
        }
    }
}
