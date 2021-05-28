package com.company;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location() {
        this(0, 0);
    }

    public boolean equals(Object object) { //Сравнивает координаты (локации)
        if (object instanceof Location) { //Проверяет, является ли объект локацией
            Location other = (Location) object; //Создание другого объекта и его переопределение в тип локации
            if (xCoord == other.xCoord && yCoord == other.yCoord) { //Сравнение координат
                return true;
            }
        }
        return false;
    }

    public int hashCode() { //Предоставляет hashcode для каждой локации
        int result = 10; //Присвоение начального значения
        result = 20 * result + xCoord; //Расчет значения с учетом координат
        result = 20 * result + yCoord;
        return result;
    }
}
