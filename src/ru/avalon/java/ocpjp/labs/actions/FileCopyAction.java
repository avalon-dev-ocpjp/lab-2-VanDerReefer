package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    
    // источник
    private File source;
    // назначение
    private File destination;

    // конструктор по умолчанию
    public FileCopyAction(File source, File destination){
        this.source = source;
        this.destination = destination;

    }
    
    private synchronized void copyFile() throws IOException {

        try(InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }
    
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        
        try {
            copyFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (Exception ignore) {
            } finally {
                service.shutdownNow();
            }
        }
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        
        service.shutdown();
    }
}