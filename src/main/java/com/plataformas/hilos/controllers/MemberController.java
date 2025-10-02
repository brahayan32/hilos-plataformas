package com.plataformas.hilos.controllers;

import com.plataformas.hilos.model.MemberEntity;
import com.plataformas.hilos.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping
    public List<MemberEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public MemberEntity create(@RequestBody MemberEntity member) {
        return service.save(member);
    }
}