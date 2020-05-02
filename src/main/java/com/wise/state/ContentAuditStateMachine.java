package com.wise.state;

import com.wise.state.dto.PassDTO;
import com.wise.state.dto.RefuseDTO;
import com.wise.state.dto.UpDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * 内容审核状态机
 */
public class ContentAuditStateMachine extends StateMachine {

    @Override
    public Map<String, State> declareAllState() {
        Map<String, State> stateMap = new HashMap<>(3);

        State pendingState = new State(StateCodeContents.PENDING);
        State passedState = new State(StateCodeContents.PASSED);
        State refusedState = new State(StateCodeContents.REFUSED);
        State upState = new State(StateCodeContents.UP);

        // 待审核状态添加审核通过和审核拒绝行为
        pendingState.addTransition(new PassTransition(pendingState, passedState));
        pendingState.addTransition(new RefuseTransition(pendingState, refusedState));

        // 审核通过状态添加上架行为
        passedState.addTransition(new UpTransition(passedState, upState));

        stateMap.put(pendingState.getStateCode(), pendingState);
        stateMap.put(passedState.getStateCode(), passedState);
        stateMap.put(refusedState.getStateCode(), refusedState);
        stateMap.put(upState.getStateCode(), upState);

        return stateMap;
    }
    
    /** 定义“通过”动作 */
    public class PassTransition extends Transition<PassEvent> {

        public PassTransition(State currState, State nextState) {
            super(EventCodeContents.PASS, currState, nextState);
        }

        @Override
        protected boolean doExecute(PassEvent event) {
            System.out.println("执行通过操作开始...");

            PassDTO passDTO = event.getParam();
            System.out.println("执行通过操作参数:" + passDTO);

            System.out.println("执行通过操作结束...");
            return true;
        }
        
    }
    
    /** 定义“拒绝”动作 */
    public class RefuseTransition extends Transition<RefuseEvent> {

        public RefuseTransition(State currState, State nextState) {
            super(EventCodeContents.REFUSE, currState, nextState);
        }

        @Override
        protected boolean doExecute(RefuseEvent event) {
            System.out.println("执行拒绝操作开始...");

            RefuseDTO refuseDTO = event.getParam();
            System.out.println("执行拒绝操作参数:" + refuseDTO);

            System.out.println("执行拒绝操作结束...");
            return true;
        }
        
    }

    /** 定义“上架”动作 */
    public class UpTransition extends Transition<UpEvent> {

        public UpTransition(State currState, State nextState) {
            super(EventCodeContents.UP, currState, nextState);
        }

        @Override
        protected boolean doExecute(UpEvent event) {
            System.out.println("执行上架操作开始...");

            UpDTO upDTO = event.getParam();
            System.out.println("执行上架操作参数:" + upDTO);

            System.out.println("执行上架操作结束...");
            return true;
        }

    }

    /**
     * 审核通过事件
     */
    public static class PassEvent extends Event<PassDTO> {

        public PassEvent(PassDTO bizParam) {
            super(EventCodeContents.PASS, bizParam);
        }

    }

    /**
     * 审核拒绝事件
     */
    public static class RefuseEvent extends Event<RefuseDTO> {

        public RefuseEvent(RefuseDTO refuseDTO) {
            super(EventCodeContents.REFUSE, refuseDTO);
        }

    }

    /**
     * 上架事件
     */
    public static class UpEvent extends Event<UpDTO> {

        public UpEvent(UpDTO upDTO) {
            super(EventCodeContents.UP, upDTO);
        }

    }

    /** 事件编码 */
    public class EventCodeContents {
        public static final String PASS = "审核通过";
        public static final String REFUSE = "审核拒绝";
        public static final String UP = "上架";
        public static final String DOWN = "下架";
        public static final String DELETE_CONTENT = "删除内容";
    }
    
    /** 状态编码 */
    public class StateCodeContents {
        public static final String PENDING = "待审核";
        public static final String PASSED = "审核通过";
        public static final String REFUSED = "审核拒绝";
        public static final String UP = "上架";
        public static final String DOWN = "下架";
        public static final String DESTROY = "销毁";
    }

}