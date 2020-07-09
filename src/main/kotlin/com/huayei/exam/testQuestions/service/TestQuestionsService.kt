package com.huayei.systemManagement.service

import com.huayei.exam.testQuestions.repository.TestQuestionsRepository
import org.springframework.stereotype.Service
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
    //删除试题
    fun delQuestion(courseId : Int) = testQuestionsRepository.findByCourseId(courseId).map {
        testQuestionsRepository.deleteByCourseId(courseId)
    }
}