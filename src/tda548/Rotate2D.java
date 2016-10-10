package tda548;

class Rotate2D {
    // code is based on http://en.wikipedia.org/wiki/Rotation_matrix
    public static double getX(double x, double y, double angle) {
        return x * Math.cos(angle) - y * Math.sin(angle);
    }
    public static double getY(double x, double y, double angle) {
        return x * Math.sin(angle) + y * Math.cos(angle);
    }
}
