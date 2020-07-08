package com.huayei.exam.testPaper.repository

import com.huayei.exam.testPaper.event.TestPaperQuestion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface TestPaperQuestionRepository : JpaRepository<TestPaperQuestion, Int>, JpaSpecificationExecutor<TestPaperQuestion> {

    fun deleteByPaperId(paperId : Int)

    fun findByPaperId(paperId: Int) : List<TestPaperQuestion>
}