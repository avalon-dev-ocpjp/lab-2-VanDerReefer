package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

public class FileRenameAction implements Action {
    private File renamedFile;
    private String newName;

    public FileRenameAction(File renamedFile, String newName) {
        this.renamedFile = renamedFile;
        this.newName = newName;
    }

    public synchronized void renameFile (){
        renamedFile.renameTo(new File((String)renamedFile.getParent()+"\\"+newName));
    }

    @Override
    public void run() {
        renameFile();
    }

    @Override
    public void close() throws Exception {

    }
}