package ru.geekbrains.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    private EditText titleNote;
    private EditText textNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        initView();

        Button btnReturn = findViewById(R.id.ok);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotesList.add(createNote());
                Intent intentResult = new Intent();
                setResult(RESULT_OK, intentResult);

                finish();
            }
        });
    }

    private void initView() {
        titleNote = findViewById(R.id.titleNote);
        textNote = findViewById(R.id.textNote);

    }

    private Note createNote() {
        Note note = new Note(
                titleNote.getText().toString(),
                textNote.getText().toString());
        return note;
    }



}