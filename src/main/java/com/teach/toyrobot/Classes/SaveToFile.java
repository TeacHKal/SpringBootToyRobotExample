package com.teach.toyrobot.Classes;

import com.teach.toyrobot.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SaveToFile {

    @Autowired
    public SaveToFile() { }

    public void save(String content) throws IOException {
        final String csvFile = AppSettings.SAVE_DIR_PATH + "\\Results.csv";
        boolean fileExist = false;
        File file = new File(csvFile);
        if(file.exists()) {fileExist = true; }

        FileWriter fileWriter = new FileWriter(csvFile, true);
        if(fileExist){ fileWriter.append(System.getProperty("line.separator")); }
        fileWriter.append(content);
        fileWriter.flush();
        fileWriter.close();
    }
}

