package questionanswer.Storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties ("storage")

public class StorageProperties {
    private String location = "D://example (2)//questionanswer//src//main//java//questionanswer//Storage";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
