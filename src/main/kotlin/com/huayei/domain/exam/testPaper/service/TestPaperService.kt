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

    //删除课程情况下的试卷和中间表的删除过程
    //传入课程id
    fun delPaper(id : Int) {
        var testPaperList : List<TestPaper>
        testPaperList = testPaperRepository.findByCourseId(id)
        for (i in 0 until testPaperList.size) {
            testPaperList[i].paperId?.let { testPaperQuestionRepository.deleteByPaperId(it) }
        }
        testPaperRepository.deleteByCourseId(id)
    }
}