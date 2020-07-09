package com.huayei.course.controller

import com.huayei.course.repository.CourseRepository
import com.huayei.course.service.ChapterService
import com.huayei.course.service.CourseService
import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.event.Course

import org.springframework.web.bind.annotation.*


/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 9:15
 *@Since 1.0
 **/

@RestController
@CrossOrigin // 跨域
@RequestMapping("/courses")
class CourseController(
    val courseService: CourseService,
    val chapterService: ChapterService,
    val courseRepository: CourseRepository
) {

    /**
     * 获取课程列表
     */
    @PostMapping("")
    fun getCourses() {

    }

    /**
     * 添加课程
     * @param course 课程信息
     */
    @PostMapping("/new")
    fun addCourse(@RequestBody course: CourseDto): CourseDto {
        //查询改课程名是否存在
        val oldCourse: Course? = course.courseName?.let { courseService.selectCourseName(it) }

        if (oldCourse != null) {
            return CourseDto(message = "该课程已经存在")
        } else {
            //保存课程
            courseService.courseRepository.save(course.entity());
        }

        return CourseDto(message = "添加新课程成功")
    }

    /**
     * 获取指定ID的课程信息
     * @param courseId 课程编号
     */
    @GetMapping("/{courseId}")
    fun getCourse(@PathVariable courseId: Long) {

    }

    /**
     * 修改课程信息
     * @param courseId 课程编号
     */
    @PutMapping("/{courseId}")
    fun updateCourse(@PathVariable courseId: Int, @RequestBody course: CourseDto): CourseDto {
        courseRepository.findById(courseId).map {
            courseRepository.save(course.entity());
        }
        return CourseDto(message = "修改成功")
    }

    /**
     * 删除课程
     * @param courseId 课程编号
     */
    @DeleteMapping("/{courseId}")
    fun deleteCourse(@PathVariable courseId: Int): CourseDto {
        //先查询 后删除
        courseRepository.findById(courseId).map {
            courseRepository.deleteById(courseId);
            //查询课程地下是否有章节
            chapterService.getChaptersOf(courseId).map {
                chapterService.chapterRepository.delete(it)
            }
        }
        return CourseDto(message = "删除成功")
    }
}