package com.goosia.memo.controller;

import com.goosia.memo.model.MemoQueryVO;
import com.goosia.memo.model.MemoUpdateVO;
import com.goosia.memo.model.MemoVO;
import com.goosia.memo.service.MemoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/form")
    public String addForm() {
        return "insert";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute MemoVO vo) {
        memoService.save(vo).toString();
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        memoService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@Valid @NotNull @PathVariable("id") Integer id, Model model) {
        model.addAttribute("memo", memoService.getById(id));
        return "update";
    }

    @PutMapping("/{id}")
    public String update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @ModelAttribute MemoUpdateVO vo) {
        memoService.update(id, vo);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getById(@Valid @NotNull @PathVariable("id") Integer id, Model model) {
        model.addAttribute("memo", memoService.getById(id));
        return "detail";
    }

    @GetMapping
    public String query(@Valid MemoQueryVO vo, Model model) {
        model.addAttribute("memos", memoService.query(vo));
        return "index";
    }
}
