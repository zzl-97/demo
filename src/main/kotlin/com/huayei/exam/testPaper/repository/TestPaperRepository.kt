package com.huayei.exam.testQuestions.repository


import com.huayei.testQuestions.event.Course
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

@Repository
@Transactional(readOnly = true)
interface TestPaperRepository : JpaRepository <Course,Int>, JpaSpecificationExecutor <Course>   {

}