package com.goosia.memo.controller;

import com.goosia.memo.model.MemoQueryVO;
import com.goosia.memo.model.MemoUpdateVO;
import com.goosia.memo.model.MemoVO;
import com.goosia.memo.service.MemoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 메모 컨트롤러
 * @author goosia
 * @since 2023-03-24
 * @version 1.0
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/memos")
public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/form")
    public String addForm() {
        return "pages/memos/add";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute MemoVO vo) {
        memoService.save(vo);
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
        return "pages/memos/update";
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
        return "pages/memos/detail";
    }

    @GetMapping
    public String query(@Valid MemoQueryVO vo, Model model, Pageable pageable) {
        model.addAttribute("memos", memoService.findAll(vo, pageable));
        return "pages/memos/index";
    }

}
