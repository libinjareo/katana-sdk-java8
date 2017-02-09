package com.katana.common.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by juan on 30/09/16.
 */
public class Logger {

    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int DEBUG = 4;

    private static boolean isActive;

    private Logger() {

    }

    /**
     *
     */
    public static void activate() {
        isActive = true;
    }

    /**
     * @param message
     */
    public static void log(int type, String message) {
        if (isActive) {
            logToStdout(getLog(type, message));
//            logToFile(getLog(type, message));
        }
    }

    /**
     * @param e
     */
    public static void log(int type, Exception e) {
        log(type, e.getMessage());
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            log(type, stackTraceElement.toString());
        }
    }

    private static String getLog(int type, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return dateFormat.format(Calendar.getInstance().getTime()) + " [" + getType(type) + "] [SDK] " + message;
    }

    private static String getType(int type) {
        switch (type){
            case INFO:
                return "INFO";
            case WARNING:
                return "WARNING";
            case ERROR:
                return "ERROR";
            case DEBUG:
                return "DEBUG";
        }
        return "INFO";
    }

    private static void logToStdout(String message) {
        System.out.println(message);
    }

    private static void logToFile(String message) {
        String[] arrayLines = message.split("\n");
        Path file = Paths.get("katana-log.txt");
        try {
            Files.write(file, Arrays.asList(arrayLines), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}