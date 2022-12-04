package com.example.workout;

public class Parser {
    public static String Parse_in(boolean situps, boolean radfahren, boolean beinheben, boolean seitliches_beinheben, boolean springen) {
        String workout = "";
        if (situps) {
            workout += "Situps, ";
        } else {
            workout += "0, ";
        }
        if (radfahren) {
            workout += "Radfahren, ";
        } else {
            workout += "0, ";
        }
        if (beinheben) {
            workout += "Beinheben, ";
        } else {
            workout += "0, ";
        }
        if (seitliches_beinheben) {
            workout += "SeitlichesBeinheben, ";
        } else {
            workout += "0, ";
        }
        if (springen) {
            workout += "Springen, ";
        } else {
            workout += "0, ";
        }
        return workout;
    }

    public static String[] Parse_out(String workout) {
        String[] workout_array = workout.split(", ");
        return workout_array;
    }
}
