package raihan.bs23.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/21/2017.
 */
public class BaseResponse {
    private int responseCode;
    private List<String> errors;

    public BaseResponse(){errors = new ArrayList<String>();}

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
