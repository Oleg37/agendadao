package es.miapp.ad.agendasimple;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgendaApplication extends Application {

    private static final int NUM_HILOS = Runtime.getRuntime().availableProcessors();

    public static final ExecutorService threadExecutor = Executors.newFixedThreadPool(NUM_HILOS);
}
