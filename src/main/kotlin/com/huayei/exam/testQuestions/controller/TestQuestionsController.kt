package com.huayei.exam.testQuestions.controller

import com.huayei.exam.testPaper.service.TestPaperService
import com.huayei.exam.testQuestions.dto.TestQuestionsDto
import com.huayei.exam.testQuestions.event.TestQuestions
import com.huayei.exam.testQuestions.repository.TestQuestionsRepository
import jxl.read.biff.BiffException
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.web.bind.annotation.*
import java.io.*
import java.net.URLEncoder
import java.util.*
import javax.servlet.http.HttpServletResponse

/**
 * @Description TODO
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
    val test : TestPaperService

) {

    // 下载试题模板
    @GetMapping("/download")
    @Throws(FileNotFoundException::class)
    fun downloadLocal(response: HttpServletResponse) { // 下载本地文件
        val fileName = URLEncoder.encode("试题导入模板.xlsx","UTF-8") // 文件的默认保存名
        val inStream: InputStream = FileInputStream("D:\\newFile\\试题导入模板.xlsx") // 文件的存放路径
        response.reset()
        response.contentType = "bin"
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

    //导入excel
    //修改，传入一个文件路径和courseId课程id
    @GetMapping("/excel")
    @Throws(IOException::class, BiffException::class)
    fun excelUser( @RequestParam courseId : Int): String? {
        val workbook = XSSFWorkbook(FileInputStream(File("C:\\Users\\12508\\Desktop\\试题导入模板.xlsx")))
        val sheet: XSSFSheet = workbook.getSheetAt(0)
        val list: MutableList<TestQuestions> = ArrayList<TestQuestions>()
        for (j in 2 until sheet.getPhysicalNumberOfRows()) {
            val row: Row = sheet.getRow(j)
            if (null != row) {
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
        }
        testQuestionsRepository.saveAll(list)
        return "saved"
    }

    // 新增试题
    @PostMapping("/add")
    fun addNewQuestion(@RequestBody dto: TestQuestionsDto): String {
        testQuestionsRepository.save(TestQuestions(null, dto.questionName, dto.questionType, dto.answer,
            dto.optionA,dto.optionB, dto.optionC, dto.optionD, dto.courseId))
        return "Saved"
    }

    @GetMapping("/test")
    fun test(){
        test.delPaper(6)
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

    //根据课程名查询试题
    @PostMapping("/findByCourseName")
    fun getQuestionByCourseName(@RequestParam courseName : String): TestQuestionsDto {
        return testQuestionsRepository.findQuestionByCourseName(courseName).dto()
    }

    //根据课程id查询试题
    @PostMapping("/findByCourseId/{id}")
    fun getQuestionByCourseId(@PathVariable id : Int): TestQuestionsDto {
        return testQuestionsRepository.findQuestionByCourseId(id).dto()
    }

    //根据课程id和题型查询试题
    @PostMapping("/findByIdAndType/{id}")
    fun getQuestionByIdAndType(@PathVariable id : Int, @RequestParam type : String): Iterable<TestQuestions> {
        return testQuestionsRepository.findByCourseIdAndQuestionType(id, type)
    }



}