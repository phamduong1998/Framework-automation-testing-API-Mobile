package core.api.dto.response;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProjectResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("order")
    private Integer order;

    @JsonProperty("color")
    private String color;

    @JsonProperty("is_shared")
    private Boolean isShared;

    @JsonProperty("is_favorite")
    private Boolean isFavorite;

    @JsonProperty("is_inbox_project")
    private Boolean isInboxProject;

    @JsonProperty("is_team_inbox")
    private Boolean isTeamInbox;

    @JsonProperty("view_style")
    private String viewStyle;

    @JsonProperty("url")
    private String url;

    @JsonProperty("parent_id")
    private Object parentId;

    @JsonProperty("content")
    private String content;
}
