package core.api.dto.response.data;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueData {

    @JsonProperty("date")
    private String date;

    @JsonProperty("is_recurring")
    private Boolean isRecurring;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("string")
    private String string;

    @JsonProperty("timezone")
    private String timezone;
}
