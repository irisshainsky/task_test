public class Result {

    private Integer firstIndex;
    private Integer secondIndex;
    private Double result;

    public Result(Double result,Integer firstIndex,Integer secondIndex) {
        this.result = result;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public Integer getSecondIndex() {
        return secondIndex;
    }

    public Double getReuslt() {
        return result;
    }

}
