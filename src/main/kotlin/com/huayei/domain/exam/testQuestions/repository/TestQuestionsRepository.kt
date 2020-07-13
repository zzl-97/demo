package com.huayei.exam.testQuestions.repository


import com.huayei.exam.testQuestions.event.TestQuestions
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import java.util.*

@Repository
@Transactional(readOnly = true)
interface TestQuestionsRepository : JpaRepository <TestQuestions,Long>, JpaSpecificationExecutor <TestQuestions>   {

    fun existsByQuestionName(courseName: String): Boolean

    @Query(value = "select a from TestQuestions a left join Course b on a.courseId = b.courseId where b.courseId=?1")
    fun findQuestionByCourseId(courseId: Int): TestQuestions

    fun findByCourseIdAndQuestionType(courseId: Int, type: String): List<TestQuestions>

    fun deleteByCourseId(courseId: Int)

    fun findByCourseId(courseId: Int): Iterable<TestQuestions>
}