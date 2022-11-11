class Circle implements ShapeI {
    private double radius, area;
    private String shapeType;

    public Circle() {
        return;
    }

    public Circle(double r) {
        this.setRadius(r);

    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        if (r > 0)
            this.radius = r;
        else
            this.radius = 0;
    }

    @Override
    public double getArea() {
         this.area =(Math.PI * this.radius * this.radius);
         return this.area;
    }

    @Override
    public String toString() {
        return "Circle"
                + " Radius " + radius
                + " Area " + getArea();
    }

    @Override
    public String getShapeType() {
        return "Circle";
    }
}
