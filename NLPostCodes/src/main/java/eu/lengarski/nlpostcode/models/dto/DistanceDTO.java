package eu.lengarski.nlpostcode.models.dto;

public class DistanceDTO {

    private PostCodeDto startLocation;
    private PostCodeDto endLocation;
    private Double distance;
    private String unit = "km";

    public DistanceDTO() {

    }

    public PostCodeDto getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(PostCodeDto startLocation) {
        this.startLocation = startLocation;
    }

    public PostCodeDto getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(PostCodeDto endLocation) {
        this.endLocation = endLocation;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }


//    a. The postcode and the coordinates of both locations.
//    b. The distance between the two locations in kilometers.
//    c. A fixed string “unit” that has the value "km".
}
