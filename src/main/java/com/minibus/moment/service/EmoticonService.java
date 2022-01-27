package com.minibus.moment.service;

import com.minibus.moment.domain.emoticon.EmoticonRepository;
import com.minibus.moment.dto.EmoticonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmoticonService {

    private final EmoticonRepository emoticonRepository;

    public List<EmoticonDto> getEmoticonList() {
        return emoticonRepository.findAll().stream()
                .map(EmoticonDto::from)
                .collect(Collectors.toList());
    }

    // Todo 이모티콘 추가, 업데이트, 삭제 메서드 구현
    // 이모티콘 추가&업데이트 -> 새로운 이모티콘 글 등록 시 자동 등록
    // 별도 이모티콘 삭제기능 불필요 판단.
}
