package com.example.gztruyen.CommonUltil;

public class StaticCode {
    private static StaticCode instance;
    public static StaticCode getInstance(){
        if(instance == null)
            instance = new StaticCode();
        return instance;
    }
    private final String CHAPTER_KEY = "chapter";
    public static String COMIC = "TruyenTranh";
    public  static String STORY = "TruyenChu";
    public static String TYPE_KEY = "type";
    public static String TOKEN = "token";
    public static String PREF = "myPrefs";
    public static String USERNAME = "username";

    public String getCHAPTER_KEY() {
        return CHAPTER_KEY;
    }
}
