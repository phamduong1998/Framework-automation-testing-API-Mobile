package core.api.dto.response;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewTaskResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("description")
    private String description;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("is_completed")
    private Boolean isCompleted;

    @JsonProperty("order")
    private Integer order;

    @JsonProperty("priority")
    private Integer priority;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("labels")
    private List<Object> labels = null;

    @JsonProperty("due")
    private Object due;

    @JsonProperty("section_id")
    private Object sectionId;

    @JsonProperty("parent_id")
    private Object parentId;

    @JsonProperty("creator_id")
    private Integer creatorId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("assignee_id")
    private Object assigneeId;

    @JsonProperty("assigner_id")
    private Object assignerId;

    @JsonProperty("url")
    private String url;
}
