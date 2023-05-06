package me.elvira.sockswarehouseapp.model;

import java.util.Objects;

public class Sock {

    private final Size size;
    private final Color color;
    private final int cottonPercentage;

    public Sock(Size size,
                Color color,
                int cottonPercentage){
        this.size = size;
        this.color = color;
        this.cottonPercentage = cottonPercentage;
        }

    public Size getSize() {   return size;  }

    public Color getColor() {  return color; }

    public int getCottonPercentage() {return cottonPercentage;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return cottonPercentage == sock.cottonPercentage && size == sock.size && color == sock.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, cottonPercentage);
    }
}


