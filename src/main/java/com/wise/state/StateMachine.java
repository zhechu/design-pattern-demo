package com.wise.state;

import java.util.List;
import java.util.Map;

/**
 * 状态机基类
 * 维护该状态机所有支持的状态，以及调用入口
 */
public abstract class StateMachine {

    /** 定义的所有状态 */
    private static Map<String, State> allStateMap = null;

    /**
     * 状态机执行事件
     * @param state
     * @param event
     * @return
     */
    public State execute(State state, Event event) {
        List<Transition> transitionList = state.getTransitions(event.getEventCode());
        for (Transition transition : transitionList) {
            return transition.execute(event);
        }

        System.out.println(String.format("StateMachine[%s] Can not find transition for stateId[%s] eventCode[%s]",
                this.getClass().getSimpleName(), state.getStateCode(), event.getEventCode()));
        return null;
    }

    /**
     * 获取状态
     * @param stateCode 状态编码
     * @return
     */
    public State getState(String stateCode) {
        if (allStateMap == null) {
            System.out.println("StateMachine declareAllStates");
            allStateMap = this.declareAllState();
        }

        return allStateMap.get(stateCode);
    }
    
    /**
     * 由具体的状态机定义所有状态
     * @return
     */
    public abstract Map<String, State> declareAllState();

}