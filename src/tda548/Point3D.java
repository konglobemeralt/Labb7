package tda548;

public class Point3D {

    private double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D rotate(double xy_angle, double yz_angle) {
        double x1 = Rotate2D.getX(x,y,xy_angle);
        double y1 = Rotate2D.getY(x,y,xy_angle);
        double y2 = Rotate2D.getX(y1,z,yz_angle);
        double z2 = Rotate2D.getY(y1,z,yz_angle);
        return new Point3D(x1,y2,z2);
    }

    public Point3D translate(double dx, double dy, double dz) {
        return new Point3D(x + dx, y + dy, z + dz);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public String toString() {
        return "< Point3D x=" + x + " y=" + y + " z=" + z + " >";
    }

}
