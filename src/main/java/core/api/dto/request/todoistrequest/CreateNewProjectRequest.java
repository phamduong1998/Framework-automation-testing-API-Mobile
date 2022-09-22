package core.api.dto.request.todoistrequest;

import com.google.gson.annotations.SerializedName;
import core.api.dto.request.Request;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNewProjectRequest implements Request {
    @SerializedName("name")
    private String name;
}
