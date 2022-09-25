package core.api.dto.response;

import core.api.dto.response.data.DueData;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTasksActiveResponse {

    @JsonProperty("creator_id")
    private String creatorId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("assignee_id")
    private String assigneeId;

    @JsonProperty("assigner_id")
    private String assignerId;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("is_completed")
    private Boolean isCompleted;

    @JsonProperty("content")
    private String content;

    @JsonProperty("description")
    private String description;

    @JsonProperty("due")
    private DueData due;

    @JsonProperty("id")
    private String id;

    @JsonProperty("labels")
    private List<String> labels = null;

    @JsonProperty("order")
    private Integer order;

    @JsonProperty("priority")
    private Integer priority;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("section_id")
    private String sectionId;

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("url")
    private String url;
}
