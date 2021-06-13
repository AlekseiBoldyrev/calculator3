package ru.geekbrains.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/20354.otf");
//
//        //Вывод ресурсов в строки программно
//        TextView descriptionLanguage = findViewById(R.id.textVLang);
//        descriptionLanguage.setTypeface(tf);
//        descriptionLanguage.setText(getString(R.string.descriptionLanguage));
//
//
//        TextView textLanguage = findViewById(R.id.textLang);
//        textLanguage.setTypeface(tf);
//        textLanguage.setText(getResources().getString(R.string.language));
        initList ();

    }
    private void initList () {
        LinearLayout layoutList = findViewById(R.id.layoutList);
        String[] versions = getResources().getStringArray(R.array.version_names);

        // При помощи этого объекта будем надувать элементы, спрятанные в android_item.xml
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < versions.length; i++) {
            String version = versions[i];
            // Достаём элемент из android_item.xml
            View item = ltInflater.inflate(R.layout.android_item, layoutList, false);
            // Находим в этом элементе TextView
            TextView tv = item.findViewById(R.id.textAndroid);
            tv.setText(version);

            // Получить из ресурсов массив указателей на изображения
            TypedArray imgs = getResources().obtainTypedArray(R.array.version_logos);

            // Выбрать по индексу подходящее изображение
            AppCompatImageView imgLogo = item.findViewById(R.id.imageAndroid);
            imgLogo.setImageResource(imgs.getResourceId(i, -1));

            layoutList.addView(item);
        }


    }
}
