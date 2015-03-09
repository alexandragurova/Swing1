package com.alexandragurova.swing1.gui;

/**
 * Created by Gurova on 09.03.2015.
 */
public class Utils {
    public static String getFileExtension(String name){
        int extIndex = name.lastIndexOf(".");

        if (extIndex == -1){
            return null;
        }

        if (extIndex == name.length()-1){
            return null;
        }

        return name.substring(extIndex+1, name.length());
    }
}
