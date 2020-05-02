package com.wise.state.dto;

import lombok.Data;

/**
 * 下架业务参数
 */
@Data
public class DownDTO {

    /** 内容ID */
    private String contentId;

    /** 拒绝理由 */
    private String reason;

}
