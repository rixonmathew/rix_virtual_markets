package com.rixon.virtualmarket.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * This class is used for loading the string from json files.
 * User: rixon
 * Date: 13/8/13
 * Time: 4:58 PM
 */
public class TestUtil {

    public static String fileContentAsString(String configurationFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getFullPathForFile(configurationFileName)));
            String line = br.readLine();
            stringBuilder.append(line);
            while (line != null) {
                line = br.readLine();
                if (line != null)
                    stringBuilder.append(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return stringBuilder.toString();
    }


    private static String getFullPathForFile(String fileName) {
        URL fileURL = TestUtil.class.getResource(fileName);
        return fileURL.getPath();
    }

}
