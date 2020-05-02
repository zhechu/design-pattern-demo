package com.wise.state;

import lombok.Getter;
import lombok.Setter;

/**
 * 触发的事件
 * 维护事件编码，以及事件附属的业务参数信息
 */
public abstract class Event<T> {
    
    /** 事件标识(编码) */
    @Getter
    private String eventCode;

    /** 附属的业务参数 */
    @Getter
    @Setter
    private T param;

    public Event(String eventCode) {
        this.eventCode = eventCode;
    }

    public Event(String eventCode, T param) {
        this.eventCode = eventCode;
        this.param = param;
    }

}