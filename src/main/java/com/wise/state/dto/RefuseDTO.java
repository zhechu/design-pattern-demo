package com.wise.state.dto;

import lombok.Data;

/**
 * 审核拒绝业务参数
 */
@Data
public class RefuseDTO {

    /** 内容ID */
    private String contentId;

    /** 拒绝理由 */
    private String reason;

}
