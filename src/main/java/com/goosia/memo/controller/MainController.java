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
@RequestMapping("/")
public class MainController {

    @Autowired
    private MemoService memoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("memos", memoService.query(new MemoQueryVO()));
        return "index";
    }
}
