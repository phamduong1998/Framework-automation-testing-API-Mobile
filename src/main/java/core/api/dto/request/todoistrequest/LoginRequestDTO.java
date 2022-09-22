package core.api.dto.request.todoistrequest;
import com.google.gson.annotations.SerializedName;
import core.api.dto.request.Request;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDTO implements Request {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;
}
