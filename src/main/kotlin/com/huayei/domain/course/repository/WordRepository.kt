package com.huayei.domain.course.repository

import com.huayei.domain.course.entity.Word
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 *@Description 作业DAO
 *Author zzl@huayei.com
 *Date 2020/7/9 9:53
 *@Since 1.0
 **/
@Repository
interface WordRepository : JpaRepository<Word, Long>, JpaSpecificationExecutor<Word> {
}