package loafer.web.models;

import lombok.Data;

/**
 * Created by w on 2017/4/24.
 */
@Data
public class ResultModel {

    private Boolean success = true;

    private Object body;

    private Object errMsg;

    public ResultModel(Boolean success, Object body) {
        this.success = success;
        this.body = body;
    }

    public ResultModel(Boolean success) {
        this.success = success;
    }

    public ResultModel(Object body) {
        this.body = body;
    }

    public ResultModel() {
    }
}
