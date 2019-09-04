package com.yb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yb.entity.Count;
import com.yb.entity.Draft;
import com.yb.entity.Student;
import com.yb.service.impl.DraftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jue-PC
 */
@Controller
public class DraftController {

    private final
    DraftServiceImpl draftService;

    @Autowired
    public DraftController(DraftServiceImpl draftService) {this.draftService = draftService;}

    @RequestMapping("/write")
    public String write(HttpServletRequest request) {
        try {
            Student student = (Student) request.getSession().getAttribute("student");
            Draft draft = new Draft();
            draft.setWords(request.getParameter("words"));
            draft.setClassname(student.getClassname());
            draft.setDepartment(student.getDepartment());
            draft.setName(student.getName());
            draft.setStu_id(student.getStu_id());
            draftService.insert(draft);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/reader/{id}")
    public String read(@PathVariable int id, Model model) {
        Draft draft = draftService.query(id);
        draftService.updateState(id);
        model.addAttribute("draft", draft);
        return "text";
    }

    @RequestMapping("/reader")
    public String read(Model model
            , @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<Draft> drafts = draftService.queryAll();
        PageInfo pageInfo = new PageInfo<Draft>(drafts, 5);
        model.addAttribute("drafts", pageInfo);
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getPageSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isNotRead", false);
        return "textList";
    }

    @RequestMapping("/reader/count")
    public String count(Model model) {
        List<Count> counts = draftService.count();
        PageInfo pageInfo = new PageInfo<Count>(counts, 5);
        model.addAttribute("Counts", pageInfo);
        return "countPage";
    }
}
