package com.huayei.testQuestions.controller

import com.huayei.testQuestions.dto.TestQuestionsDto
import com.huayei.testQuestions.event.Course
import com.huayei.testQuestions.event.TestQuestions
import com.huayei.testQuestions.repository.TestQuestionsRepository
import org.springframework.web.bind.annotation.*
import java.io.*
import java.net.URLEncoder
import javax.servlet.http.HttpServletResponse

/**
 * @Description TODO
 * @Author liuh@huayei.com
 * @Date 2020/7/7 8:56
 * @Since 1.0
 *
 */
@RestController
@RequestMapping("/testQuestion")
class TestQuestionsController(

    val testQuestionsRepository: TestQuestionsRepository

) {
    @GetMapping("/hello")
    fun getHelloworld(): String {
        return "hello world"
    }

    @GetMapping("/download")
    @Throws(IOException::class)
    fun downLoad(response: HttpServletResponse) {
        //获取输入流
        val bis = BufferedInputStream(FileInputStream(File("D:\\newFile\\url.txt")))
        //转码，免得文件名中文乱码
        val filename = URLEncoder.encode("试题导入模板", "UTF-8")
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=$filename")
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.contentType = "application/octet-stream"
        val out = BufferedOutputStream(response.outputStream)
        var len = bis.read()
        while ((len) != -1) {
            out.write(len)
            out.flush()
        }
        out.close()
    }

    // 新增试题
    @PostMapping("/add")
    fun addNewQuestion(@RequestBody dto: TestQuestionsDto): String {
        testQuestionsRepository.save(TestQuestions(null, dto.questionName, dto.questionType, dto.answer,
            dto.optionA,dto.optionB, dto.optionC, dto.optionD, dto.courseId))
        return "Saved"
    }

    //按照id删除试题
    @DeleteMapping("/deleteById/{id}")
    fun delQuestion(@PathVariable id: Int): String {
        testQuestionsRepository.findById(id).map {
            testQuestionsRepository.deleteById(id)
        }
        return "删除成功！"
    }

    //通过id对试题进行修改
    @PutMapping("/update/{id}")
    fun update(@PathVariable id : Int , @RequestBody dto: TestQuestionsDto) : String {
        testQuestionsRepository.findById(id).map {
            testQuestionsRepository.save(TestQuestions(id, dto.questionName, dto.questionType, dto.answer, dto.optionA,
                dto.optionB, dto.optionC, dto.optionD, dto.courseId))
        }
        return "修改成功！"
    }

    //根据课程id查询试题
    //查询账号密码
    @PostMapping("/findById/{id}")
    fun getQuestionById(@PathVariable id : Int, @RequestBody courseName : String): Iterable<TestQuestionsDto> {
        return testQuestionsRepository.findQuestionByCourseName(courseName)
    }



}