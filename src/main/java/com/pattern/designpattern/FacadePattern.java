package com.pattern.designpattern;

//Subsystem 1
class DVDPlayer{
    public void on(){
        System.out.println("DVD Player On");
    }
    
    public void play(String movie){
        System.out.println("Playing movie: "+movie);
    }
    
    public void off(){
        System.out.println("DVD Player Off");
    }
}

//Subsystem 2
class Projector{
    public void on(){
        System.out.println("Projector On");
    }
    
    public void wideScreenMode() {
        System.out.println("Projector in Widescreen mode");
    }
    
    public void off(){
        System.out.println("Projector Off");
    }
}

//Subsystem 3
class SoundSystem{
    public void on(){
        System.out.println("Sound System On");
    }
    
    public void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
    
    public void off(){
        System.out.println("Sound System Off");
    }
}

//Facade
class HomeTheaterFacade{
    
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }
    
    public void watchMovie(String movie){
        System.out.println("Get ready to watch a movie");
        projector.on();
        projector.wideScreenMode();
        sound.on(); 
        sound.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }
    
    public void endMovie(){
        System.out.println("Shutting down");
        dvd.off();
        sound.off();
        projector.off();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();
        
        HomeTheaterFacade facade = new HomeTheaterFacade(dvd,projector,sound);
        facade.watchMovie("Inception");
        facade.endMovie();
    }
}
