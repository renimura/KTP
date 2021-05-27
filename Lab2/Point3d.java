package com.company;

class Point3d extends Point2d{
    private double zCord;

    /**Конструкторы **/
    public Point3d(double xCord, double yCord, double zCord) {
        super(xCord, yCord);
        this.zCord = zCord;
    }

    public Point3d() {
        this(0,0,0);
    }

    /**Гетеры**/
    public double getZ() {
        return zCord;
    }

    /**Сетеры**/
    public void setZ(double zCord) {
        this.zCord = zCord;
    }


    /**Сравнивает значения точек**/
    public boolean rav(Point3d point){
        return point.getX() == this.xCoord && point.getY() == this.yCoord && point.getZ() == this.zCord;
    }
    /**Находит расстояние между точками**/
    public double distanceTo(Point3d point){
        double x1 = xCoord;
        double y1 = yCoord;
        double z1 = zCord;
        double x2 = point.getX();
        double y2 = point.getY();
        double z2 = point.getZ();

        double result = Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) + Math.pow(z1-z2, 2),0.5);
        return (double)(Math.round(result * 100)) / 100;
    }



}
