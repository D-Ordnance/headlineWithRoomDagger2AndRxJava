package com.deeosoft.headlinewithrxjavaanddagger2.util;

import java.util.Objects;

public class Util {
    public static String formatErrorMessage(String msg){
        String error = "";
        if(Objects.equals(msg, "Unable to resolve host")){
            error = "Check your network connection and try again";
        }
        return error;
    }
}
