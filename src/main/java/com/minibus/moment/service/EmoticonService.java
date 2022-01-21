package com.minibus.moment.service;

import com.minibus.moment.domain.emoticon.Emoticon;
import com.minibus.moment.domain.emoticon.EmoticonRepository;
import com.minibus.moment.dto.EmoticonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmoticonService {

    private final EmoticonRepository emoticonRepository;

    public EmoticonDto getEmoticonList() {
        List<Emoticon> emoticons = emoticonRepository.findAll();
        return EmoticonDto.builder()
                .data(emoticons)
                .build();
    }
}
