package com.huayei.exam.testQuestions.repository

import com.huayei.exam.testQuestions.event.Course
import com.huayei.exam.testQuestions.event.TestQuestions
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query

@Repository
@Transactional(readOnly = true)
interface TestQuestionsRepository : JpaRepository <TestQuestions,Int>, JpaSpecificationExecutor <TestQuestions>   {

    @Query(value = "select a from TestQuestions a left join Course b on a.courseId = b.courseId where b.courseName=?1")
    fun findQuestionByCourseName(courseName : String) : TestQuestions

    @Query(value = "select a from TestQuestions a left join Course b on a.courseId = b.courseId where b.courseId=?1")
    fun findQuestionByCourseId(courseId : Int) : TestQuestions

    fun findByCourseIdAndQuestionType(courseId : Int, type : String) : Iterable<TestQuestions>
}