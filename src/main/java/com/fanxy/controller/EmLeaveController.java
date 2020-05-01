package com.fanxy.controller;
import com.fanxy.entity.EmInformationEntity;
import com.fanxy.entity.EmLeaveEntity;
import com.fanxy.result.Result;
import com.fanxy.service.EmInfomationService;
import com.fanxy.service.EmLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author fanxy
 */
@RestController
@RequestMapping("/emLeave")
public class EmLeaveController {

    private  String success = "SUCCESS";
    private EmLeaveService emLeaveService;

    private EmInfomationService emInfomationService;

    @Autowired
    public EmLeaveController(EmLeaveService emLeaveService) {
        this.emLeaveService = emLeaveService;
    }

    @Autowired
    public void setEmInfomationService(EmInfomationService emInfomationService) {
        this.emInfomationService = emInfomationService;
    }

    @GetMapping("/queryLeaderByuserId/{userId}")
    public Result queryLeaderByuserId(@PathVariable("userId") int userId){
        return new Result<>(success,"查询成功",emLeaveService.queryLeaderByuserId(userId));
    }

    @PostMapping("/userLeave")
    public String userLeave(@RequestBody EmLeaveEntity emLeaveEntity){
        emLeaveEntity.setState(0);
        emLeaveService.userLeave(emLeaveEntity);
        return "申请成功";
    }

    @GetMapping("queryEmLeaveRecord/{userId}")
    public Result queryEmLeaveRecord(@PathVariable("userId") int userId){
        String position = "普通员工";
        EmInformationEntity emInformationEntity = emInfomationService.queryByUserId(userId);
        if(emInformationEntity!=null){
            if(!position.equals(emInformationEntity.getPosition())){
                return new Result<>(success,"查询成功",emLeaveService.queryLeaveRecordByDeparment(emInformationEntity.getDepartment()));
            }else {
                return new Result<>(success,"查询成功",emLeaveService.queryLeaveRecordByuserId(userId));
            }
        }
        return null;
    }

    @GetMapping("approvalEmLeaveRecord/{userId}")
    public Result approvalEmLeaveRecord(@PathVariable("userId") int userId){
        String position = "普通员工";
        EmInformationEntity emInformationEntity = emInfomationService.queryByUserId(userId);
        if(emInformationEntity!=null){
            if(!position.equals(emInformationEntity.getPosition())){
                return new Result<>(success,"查询成功",emLeaveService.queryLeaveRecordByDeparment(emInformationEntity.getDepartment()));
            }
            return null;
        }
        return null;
    }

    @GetMapping("approvalEmLeave/{state}/{emName}/{leaderName}")
    public String approvalEmLeave(@PathVariable("state") int state,@PathVariable("emName") String emName,
                                  @PathVariable("leaderName") String leaderName){

        emLeaveService.approvalEmLeave(state,emName,leaderName);
        return "操作成功";
    }

}
