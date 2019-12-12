package ru.avalon.java.ocpjp.labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.actions.FileRenameAction;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче
 * сертификационных экзаменов серии Oracle Certified
 * Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Main().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    
    File source;
    File destination;
    File movedFile;
      
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                System.out.println("Enter the path of the file to be copied");
                String sourceFile = in.readLine();
                System.out.println("Enter where to copy the file");
                String destinationFile = in.readLine();
                
                source = new File (sourceFile);
                destination = new File (destinationFile);
                
                new FileCopyAction(source, destination).start();
                
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                
                System.out.println("What to move? Enter file with all path. ");
                String moveFile = in.readLine();
                System.out.println("Enter path to destination moved file");
                String newDir = in.readLine();

                movedFile = new File (moveFile);
                
                new FileMoveAction(movedFile, newDir).start();
                
                break;
                
            case delete:
                
                System.out.println("What to delete? Enter file with all path. ");
                String deleteFile = in.readLine();

                source = new File (deleteFile);
                
                new FileDeleteAction(source).start();
                               
                break;
                
            case rename:
                
                System.out.println("What to rename? Enter file with all path. ");
                String renameFile = in.readLine();
                System.out.println("Enter new file name");
                String newName = in.readLine();

                source = new File (renameFile);
                
                new FileRenameAction(source, newName).start();
                        
                break;
                
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}