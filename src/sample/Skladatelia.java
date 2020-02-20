package sample;

public class Skladatelia{
    int id;
    String name, song;

    public Skladatelia(int id, String name, String song) {
        this.id = id;
        this.name = name;
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {   return song; }

    public void setSong(String song) {
        this.song = song;
    }
}
