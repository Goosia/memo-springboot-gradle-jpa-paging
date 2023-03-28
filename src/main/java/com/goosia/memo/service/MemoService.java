package com.goosia.memo.service;

import com.goosia.memo.entity.Memo;
import com.goosia.memo.model.MemoDTO;
import com.goosia.memo.model.MemoQueryVO;
import com.goosia.memo.model.MemoUpdateVO;
import com.goosia.memo.model.MemoVO;
import com.goosia.memo.repository.MemoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Integer save(MemoVO vo) {
        Memo bean = new Memo();
        BeanUtils.copyProperties(vo, bean);
        bean = memoRepository.save(bean);
        return bean.getIdx();
    }

    public void delete(Integer id) {
        memoRepository.deleteById(id);
    }

    public void update(Integer id, MemoUpdateVO vo) {
        Memo bean = requireOne(id);
        BeanUtils.copyProperties(vo, bean);
        memoRepository.save(bean);
    }

    public MemoDTO getById(Integer id) {
        Memo original = requireOne(id);
        return toDTO(original);
    }

    public Page<MemoDTO> findAll(MemoQueryVO vo, Pageable pageable) {
        return memoRepository.findAll(pageable).map(this::toDTO);
    }

    // 페이징 처리된 리스트 조회, 정렬은 idx 의 역순으로.
    public Page<MemoDTO> findAll(Pageable pageable) {
        return memoRepository.findMemoByOrderByIdxDesc(pageable).map(this::toDTO);
    }

    public List<MemoDTO> query(MemoQueryVO vo) {
        return memoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private MemoDTO toDTO(Memo original) {
        MemoDTO bean = new MemoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Memo requireOne(Integer id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
