package com.huayei.exam.testQuestions.repository


import com.huayei.exam.testQuestions.dto.TestQuestionsDto
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

    fun findByCourseIdAndQuestionType(courseId: Int, type: String): List<TestQuestionsDto>

    fun deleteByCourseId(courseId: Long)

    fun findByCourseId(courseId: Long): List<TestQuestionsDto>
}