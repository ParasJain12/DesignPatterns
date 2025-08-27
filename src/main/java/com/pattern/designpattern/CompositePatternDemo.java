package com.pattern.designpattern;

import java.util.ArrayList;
import java.util.List;

interface FileComponent{
    void showDetails();
}

class File implements FileComponent{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File name: "+name);
    }
}

class Folder implements FileComponent{
    private String name;
    private List<FileComponent> components = new ArrayList<>();
    
    public Folder(String name){
        this.name = name;
    }
    
    public void addComponent(FileComponent component){
        components.add(component);
    }
    
    public void removeComponent(FileComponent component){
        components.remove(component);
    }
    
    @Override
    public void showDetails(){
        System.out.println("Folder name: "+name);
        for(FileComponent component:components){
            component.showDetails();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        File file1 = new File("Resume.docx");
        File file2 = new File("Photo.png");
        File file3 = new File("Notes.txt");
        
        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");
        Folder root = new Folder("root");
        
        documents.addComponent(file1);
        documents.addComponent(file3);
        
        pictures.addComponent(file2);
        
        root.addComponent(documents);
        root.addComponent(pictures);
            
        root.showDetails();
    }
}
