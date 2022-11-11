public class Rectangle implements ShapeI{
    private static final String shapeType = "Rectangle";
    private double length, width;

    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(double aLength, double aWidth) {
        this.setLength(aLength);
        this.setWidth(aWidth);
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double aLength) {
        if (aLength > 0)
            this.setLength(aLength);
        else
            this.setLength(1.0);
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double aWidth) {
        if (aWidth >= 0)
            this.setWidth(aWidth);
        else
            this.setWidth(0.0);
    }

    @Override
    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    @Override
    public String toString() {
        return "Rectangle"
                + " Length " + length
                + " Width " + width
                + " Area " + getArea();
    }

    @Override
    public String getShapeType() {
        return Rectangle.shapeType;
    }
}
