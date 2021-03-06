package com.huayei.domain.systemManagement.service

import com.huayei.exam.testQuestions.dto.TestQuestionsDto
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
     * @param courseI 课程id
     * @param type 试题类型
     * @return 返回获取到的试题信息
     */
    fun getQuestionsOf(courseId: Int, type: String): List<TestQuestionsDto> = testQuestionsRepository.findByCourseIdAndQuestionType(courseId,type)

    /**
     * 根据课程id删除试题
     * @param courseId 课程id
     */
    fun delQuestionOf(courseId: Long) = testQuestionsRepository.findByCourseId(courseId).map {
        testQuestionsRepository.deleteByCourseId(courseId)
    }
}