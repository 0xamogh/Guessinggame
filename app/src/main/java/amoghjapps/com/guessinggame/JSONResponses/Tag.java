
package amoghjapps.com.guessinggame.JSONResponses;

import java.util.HashMap;
import java.util.Map;

public class Tag {

    private Double confidence;
    private Tag_ tag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Tag_ getTag() {
        return tag;
    }

    public void setTag(Tag_ tag) {
        this.tag = tag;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);

    }

}
