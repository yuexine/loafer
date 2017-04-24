package loafer.web.models;

import lombok.Data;

/**
 * Created by w on 2017/4/24.
 */
@Data
public class Result {

    private Boolean success = true;

    private Object body;

    private Object errMsg;

    public Result(Boolean success, Object body) {
        this.success = success;
        this.body = body;
    }

    public Result(Boolean success) {
        this.success = success;
    }
}
