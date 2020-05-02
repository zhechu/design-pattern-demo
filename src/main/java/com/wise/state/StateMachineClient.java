package com.wise.state;

import com.wise.state.bizparam.PassParam;

/**
 * 状态机客户端
 */
public class StateMachineClient {

    public static void main(String[] args) {
        PassParam passParam = new PassParam();
        passParam.setUserName("zhangsan");
        passParam.setAge(20);

        // TODO 可以将状态和事件提前定义好，交给 Spring 管理，然后通过状态标识和事件标识找到对应的实例，方便编程
        AuditStateMachine auditStateMachine = new AuditStateMachine();
        State state = auditStateMachine.execute(auditStateMachine.getState(AuditStateMachine.StateCodeContents.PENDING), new AuditStateMachine.PassEvent(passParam));
        System.out.println(state);
    }

}