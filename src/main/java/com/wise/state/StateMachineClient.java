package com.wise.state;

import com.wise.state.dto.PassDTO;
import com.wise.state.dto.RefuseDTO;
import com.wise.state.dto.UpDTO;

/**
 * 状态机客户端
 */
public class StateMachineClient {

    public static void main(String[] args) {
        // 状态机
        ContentAuditStateMachine contentAuditStateMachine = new ContentAuditStateMachine();

        // TODO 可以将状态和事件提前定义好，交给 Spring 管理，然后通过状态标识和事件标识找到对应的实例，简化编程

        // 审核通过参数
        PassDTO passDTO = new PassDTO();
        passDTO.setContentId("1");

        // 当前状态为待审核，即将执行审核通过事件
        State state = contentAuditStateMachine.execute(
                contentAuditStateMachine.getState(ContentAuditStateMachine.StateCodeContents.PENDING),
                new ContentAuditStateMachine.PassEvent(passDTO)
        );

        // 上架参数
        UpDTO upDTO = new UpDTO();
        upDTO.setContentId("1");

        // 若返回状态不为空，表示执行事件成功，则发起上架事件
        if (state != null) {
            state = contentAuditStateMachine.execute(
                    state,
                    new ContentAuditStateMachine.UpEvent(upDTO)
            );
        }

        System.out.println("最终状态:" + state);

        System.out.println("--------------------分割线-------------------------");

        // 审核拒绝参数
        RefuseDTO refuseDTO = new RefuseDTO();
        refuseDTO.setContentId("2");
        refuseDTO.setReason("涉政");

        // 当前状态为待审核，即将执行审核拒绝事件
        state = contentAuditStateMachine.execute(
                contentAuditStateMachine.getState(ContentAuditStateMachine.StateCodeContents.PENDING),
                new ContentAuditStateMachine.RefuseEvent(refuseDTO)
        );

        System.out.println("最终状态:" + state);
    }

}