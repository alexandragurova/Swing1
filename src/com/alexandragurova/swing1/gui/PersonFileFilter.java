package com.alexandragurova.swing1.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Gurova on 09.03.2015.
 */
public class PersonFileFilter extends FileFilter{
    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        String fileName = f.getName();
        String fileExtension = Utils.getFileExtension(fileName);

        if (fileExtension == null){
            return false;
        }

        if (fileExtension.equals("per")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Person Database Files (*.per)";
    }
}
