package com.correction.backend.modules.flow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
@TableName("flow_center_node_relation")
public class FlowNodeRelation implements Serializable {

    private String nodeId;

    private Long flowId;

}