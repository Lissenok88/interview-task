package org.example;

import org.example.services.DataService;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        Object convertedData = new DataService().getConvertedData();
        
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        
        out.println(convertedData);
    }
}