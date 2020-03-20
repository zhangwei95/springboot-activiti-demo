package com.zw.activitidemo.controller;

import com.zw.activitidemo.common.ResponseMsg;
import com.zw.activitidemo.entity.Activiti;
import com.zw.activitidemo.entity.ActivitiTask;
import com.zw.activitidemo.entity.User;
import com.zw.activitidemo.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivitiController {
    @Autowired
    private ActivitiService activitiService;

    @RequestMapping(value = "/allRecord", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg allRecord(HttpSession session, Model model) {
        myActiviti(session);
        List<Activiti> list = myActiviti(session);
        model.addAttribute("list",list);
        myApproval(session);
        List<ActivitiTask> list3 = myApproval(session);
        model.addAttribute("list3",list3);
        myActivitiRecord(session);
        List<Activiti> list2 = myActivitiRecord(session);
        model.addAttribute("list2",list2);
        myApprovalRecord(session);
        List<Activiti> list4 = myApprovalRecord(session);
        model.addAttribute("list4",list4);
        return ResponseMsg.builder().result(model).build();
    }

    //流程申请
    @RequestMapping(value = "/createActiviti", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg createActiviti(Activiti vac,HttpSession session){
//        User user=(User)session.getAttribute("user");
//        String userName = user.getUsername();
        String userName = "zw";
        activitiService.startActiviti(vac, userName);
        return ResponseMsg.builder().build();
    }

    //我正在申请的假
//    @RequestMapping(value = "/myActiviti", method = RequestMethod.GET)
    public List<Activiti> myActiviti(HttpSession session) {
        String userName = "zw";
//        String userName = (String)session.getAttribute("user");
//        User user=(User)session.getAttribute("user");
//        String userName = user.getUsername();
        List<Activiti> list = activitiService.myActiviti(userName);
        return list;
    }

    //待我审核的请假
//    @RequestMapping(value = "/myApproval", method = RequestMethod.GET)
    public List<ActivitiTask> myApproval(HttpSession session) {
        User user=(User)session.getAttribute("user");
        //String userName = user.getUsername();
        String userName = "huangxu2";
        List<ActivitiTask> list3 = activitiService.myApproval(userName);
        return list3;
    }

    //流程审批
    @RequestMapping(value = "/passApproval", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg passApproval(String id,String result,HttpSession session) {
//        User user=(User)session.getAttribute("user");
        ActivitiTask activitiTask = new ActivitiTask();
        Activiti activiti = new Activiti();
        activitiTask.setId(id);
        activiti.setResult(result);
        activitiTask.setActiviti(activiti);
//        String userName = user.getUsername();
        String userName = "zw";
        activitiService.passApproval(userName, activitiTask);
        return ResponseMsg.builder().build();
    }

    //我申请过的假
//    @RequestMapping(value = "/myActivitiRecord", method = RequestMethod.GET)
    public List<Activiti> myActivitiRecord(HttpSession session) {
//        User user=(User)session.getAttribute("user");
//        String userName = user.getUsername();
        String userName = "zw";
        List<Activiti> list2 = activitiService.myActivitiRecord(userName);
        return list2;
    }

    //我的审核记录
//    @RequestMapping(value = "/myApprovalRecord", method = RequestMethod.GET)
    public List<Activiti> myApprovalRecord(HttpSession session) {
//        User user=(User)session.getAttribute("user");
//        String userName = user.getUsername();
        String userName = "zw";
        List<Activiti> list4 = activitiService.myApprovalRecord(userName);
        return list4;
    }

}
