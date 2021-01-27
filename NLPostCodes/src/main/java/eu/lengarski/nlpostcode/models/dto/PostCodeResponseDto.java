package eu.lengarski.nlpostcode.models.dto;

public class PostCodeResponseDto {

    private String statusMsg;
    private PostCodeDto postCode;

    public PostCodeResponseDto() {
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public PostCodeDto getPostCode() {
        return postCode;
    }

    public void setPostCode(PostCodeDto postCode) {
        this.postCode = postCode;
    }
}
