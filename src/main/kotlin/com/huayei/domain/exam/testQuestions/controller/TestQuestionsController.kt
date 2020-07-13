package com.huayei.domain.exam.testQuestions.controller

import com.huayei.base.BaseResp
import com.huayei.exam.testQuestions.dto.TestQuestionsDto
import com.huayei.exam.testQuestions.event.TestQuestions
import com.huayei.exam.testQuestions.repository.TestQuestionsRepository
import com.huayei.domain.systemManagement.service.TestQuestionsService
import jxl.read.biff.BiffException
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.web.bind.annotation.*
import java.io.*
import java.net.URLEncoder
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Description 试卷管理功能
 * @Author liuh@huayei.com
 * @Date 2020/7/7 8:56
 * @Since 1.0
 *
 */
@RestController
@CrossOrigin // 跨域请求
@RequestMapping("/testQuestion")
class TestQuestionsController(
    val testQuestionsRepository: TestQuestionsRepository,
    val questionsService: TestQuestionsService
) {
    /**
     * 下载试题模板
     */
    @GetMapping("/download")
    @Throws(FileNotFoundException::class)
    fun downloadLocal(response: HttpServletResponse) { // 下载本地文件
        val fileName = URLEncoder.encode("试题导入模板.xlsx","UTF-8") // 文件的默认保存名
        val inStream: InputStream = FileInputStream("D:\\newFile\\试题导入模板.xlsx") // 文件模板的存放路径
        response.reset()
        response.contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        response.addHeader("Content-Disposition", "attachment; filename=\"$fileName\"")
        val b = ByteArray(100)
        var len: Int
        try {
            while (inStream.read(b).also { len = it } > 0) response.outputStream.write(b, 0, len)
            inStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 导入excel
     * @param courseId 课程id
     * @return 返回保存是否成功
     */
    @GetMapping("/excel")
    @Throws(IOException::class, BiffException::class)
    fun excelUser( @RequestParam courseId: Int): String? {
        val workbook = XSSFWorkbook(FileInputStream(File("C:\\Users\\12508\\Desktop\\试题导入模板.xlsx")))
        val sheet: XSSFSheet = workbook.getSheetAt(0)
        val list: MutableList<TestQuestions> = ArrayList<TestQuestions>()
        for (j in 2 until sheet.physicalNumberOfRows) {
            val row: Row = sheet.getRow(j)
            val testQuestions = TestQuestions()
            testQuestions.questionId = null
            testQuestions.questionName = row.getCell(0).toString()
            testQuestions.questionType = row.getCell(1).toString()
            testQuestions.answer = row.getCell(3).toString()
            if(row.getCell(7)!=null) {
                testQuestions.optionA = row.getCell(7).toString()
            }else {
                testQuestions.optionA = null
            }
            if(row.getCell(8)!=null) {
                testQuestions.optionB = row.getCell(8).toString()
            }else {
                testQuestions.optionB = null
            }
            if(row.getCell(9)!=null) {
                testQuestions.optionC = row.getCell(9).toString()
            }else {
                testQuestions.optionC = null
            }
            if(row.getCell(10)!=null) {
                testQuestions.optionD = row.getCell(10).toString()
            }else {
                testQuestions.optionD = null
            }
            testQuestions.courseId = courseId
            list.add(testQuestions)
        }
        testQuestionsRepository.saveAll(list)
        return "saved"
    }

    /**
     * 查询试题名是否存在
     */
    @PostMapping("/findName")
    fun findQuestionName(@RequestParam questionName: String): BaseResp {
        //查询该试题名是否存在
        val result = questionName.let { testQuestionsRepository.existsByQuestionName(it) }
        return if(result){
            BaseResp(message = "该试题存在。")
        }else {
            BaseResp(message = "该试题不存在。")
        }
    }

    /**
     * 新增试题
     * @param dto 试卷信息
     * @return 返回信息
     */
    @PostMapping("/add")
    fun addQuestion(@RequestBody dto: TestQuestionsDto): BaseResp {
        //查询有没有该试题名存在
        val result = dto.questionName?.let { testQuestionsRepository.existsByQuestionName(it) }
        return if(result!!){
            BaseResp(message = "该试题存在。")
        }else {
            //没有就添加到数据库
            testQuestionsRepository.save(TestQuestions(null, dto.questionName, dto.questionType,
                dto.answer, dto.optionA, dto.optionB, dto.optionC, dto.optionD, dto.courseId))
            BaseResp(message = "保存成功。")
        }
    }

    /**
     * 删除一道试题
     * @param id 试卷id
     * @return 删除成功
     */
    @DeleteMapping("/deleteById/{id}")
    fun delQuestion(@PathVariable id: Long): BaseResp {
        //查询该试卷id是否存在
        testQuestionsRepository.findById(id).map {
            //存在才删除
            testQuestionsRepository.deleteById(id)
        }
        return BaseResp(message = "删除成功。")
    }

    /**
     * 根据试题id获取一道试题的全部信息
     * @param id 试题id
     * @return 返回试题信息
     */
    @PostMapping("/findOneQuestion/{id}")
    fun getQuestionOf(@PathVariable id: Long): BaseResp {
        return BaseResp(data = questionsService.getQuestion(id))
    }

    /**
     * 修改一道试题
     * @param id 试题id
     * @param question 试卷信息
     * @return 返回“修改成功”信息和修改后试题的信息
     */
    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody question: TestQuestionsDto,
        request: HttpServletRequest
    ): BaseResp {
        questionsService.getQuestion(id).map { existingQuestion ->
            existingQuestion.questionName = question.questionName
            existingQuestion.questionType = question.questionType
            existingQuestion.answer = question.answer
            existingQuestion.optionA = question.optionA
            existingQuestion.optionB = question.optionB
            existingQuestion.optionC = question.optionC
            existingQuestion.optionD = question.optionD
            testQuestionsRepository.save(existingQuestion)
        }
        return BaseResp(message = "修改成功。",data = questionsService.getQuestion(id))
    }

    /**
     * 根据课程id查询试题
     * @param id 课程id
     * @return 返回一个试卷信息
     */
    @PostMapping("/findByCourseId/{id}")
    fun getQuestionByCourseId(@PathVariable id: Int): BaseResp {
        return BaseResp(data = testQuestionsRepository.findQuestionByCourseId(id).dto())
        }

    /**
     * 根据课程id和题型查询试题
     * @param id 课程id
     * @param type 题型
     * @return 试题集合
     */
    @PostMapping("/findByIdAndType/{id}")
    fun getQuestionsOf(@PathVariable id: Int, @RequestParam type: String): BaseResp {
        return BaseResp(data = questionsService.getQuestionsOf(id, type))
    }
}