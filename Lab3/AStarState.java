package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    //Хэш-карта открытых вершин
    private HashMap<Location, Waypoint> openedWaypoints = new HashMap<Location, Waypoint> ();

    //Хэш-карта закрытых вершин
    private HashMap<Location, Waypoint> closedWaypoints = new HashMap<Location, Waypoint> ();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.
        if (numOpenWaypoints() == 0) //Проверка наличия открытых вершин в наборе
            return null;

        Set openedWaypointsKeys = openedWaypoints.keySet(); //Получение всех ключей, то есть открытых вершин
        Iterator i = openedWaypointsKeys.iterator(); //Итератор для перебора открытых значений вершин с парметром i
        Waypoint best = null;
        float bestValue = Float.MAX_VALUE;

        while (i.hasNext()) { //hasNext - метод интерфейса Iterator, который возвращает истину, если "итерация" имеет больше элементов, если элементов больше нет, она возвращает ложь и больше не будет входить в тело цикла while
            Location location = (Location)i.next(); //Сохранение текущей локации, next - получение следующего элемента
            Waypoint waypoint = openedWaypoints.get(location); //Сохранение текущей открытой вершины
            float bestValueTotal = waypoint.getTotalCost(); //Сохранение текущего значения открытой вершины
            if (bestValueTotal < bestValue) { //Сравнение текущего значения
                best = openedWaypoints.get(location);
                bestValue = bestValueTotal;
            }
        }
        return best;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        Location location = newWP.getLocation(); //Поиск локации новой вершины
        if (openedWaypoints.containsKey(location)) { //Проверка, есть ли уже вершина для данной локации
            Waypoint currentWaypoint = openedWaypoints.get(location); //Сохранение локации для данной вершины
            if (newWP.getPreviousCost() < currentWaypoint.getPreviousCost()) { //Сравнение значений путей
                openedWaypoints.put(location, newWP); //Добавление вершины
                return true;
            }
            return false;
        }
        openedWaypoints.put(location, newWP); //Добавление вершины, если нет вершин для данной локации
        return true;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
        return openedWaypoints.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        Waypoint waypoint = openedWaypoints.remove(loc); //Удаление
        closedWaypoints.put(loc, waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return closedWaypoints.containsKey(loc); //Проверка, встречаеся ли локация в закрытых вершинах
    }
}
