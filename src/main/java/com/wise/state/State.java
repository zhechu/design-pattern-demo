package com.wise.state;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * 状态节点
 * 维护状态编码，以及该状态下可支持的动作
 */
public class State {

    /** 状态编码 */
    private String stateCode;

    /**
     * 当前状态下可允许执行的动作，状态与行为的关系：一对多
     */
    private Map<String, List<Transition>> transitionMap = new HashMap<>();

    public State(String stateCode, Transition... transitions) {
        this.stateCode = stateCode;
        for (Transition transition : transitions) {
            this.addTransition(transition);
        }
    }

    public String getStateCode() {
        return stateCode;
    }

    public List<Transition> getTransitions(String eventCode) {
        List<Transition> transitionList = transitionMap.get(eventCode);
        if (transitionList == null) {
            return Collections.emptyList();
        }

        // 防止外界修改
        return new ArrayList<>(transitionList);
    }

    /**
     * 添加动作
     * @param transition
     */
    public void addTransition(Transition transition) {
        List<Transition> transitionList = transitionMap.get(transition.getEventCode());
        if (CollectionUtils.isEmpty(transitionList)) {
            transitionList = new ArrayList<>();
            transitionMap.put(transition.getEventCode(), transitionList);
        }

        transitionList.add(transition);
    }
    
    @Override
    public String toString() {
        return stateCode;
    }

}