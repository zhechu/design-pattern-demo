package com.wise.state;

import java.util.*;

/**
 * 状态节点
 * 维护状态编码，以及该状态下可支持的动作
 */
public class State {

    /** 状态编码 */
    private String stateCode;

    /**
     * 当前状态下可允许执行的动作，状态与事件的关系：一对多，事件与行为的关系：一对一
     */
    private Map<String, Transition> transitionMap = new HashMap<>();

    public State(String stateCode, Transition... transitions) {
        this.stateCode = stateCode;
        for (Transition transition : transitions) {
            this.addTransition(transition);
        }
    }

    public String getStateCode() {
        return stateCode;
    }

    public Transition getTransition(String eventCode) {
        return transitionMap.get(eventCode);
    }

    /**
     * 添加动作
     * @param transition
     */
    public void addTransition(Transition transition) {
        transitionMap.put(transition.getEventCode(), transition);
    }
    
    @Override
    public String toString() {
        return stateCode;
    }

}