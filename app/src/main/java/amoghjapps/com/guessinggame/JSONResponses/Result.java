
package amoghjapps.com.guessinggame.JSONResponses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private List<Tag> tags = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
