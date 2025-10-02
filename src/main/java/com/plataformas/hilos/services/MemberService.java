package com.plataformas.hilos.services;

import com.plataformas.hilos.model.MemberEntity;
import com.plataformas.hilos.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public List<MemberEntity> getAll() {
        return repository.findAll();
    }

    public MemberEntity save(MemberEntity member) {
        return repository.save(member);
    }
}