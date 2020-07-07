package com.huayei.course.controller

import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.event.Course
import com.huayei.testQuestions.repository.CourseRepository
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/7 10:28
* @Since 1.0
*
*/
@RestController
@RequestMapping("/course")
class CourseController(
    var courseRepository: CourseRepository
) {

    // 新增课程
    @PostMapping("/add")
    fun addNewQuestion(@RequestBody dto: CourseDto): String {
        courseRepository.save(
            Course(null, dto.courseName, dto.coursePicture, dto.courseIntroduce, dto.userId)
        )
        return "Saved"
    }

    //按照id删除课程
    @DeleteMapping("/deleteById/{id}")
    fun delQuestion(@PathVariable id: Int): String {
        courseRepository.findById(id).map {
            courseRepository.deleteById(id)
        }
        return "删除成功！"
    }

    //通过id对课程进行修改
    @PutMapping("/update/{id}")
    fun update(@PathVariable id : Int, @RequestBody dto: CourseDto) : String {
        courseRepository.findById(id).map {
            courseRepository.save(
                Course(id, dto.courseName, dto.coursePicture, dto.courseIntroduce, dto.userId)
            )
        }
        return "修改成功！"
    }

    // 查全部课程信息
    @GetMapping( "/all")
    fun getAllCourse(): Iterable<Course> {
        return courseRepository.findAll(Sort.by("courseId"))
    }


}