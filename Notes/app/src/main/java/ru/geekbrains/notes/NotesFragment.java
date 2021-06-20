package ru.geekbrains.notes;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static androidx.core.app.ActivityCompat.recreate;


public class NotesFragment extends Fragment {


    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    // вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initList(view);


    }


    private void initList(View view) {

        int backgroundColorNote = 0;
        LinearLayout layoutView = (LinearLayout) view;

    //перебираем Список заметок и выводим на экран их заголовки
        for (Note note : NotesList.getNotesList()) {

            TextView tv = new TextView(getContext());
            tv.setText(note.toString());
            tv.setTextSize(20);
            if (backgroundColorNote % 2 > 0) {
                tv.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else {
                tv.setBackgroundColor(Color.parseColor("#FFFFF0"));
            }
            tv.setHeight(240);
            layoutView.addView(tv);
            backgroundColorNote++;
        }
    }


}






