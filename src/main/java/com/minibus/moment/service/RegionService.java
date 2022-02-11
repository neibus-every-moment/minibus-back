package com.minibus.moment.service;

import com.minibus.moment.domain.post.PostRepository;
import com.minibus.moment.domain.region.Region;
import com.minibus.moment.domain.region.RegionRepository;
import com.minibus.moment.dto.RegionDto;
import com.minibus.moment.exception.PostNotExistException;
import com.minibus.moment.exception.RegionAlreadyExistException;
import com.minibus.moment.exception.RegionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final PostRepository postRepository;

    public List<RegionDto> getRegionList() {
        return regionRepository.findAll().stream()
                .map(RegionDto::from)
                .collect(Collectors.toList());
    }

    // 지역 테이블에 새로운 지역 추가
    public void newRegion(RegionDto.Request request) {
        // 등록하려는 region 이 이미 테이블에 있는지 확인하고 없으면 추가 있으면 throw regionAlreadyExist
        Optional<Region> region = regionRepository.findByNameEquals(request.getRegion());
        if(!region.isPresent()) {
            regionRepository.save(Region.builder()
                    .name(request.getRegion())
                    .build());
        } else {
            throw new RegionAlreadyExistException("해당 지역이 이미 존재합니다.");// regionAlreadyExistException
        }
    }

    // 지역 테이블의 지역 이름 변경
    @Transactional
    public void editRegionNameInTable(RegionDto.Request request){
        // 등록하려는 region 검색하여 이름 변경, 이미 테이블에 있는 명칭으로는 변경 불가
        Optional<Region> region = regionRepository.findByNameEquals(request.getRegion());
        if(!region.isPresent()) {
            regionRepository.findById(request.getId()).ifPresent(
                    entity -> entity.setName(request.getRegion())
            );
        } else {
            throw new RegionAlreadyExistException("해당 지역이 이미 존재합니다.");// regionAlreadyExistException
        }
    }

    // 포스트의 지역 변경
    @Transactional
    public void editPostRegion(RegionDto.Request request){
        postRepository.findById(request.getPostId()).ifPresentOrElse(
                entity -> entity.setRegion(regionRepository.findByNameEquals(request.getRegion()).orElseThrow(() -> new RegionNotFoundException("해당 지역이 존재하지 않습니다."))),
                () -> new PostNotExistException("해당 글이 존재하지 않습니다.") //PostNotExistException
        );
    }

    // 지역 테이블에서 지역 삭제
    public void deleteRegionInTable(RegionDto.Request request) {
        regionRepository.findByNameEquals(request.getRegion()).ifPresentOrElse(
                entity -> regionRepository.delete(entity),
                () -> new RegionNotFoundException("해당 지역을 찾지 못했습니다.") //regionNotExistException
        );
    }
}
