package com.wise.state;

import com.wise.state.dto.DownDTO;
import com.wise.state.dto.PassDTO;
import com.wise.state.dto.RefuseDTO;
import com.wise.state.dto.UpDTO;

/**
 * 状态机客户端
 */
public class StateMachineClient {

    public static void main(String[] args) {
//        allDemo();

//        machineRefuseDemo();

        manualRefuseDemo();
    }

    /**
     * 全流程通过示例
     * 待审核 -> 机审通过 -> 人工审核通过 -> 上架 -> 下架 -> 销毁
     */
    public static void allDemo() {
        // 状态机
        ContentAuditStateMachine contentAuditStateMachine = new ContentAuditStateMachine();

        // TODO 可以将状态和事件提前定义好，交给 Spring 管理，然后通过状态标识和事件标识找到对应的实例，简化编程

        // 审核通过参数
        PassDTO passDTO = new PassDTO();
        passDTO.setContentId("1");

        // 当前状态为待审核，即将执行机审通过事件
        State state = contentAuditStateMachine.execute(
                contentAuditStateMachine.getState(ContentAuditStateMachine.StateCodeContents.PENDING),
                new ContentAuditStateMachine.MachineAuditPassEvent(passDTO)
        );

        System.out.println("执行机审通过事件后状态:" + state);

        // 当前状态为机审通过，即将执行人工审核通过事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.ManualAuditPassEvent(passDTO)
        );

        System.out.println("执行人工审核通过事件后状态:" + state);

        // 上架参数
        UpDTO upDTO = new UpDTO();
        upDTO.setContentId("1");

        // 当前状态为人工审核通过，即将执行上架事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.UpEvent(upDTO)
        );

        System.out.println("执行上架事件后状态:" + state);

        // 下架参数
        DownDTO downDTO = new DownDTO();
        downDTO.setContentId("1");
        downDTO.setReason("内容已过期");

        // 当前状态为上架，即将执行下架事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.DownEvent(downDTO)
        );

        System.out.println("执行下架事件后状态:" + state);

        // 当前状态为下架，即将执行删除内容事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.DeleteContentEvent("1")
        );

        System.out.println("最终状态:" + state);
    }

    /**
     * 机审拒绝示例
     * 待审核 -> 机审拒绝 -> 销毁
     */
    public static void machineRefuseDemo() {
        // 状态机
        ContentAuditStateMachine contentAuditStateMachine = new ContentAuditStateMachine();

        // TODO 可以将状态和事件提前定义好，交给 Spring 管理，然后通过状态标识和事件标识找到对应的实例，简化编程

        // 审核拒绝参数
        RefuseDTO refuseDTO = new RefuseDTO();
        refuseDTO.setContentId("2");
        refuseDTO.setReason("涉政");

        // 当前状态为待审核，即将执行机审拒绝事件
        State state = contentAuditStateMachine.execute(
                contentAuditStateMachine.getState(ContentAuditStateMachine.StateCodeContents.PENDING),
                new ContentAuditStateMachine.MachineAuditRefuseEvent(refuseDTO)
        );

        System.out.println("执行机审拒绝事件后状态:" + state);

        // 当前状态为机审不通过，即将执行删除内容事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.DeleteContentEvent("2")
        );

        System.out.println("最终状态:" + state);
    }

    /**
     * 人工审核拒绝示例
     * 待审核 -> 机审通过 -> 人工审核不通过 -> 销毁
     */
    public static void manualRefuseDemo() {
        // 状态机
        ContentAuditStateMachine contentAuditStateMachine = new ContentAuditStateMachine();

        // TODO 可以将状态和事件提前定义好，交给 Spring 管理，然后通过状态标识和事件标识找到对应的实例，简化编程

        // 审核通过参数
        PassDTO passDTO = new PassDTO();
        passDTO.setContentId("3");

        // 当前状态为待审核，即将执行机审通过事件
        State state = contentAuditStateMachine.execute(
                contentAuditStateMachine.getState(ContentAuditStateMachine.StateCodeContents.PENDING),
                new ContentAuditStateMachine.MachineAuditPassEvent(passDTO)
        );

        System.out.println("执行机审通过事件后状态:" + state);

        // 审核拒绝参数
        RefuseDTO refuseDTO = new RefuseDTO();
        refuseDTO.setContentId("3");
        refuseDTO.setReason("涉黄");

        // 当前状态为机审通过，即将执行人工审核拒绝事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.ManualAuditRefuseEvent(refuseDTO)
        );

        System.out.println("执行人工审核拒绝事件后状态:" + state);

        // 当前状态为人工审核不通过，即将执行删除内容事件
        state = contentAuditStateMachine.execute(
                state,
                new ContentAuditStateMachine.DeleteContentEvent("3")
        );

        System.out.println("最终状态:" + state);
    }

}