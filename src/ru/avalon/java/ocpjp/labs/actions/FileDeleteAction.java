/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

public class FileDeleteAction implements Action {

    private File deleted;

    public FileDeleteAction(File deleted) {
        this.deleted = deleted;
    }

    public synchronized void deleteFile(){
        deleted.delete();
    }

    @Override
    public void run() {
        deleteFile();
    }

    @Override
    public void close() throws Exception {

    }
}