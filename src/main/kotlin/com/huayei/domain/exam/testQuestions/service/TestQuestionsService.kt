package com.huayei.domain.systemManagement.service

import com.huayei.exam.testQuestions.event.TestQuestions
import com.huayei.exam.testQuestions.repository.TestQuestionsRepository
import org.springframework.stereotype.Service
import java.util.*

/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/8 15:12
* @Since 1.0
*
*/
@Service
class TestQuestionsService(
    var testQuestionsRepository: TestQuestionsRepository
) {
    fun getQuestion(id: Long): Optional<TestQuestions> = testQuestionsRepository.findById(id)

    /**
     * 根据课程id和试题类型来获取试题信息
     * @param courseID 课程id
     * @param type 试题类型
     * @return 返回获取到的试题信息
     */
    fun getQuestionsOf(courseId: Int, type: String): List<TestQuestions> = testQuestionsRepository.findByCourseIdAndQuestionType(courseId,type)

    //删除试题
    fun delQuestion(courseId: Int) = testQuestionsRepository.findByCourseId(courseId).map {
        testQuestionsRepository.deleteByCourseId(courseId)
    }
}