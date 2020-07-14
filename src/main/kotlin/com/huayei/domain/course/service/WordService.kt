/*
 * Copyright (c) 2020 福建华业信息技术有限公司.
 */

package com.huayei.domain.course.service

import com.huayei.base.PageResp
import com.huayei.domain.course.dto.WordDto
import com.huayei.domain.course.entity.Word
import com.huayei.domain.course.repository.WordRepository
import com.huayei.testQuestions.dto.CourseDto
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import javax.persistence.criteria.Predicate

/**
 * @Description TODO
 * @Author  zhengzl
 * @Email zhengzl@huayei.com
 * @Date 2020/7/14 14:27
 * @Since 1.0
 **/
@Service
class WordService(val wordRepository: WordRepository) {

    /**
     * 作业动态查询
     * @param wordDto 查询条件
     * return PageResp集合
     */
    fun getWordAll(wordDto: WordDto): PageResp {
        val pageable: Pageable = PageRequest.of(0, 10,  Sort.by("wordId").descending())
        return PageResp(data = wordRepository.findAll(this.getSpec(wordDto), pageable))
    }

    private fun getSpec(form: WordDto): Specification<Word> {
        return Specification { root, query, cb ->
            var list = ArrayList<Predicate>()
            form.chapterId?.let {
                list.add(cb.equal(root.get<String>("chapterId"), form.chapterId))
            }
            if (!form.wordName.isNullOrBlank()) {
                list.add(cb.like((root.get<String>("wordName")), "%" + form.wordName + "%"))
            }
            val p = arrayOfNulls<Predicate>(list.size)
            cb.and(*list.toArray(p))
        }
    }
}




