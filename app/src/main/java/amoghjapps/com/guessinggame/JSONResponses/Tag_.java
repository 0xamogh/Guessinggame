
package amoghjapps.com.guessinggame.JSONResponses;

import java.util.HashMap;
import java.util.Map;

public class Tag_ {

    private String en;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
