public class Task {
    private Point point1;
    private Point point2;
    private Integer firstIndex;
    private Integer secondIndex;

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(Integer firstIndex) {
        this.firstIndex = firstIndex;
    }


    public Integer getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(Integer secondIndex) {
        this.secondIndex = secondIndex;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint1() {
        return point1;
    }


    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint2() {
        return point2;
    }

    public Result calculateDistance() {
        double xdistance = point1.getxValue()-point2.getxValue();
        double ydistance = point1.getyValue()-point2.getyValue();

        double distance =  Math.sqrt(Math.pow(xdistance,2)+Math.pow(ydistance,2));
        return new Result(distance,firstIndex,secondIndex);
    }
}