package com.goosia.memo.repository;

import com.goosia.memo.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemoRepository extends JpaRepository<Memo, Integer>, JpaSpecificationExecutor<Memo> {
}