package likelion.srping.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse {

    private boolean isSuccess;
    HttpStatus status;
    private String msg;
    private Object object;

}
