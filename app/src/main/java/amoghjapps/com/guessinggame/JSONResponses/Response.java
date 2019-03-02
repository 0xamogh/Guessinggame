
package amoghjapps.com.guessinggame.JSONResponses;

import java.util.HashMap;
import java.util.Map;

public class Response {

    private Result result;
    private String upload_id;


    public Response(String upload_id) {
        this.upload_id = upload_id;
    }
    public String getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(String upload_id) {
        this.upload_id = upload_id;
    }


    private Status status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
