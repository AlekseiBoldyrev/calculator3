package ru.geekbrains.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class NotesList implements Parcelable {

    private static ArrayList<Note> notesList = new ArrayList<Note>();

    public NotesList (){

    }

    protected NotesList(Parcel in) {
    }

    public static final Creator<NotesList> CREATOR = new Creator<NotesList>() {
        @Override
        public NotesList createFromParcel(Parcel in) {
            return new NotesList(in);
        }

        @Override
        public NotesList[] newArray(int size) {
            return new NotesList[size];
        }
    };

    public static void add(Note note){

        notesList.add(note);
    }

    public static ArrayList<Note> getNotesList() {
        return notesList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
