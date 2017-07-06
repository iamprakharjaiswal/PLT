package com.example.gauravpc.plt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class a1 extends AppCompatActivity {

    String input;
    public final static String INP = "abc";
    public EditText inputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        inputEditText = (EditText)findViewById(R.id.inputEditText);
    }
    public void generatePostFixExpression(View view)
    { input = inputEditText.getText().toString();
        Intent i = new Intent(this,PostFix.class);
        i.putExtra(INP, input);
        startActivity(i);


    }
    public void generateSyntaxTree(View view)
    { input = inputEditText.getText().toString();
        Intent i = new Intent(this,SyntaxTree.class);
        i.putExtra(INP,input);
        startActivity(i);


    }
    public void g3ac(View view){
        input = inputEditText.getText().toString();
        Intent i = new Intent(this,rest.class);
        i.putExtra(INP, input);
        startActivity(i);
    }

}

