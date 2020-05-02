package com.wise.state;

import com.wise.state.bizparam.PassParam;
import com.wise.state.bizparam.RefuseParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单的请假审批状态机
 */
public class AuditStateMachine extends StateMachine {

    @Override
    public Map<String, State> declareAllState() {
        Map<String, State> stateMap = new HashMap<>(3);

        State pendingState = new State(StateCodeContents.PENDING);
        State passedState = new State(StateCodeContents.PASSED);
        State refusedState = new State(StateCodeContents.REFUSED);

        pendingState.addTransition(new PassTransition(pendingState, passedState));
        pendingState.addTransition(new RefuseTransition(pendingState, refusedState));

        stateMap.put(pendingState.getStateCode(), pendingState);
        stateMap.put(passedState.getStateCode(), passedState);
        stateMap.put(refusedState.getStateCode(), refusedState);

        return stateMap;
    }
    
    /** 定义“通过”动作 */
    public class PassTransition extends Transition {

        public PassTransition(State currState, State nextState) {
            super(EventCodeContents.PASS, currState, nextState);
        }

        @Override
        protected boolean doExecute(Event event) {
            Object bizParam = event.getBizParam();
            if (bizParam instanceof PassParam) {
                PassParam passParam = (PassParam) bizParam;
                System.out.println("执行通过操作参数:" + passParam);
            }

            System.out.println("执行通过操作...");
            return true;
        }
        
    }
    
    /** 定义“拒绝”动作 */
    public class RefuseTransition extends Transition {

        public RefuseTransition(State currState, State nextState) {
            super(EventCodeContents.REFUSE, currState, nextState);
        }

        @Override
        protected boolean doExecute(Event event) {
            System.out.println("执行拒绝操作...");
            return true;
        }
        
    }

    /**
     * 审核通过事件
     */
    public static class PassEvent extends Event<PassParam> {

        public PassEvent(PassParam bizParam) {
            super(EventCodeContents.PASS, bizParam);
        }

    }

    /**
     * 审核拒绝事件
     */
    public static class RefuseEvent extends Event<RefuseParam> {

        public RefuseEvent(RefuseParam refuseParam) {
            super(EventCodeContents.REFUSE, refuseParam);
        }

    }

    /** 事件编码 */
    public class EventCodeContents {
        public static final String PASS = "审核通过";
        public static final String REFUSE = "审核拒绝";
    }
    
    /** 状态编码 */
    public class StateCodeContents {
        public static final String PENDING = "待审批";
        public static final String PASSED = "审批通过";
        public static final String REFUSED = "审批拒绝";
    }

}