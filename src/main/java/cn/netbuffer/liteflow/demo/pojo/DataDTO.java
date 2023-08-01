package cn.netbuffer.liteflow.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataDTO {
    public String payload;
    public String type;
}
