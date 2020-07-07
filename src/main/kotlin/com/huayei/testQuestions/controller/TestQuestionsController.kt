package com.huayei.testQuestions.controller

import com.huayei.testQuestions.dto.TestQuestionsDto
import com.huayei.testQuestions.event.TestQuestions
import com.huayei.testQuestions.repository.TestQuestionsRepository
import jxl.read.biff.BiffException
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
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
@RequestMapping("/testQuestion")
class TestQuestionsController(

    val testQuestionsRepository: TestQuestionsRepository

) {
    @GetMapping("/hello")
    fun getHelloworld(@RequestParam("uploadFile")  file : MultipartFile): String {
       return file.getOriginalFilename()
       // return "hello world"
    }


    // 下载试题模板
    @GetMapping("/download")
    @Throws(FileNotFoundException::class)
    fun downloadLocal(response: HttpServletResponse) { // 下载本地文件
        val fileName = URLEncoder.encode("试题导入模板.xlsx","UTF-8") // 文件的默认保存名
        // 读到流中
        val inStream: InputStream = FileInputStream("D:\\newFile\\试题导入模板.xlsx") // 文件的存放路径
        // 设置输出的格式
        response.reset()
        response.contentType = "bin"
        response.addHeader("Content-Disposition", "attachment; filename=\"$fileName\"")
        // 循环取出流中的数据
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
    @GetMapping("/excel")
    @ResponseBody
    @Throws(IOException::class, BiffException::class)
    fun excelUser(file: MultipartFile?): String? {
        val excel = ExcelController("C:\\Users\\12508\\Desktop\\用户表.xls")
        excel.readExcel()
        val list: List<*> = excel.outData()
        val qiestionList: MutableList<TestQuestions> = ArrayList<TestQuestions>()
        val n = TestQuestions()
//        for (i in list.indices) {
//            val str = list[i] as Array<String>
//            n.setName(str[1])
//            n.setPassword(str[2])
//            n.setRoleId(str[3].toInt())
//            userList.add(n)
//        }
        testQuestionsRepository.saveAll(qiestionList)
        return "saved"
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