package com.login.gustavo.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuracao {

    public static Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
}
