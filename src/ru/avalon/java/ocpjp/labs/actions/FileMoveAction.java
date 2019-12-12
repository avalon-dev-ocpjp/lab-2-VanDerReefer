package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    
    private File movedFile;
    private String newDir;

    public FileMoveAction(File movedFile, String newDir) {
        this.movedFile = movedFile;
        this.newDir=newDir;
    }

    public synchronized void moveFile() {
        movedFile.renameTo(new File(newDir, movedFile.getName()));
    }
    
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        moveFile();
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        
       service.shutdown();
    }

}