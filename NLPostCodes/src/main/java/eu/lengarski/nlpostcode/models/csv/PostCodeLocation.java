package eu.lengarski.nlpostcode.models.csv;

import com.opencsv.bean.CsvBindByName;

public class PostCodeLocation {

    @CsvBindByName(column = "PostcodeID")
    private Long postCodeId;

    @CsvBindByName(column = "PostCode")
    private String postCode;

    @CsvBindByName(column = "Latitude")
    private Double latitude;

    @CsvBindByName(column = "Longitude")
    private Double longitude;

    public PostCodeLocation(Long postCodeId, String postCode, Double latitude, Double longitude) {
        this.postCodeId = postCodeId;
        this.postCode = postCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getPostCodeId() {
        return postCodeId;
    }

    public void setPostCodeId(Long postCodeId) {
        this.postCodeId = postCodeId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
