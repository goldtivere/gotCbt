package got.cbtproject.gotcbt.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    public static final String NOT_FOUND = "Not found";
    public static final String OK = "Ok";

    private String responseStatus;
    private Object response;


    public Response() {
    }

}
