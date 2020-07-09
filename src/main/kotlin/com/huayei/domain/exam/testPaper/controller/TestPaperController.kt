package com.huayei.exam.testPaper.controller

import com.huayei.exam.testPaper.event.TestPaperQuestion
import com.huayei.exam.testPaper.repository.TestPaperQuestionRepository
import com.huayei.exam.testQuestions.dto.TestPaperDto
import com.huayei.exam.testQuestions.event.TestPaper
import com.huayei.exam.testQuestions.repository.TestPaperRepository
import org.springframework.web.bind.annotation.*

/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/9 9:30
* @Since 1.0
*
*/

@RestController
@CrossOrigin // 跨域请求
@RequestMapping("/testPaper")
class TestPaperController (
    val testPaperRepository: TestPaperRepository,
    val testPaperQuestionRepository: TestPaperQuestionRepository
){

    //试卷的删除
    @DeleteMapping("/del/{id}")
    fun delPaper(@PathVariable id: Int): String {
        testPaperRepository.findById(id).map {
            testPaperRepository.deleteById(id)
        }
        testPaperQuestionRepository.findById(id).map {
            testPaperQuestionRepository.deleteById(id)
        }
        return "删除成功！"
    }

    //选择课程，显示试题，选择试题，填写试卷名，发布考试
    @PostMapping("/add")
    fun add(@RequestParam paperName : String, @RequestParam courseId : Int, @RequestParam questionIdList: ArrayList<Int>){
        testPaperRepository.save(TestPaper(null,paperName,courseId)).let {
            val list = ArrayList<TestPaperQuestion>()
            val t = TestPaperQuestion()
            for (i in 0 until questionIdList.size){
                t.paperId = it.paperId
                t.questionId = questionIdList.get(i)
                list.add(t)
            }
            testPaperQuestionRepository.saveAll(list)
        }
    }
}