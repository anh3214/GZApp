package com.example.gztruyen.CommonUltil;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Common {
    private static Common c;

    public static Common getInstance() {
        if (c == null)
            c = new Common();
        return c;
    }

    public Boolean checkStringEmpty(String input) {
        try {
            input = input.trim();
            return input.isEmpty();
        } catch (NullPointerException ex) {
            return true;
        }
    }

    public void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public boolean checkIsLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(StaticCode.PREF, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(StaticCode.TOKEN, null);
        return !checkStringEmpty(value);
    }

    public void logout(Context context) {
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences(StaticCode.PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(StaticCode.TOKEN);
        editor.commit();
    }

    public Object getDataFromPref(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(StaticCode.PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }
}
