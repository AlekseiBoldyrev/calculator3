package ru.geekbrains.notes;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Note implements Parcelable {



    private String titleNote;
    private String textNote;
    private String dateNote;


    protected Note(Parcel in) {
        titleNote = in.readString();
        textNote = in.readString();
    }

    @Override
    public String toString() {
        return titleNote + '\'' + dateNote;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleNote);
        dest.writeString(textNote);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };




    public Note(String titleNote, String textNote) {
        this.titleNote = titleNote;
        this.textNote = textNote;
        this.dateNote = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
    }




    public String getTitleNote() {
        return titleNote;
    }

    public String getTextNote() {
        return textNote;
    }


    public void setTitleNote(String nameNote) {
        this.titleNote = nameNote;
    }


    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }





}
