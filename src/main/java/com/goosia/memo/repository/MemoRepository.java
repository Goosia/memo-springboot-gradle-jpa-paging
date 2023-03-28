package com.goosia.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.goosia.memo.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer>, JpaSpecificationExecutor<Memo> {
}