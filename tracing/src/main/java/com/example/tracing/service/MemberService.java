package com.example.tracing.service;

import com.example.tracing.domain.Member;
import com.example.tracing.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void save(Member member) {
        Member savedMember = memberRepository.save(member);
        log.info("save member : {}", savedMember.getId());
    }
}
