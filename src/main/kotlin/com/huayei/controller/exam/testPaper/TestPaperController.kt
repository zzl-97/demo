package com.huayei.exam.testPaper.controller

import com.huayei.base.BaseResp
import com.huayei.exam.testPaper.event.TestPaperQuestion
import com.huayei.exam.testPaper.repository.TestPaperQuestionRepository
import com.huayei.exam.testQuestions.dto.TestPaperDto
import com.huayei.exam.testQuestions.event.TestPaper
import com.huayei.exam.testQuestions.repository.TestPaperRepository
import org.springframework.transaction.annotation.Transactional
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

    /**
     * 试卷的删除
     * @param id 试卷ID
     * @return “删除成功！”
     */
    @Transactional(readOnly = true)
    @DeleteMapping("/del/{id}")
    fun delPaper(@PathVariable id: Long): BaseResp {
        return testPaperRepository.findById(id).map {
            testPaperRepository.deleteById(id)
            testPaperQuestionRepository.findById(id).map {
                testPaperQuestionRepository.deleteById(id)
            }
            BaseResp(data = "删除成功！")
        }.orElse(BaseResp(data = "删除失败！"))
    }

    /**
     * 填写试卷名，添加试题，发布考试
     * @param testPaperDto 试题dto(填写试题名和课程id)
     * @return
     */
    @Transactional(readOnly = true)
    @PostMapping("/add")
    fun add(@RequestBody testPaperDto : TestPaperDto , @RequestParam questionIdList: ArrayList<Long>){
        testPaperRepository.save(TestPaper(null,testPaperDto.paperName,testPaperDto.courseId)).let {
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