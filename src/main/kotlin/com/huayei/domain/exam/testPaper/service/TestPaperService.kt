package com.huayei.exam.testPaper.service

import com.huayei.exam.testPaper.repository.TestPaperQuestionRepository
import com.huayei.exam.testQuestions.event.TestPaper
import com.huayei.exam.testQuestions.repository.TestPaperRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestPaperService(
    var testPaperRepository: TestPaperRepository,
    var testPaperQuestionRepository: TestPaperQuestionRepository
) {

    /**
     * 删除课程下的试卷和试卷试题中间表
     * @param id 课程id
     */
    fun delPaper(id : Long) {
        var testPaperList : List<TestPaper> = testPaperRepository.findByCourseId(id)
        for (element in testPaperList) {
            element.paperId?.let { testPaperQuestionRepository.deleteByPaperId(it) }
        }
        testPaperRepository.deleteByCourseId(id)
    }
}