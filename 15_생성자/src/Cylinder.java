public class Cylinder {
    private int radius;
    private int height;

    public double getRadius() {
        return (double)this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return (double)this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return 3.14*this.getRadius()*this.getRadius()*this.getHeight();
    }

    public double getArea() {
        return 3.14*this.getRadius()*this.getRadius()*2 + 2*3.14*this.getRadius()*this.getHeight();
    }
}
