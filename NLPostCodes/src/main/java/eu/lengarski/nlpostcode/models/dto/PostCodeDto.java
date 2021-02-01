package eu.lengarski.nlpostcode.models.dto;

import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;


public class PostCodeDto {

    private String postCode;
    private Double latitude;
    private Double longitude;

    public PostCodeDto() {

    }

    public PostCodeDto(PostCodeEntity entity) {
        this.postCode = entity.getPostCode();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
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
