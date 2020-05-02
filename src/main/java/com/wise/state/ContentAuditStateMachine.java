package com.wise.state;

import com.wise.state.dto.DownDTO;
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
        Map<String, State> stateMap = new HashMap<>(8);

        State pendingState = new State(StateCodeContents.PENDING);
        State machineAuditPassedState = new State(StateCodeContents.MACHINE_AUDIT_PASSED);
        State machineAuditRefusedState = new State(StateCodeContents.MACHINE_AUDIT_REFUSED);
        State manualAuditPassedState = new State(StateCodeContents.MANUAL_AUDIT_PASSED);
        State manualAuditRefusedState = new State(StateCodeContents.MANUAL_AUDIT_REFUSED);
        State upState = new State(StateCodeContents.UP);
        State downState = new State(StateCodeContents.DOWN);
        State destoryState = new State(StateCodeContents.DESTROY);

        // 待审核状态添加机审通过和机审拒绝行为
        pendingState.addTransition(new MachineAuditPassTransition(pendingState, machineAuditPassedState));
        pendingState.addTransition(new MachineAuditRefuseTransition(pendingState, machineAuditRefusedState));

        // 机审通过状态添加人工审核通过和人工审核拒绝行为
        machineAuditPassedState.addTransition(new ManualAuditPassTransition(machineAuditPassedState, manualAuditPassedState));
        machineAuditPassedState.addTransition(new ManualAuditRefuseTransition(machineAuditPassedState, manualAuditRefusedState));

        // 机审不通过状态添加删除内容行为
        machineAuditRefusedState.addTransition(new DeleteContentTransition(machineAuditRefusedState, destoryState));

        // 人工审核通过状态添加上架行为
        manualAuditPassedState.addTransition(new UpTransition(manualAuditPassedState, upState));

        // 人工审核不通过状态添加删除内容行为
        manualAuditRefusedState.addTransition(new DeleteContentTransition(manualAuditRefusedState, destoryState));

        // 上架状态添加下架行为
        upState.addTransition(new DownTransition(upState, downState));

        // 下架状态添加删除内容行为
        downState.addTransition(new DeleteContentTransition(downState, destoryState));

        stateMap.put(pendingState.getStateCode(), pendingState);
        stateMap.put(machineAuditPassedState.getStateCode(), machineAuditPassedState);
        stateMap.put(machineAuditRefusedState.getStateCode(), machineAuditRefusedState);
        stateMap.put(manualAuditPassedState.getStateCode(), manualAuditPassedState);
        stateMap.put(manualAuditRefusedState.getStateCode(), manualAuditRefusedState);
        stateMap.put(upState.getStateCode(), upState);
        stateMap.put(downState.getStateCode(), downState);
        stateMap.put(destoryState.getStateCode(), destoryState);

        return stateMap;
    }
    
    /** 定义“机审通过”动作 */
    public class MachineAuditPassTransition extends Transition<MachineAuditPassEvent> {

        public MachineAuditPassTransition(State currState, State nextState) {
            super(EventCodeContents.MACHINE_AUDIT_PASS, currState, nextState);
        }

        @Override
        protected boolean doExecute(MachineAuditPassEvent event) {
            System.out.println("执行机审通过操作开始...");

            PassDTO passDTO = event.getParam();
            System.out.println("执行机审通过操作参数:" + passDTO);

            System.out.println("执行机审通过操作结束...");
            return true;
        }
        
    }
    
    /** 定义“机审拒绝”动作 */
    public class MachineAuditRefuseTransition extends Transition<MachineAuditRefuseEvent> {

        public MachineAuditRefuseTransition(State currState, State nextState) {
            super(EventCodeContents.MACHINE_AUDIT_REFUSE, currState, nextState);
        }

        @Override
        protected boolean doExecute(MachineAuditRefuseEvent event) {
            System.out.println("执行机审拒绝操作开始...");

            RefuseDTO refuseDTO = event.getParam();
            System.out.println("执行机审拒绝操作参数:" + refuseDTO);

            System.out.println("执行机审拒绝操作结束...");
            return true;
        }
        
    }

    /** 定义“人工审核通过”动作 */
    public class ManualAuditPassTransition extends Transition<ManualAuditPassEvent> {

        public ManualAuditPassTransition(State currState, State nextState) {
            super(EventCodeContents.MANUAL_AUDIT_PASS, currState, nextState);
        }

        @Override
        protected boolean doExecute(ManualAuditPassEvent event) {
            System.out.println("执行人工审核通过操作开始...");

            PassDTO passDTO = event.getParam();
            System.out.println("执行人工审核通过操作参数:" + passDTO);

            System.out.println("执行人工审核通过操作结束...");
            return true;
        }

    }

    /** 定义“人工审核拒绝”动作 */
    public class ManualAuditRefuseTransition extends Transition<ManualAuditRefuseEvent> {

        public ManualAuditRefuseTransition(State currState, State nextState) {
            super(EventCodeContents.MANUAL_AUDIT_REFUSE, currState, nextState);
        }

        @Override
        protected boolean doExecute(ManualAuditRefuseEvent event) {
            System.out.println("执行人工审核拒绝操作开始...");

            RefuseDTO refuseDTO = event.getParam();
            System.out.println("执行人工审核拒绝操作参数:" + refuseDTO);

            System.out.println("执行人工审核拒绝操作结束...");
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

    /** 定义“下架”动作 */
    public class DownTransition extends Transition<DownEvent> {

        public DownTransition(State currState, State nextState) {
            super(EventCodeContents.DOWN, currState, nextState);
        }

        @Override
        protected boolean doExecute(DownEvent event) {
            System.out.println("执行下架操作开始...");

            DownDTO downDTO = event.getParam();
            System.out.println("执行下架操作参数:" + downDTO);

            System.out.println("执行下架操作结束...");
            return true;
        }

    }

    /** 定义“删除内容”动作 */
    public class DeleteContentTransition extends Transition<DeleteContentEvent> {

        public DeleteContentTransition(State currState, State nextState) {
            super(EventCodeContents.DELETE_CONTENT, currState, nextState);
        }

        @Override
        protected boolean doExecute(DeleteContentEvent event) {
            System.out.println("执行删除内容操作开始...");

            String contentId = event.getParam();
            System.out.println("执行删除内容操作参数:" + contentId);

            System.out.println("执行删除内容操作结束...");
            return true;
        }

    }

    /**
     * 机审通过事件
     */
    public static class MachineAuditPassEvent extends Event<PassDTO> {

        public MachineAuditPassEvent(PassDTO bizParam) {
            super(EventCodeContents.MACHINE_AUDIT_PASS, bizParam);
        }

    }

    /**
     * 机审拒绝事件
     */
    public static class MachineAuditRefuseEvent extends Event<RefuseDTO> {

        public MachineAuditRefuseEvent(RefuseDTO refuseDTO) {
            super(EventCodeContents.MACHINE_AUDIT_REFUSE, refuseDTO);
        }

    }

    /**
     * 人工审核通过事件
     */
    public static class ManualAuditPassEvent extends Event<PassDTO> {

        public ManualAuditPassEvent(PassDTO bizParam) {
            super(EventCodeContents.MANUAL_AUDIT_PASS, bizParam);
        }

    }

    /**
     * 人工审核拒绝事件
     */
    public static class ManualAuditRefuseEvent extends Event<RefuseDTO> {

        public ManualAuditRefuseEvent(RefuseDTO refuseDTO) {
            super(EventCodeContents.MANUAL_AUDIT_REFUSE, refuseDTO);
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

    /**
     * 下架事件
     */
    public static class DownEvent extends Event<DownDTO> {

        public DownEvent(DownDTO downDTO) {
            super(EventCodeContents.DOWN, downDTO);
        }

    }

    /**
     * 删除内容事件
     */
    public static class DeleteContentEvent extends Event<String> {

        public DeleteContentEvent(String contentId) {
            super(EventCodeContents.DELETE_CONTENT, contentId);
        }

    }

    /** 事件编码 */
    public class EventCodeContents {
        public static final String MACHINE_AUDIT_PASS = "机审通过";
        public static final String MACHINE_AUDIT_REFUSE = "机审拒绝";
        public static final String MANUAL_AUDIT_PASS = "人工审核通过";
        public static final String MANUAL_AUDIT_REFUSE = "人工审核拒绝";
        public static final String UP = "上架";
        public static final String DOWN = "下架";
        public static final String DELETE_CONTENT = "删除内容";
    }
    
    /** 状态编码 */
    public class StateCodeContents {
        public static final String PENDING = "待审核";
        public static final String MACHINE_AUDIT_PASSED = "机审通过";
        public static final String MACHINE_AUDIT_REFUSED = "机审不通过";
        public static final String MANUAL_AUDIT_PASSED = "人工审核通过";
        public static final String MANUAL_AUDIT_REFUSED = "人工审核不通过";
        public static final String UP = "上架";
        public static final String DOWN = "下架";
        public static final String DESTROY = "销毁";
    }

}