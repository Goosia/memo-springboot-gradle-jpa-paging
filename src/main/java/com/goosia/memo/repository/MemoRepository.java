package com.goosia.memo.repository;

import java.util.stream.DoubleStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.goosia.memo.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer>, JpaSpecificationExecutor<Memo> {
	Page<Memo> findMemoByOrderByIdxDesc(Pageable pageable);
}