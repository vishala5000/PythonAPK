package com.example.pythonapp;

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

        textView.setText(
                "Python APK\n\n" +
                "Python runtime started successfully."
        );

        textView.setTextSize(22);

        setContentView(textView);

        Python python = Python.getInstance();

        PyObject module = python.getModule("app");

        PyObject result = module.callAttr("main");

        System.out.println("Python result: " + result);
    }
}
