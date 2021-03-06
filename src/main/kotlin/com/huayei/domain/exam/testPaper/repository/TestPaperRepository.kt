package com.huayei.exam.testQuestions.repository


import com.huayei.exam.testQuestions.event.TestPaper
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

@Repository
@Transactional(readOnly = true)
interface TestPaperRepository : JpaRepository<TestPaper, Long>, JpaSpecificationExecutor<TestPaper> {

    fun findByCourseId(courseId: Long): List<TestPaper>

    fun deleteByCourseId(courseId: Long)

}