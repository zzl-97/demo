package com.huayei.controller.course

import com.huayei.base.BaseResp
import com.huayei.domain.course.repository.CourseRepository
import com.huayei.domain.course.service.ChapterService
import com.huayei.domain.course.service.CourseService
import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.event.Course
import org.springframework.transaction.annotation.Transactional

import org.springframework.web.bind.annotation.*


/**
 *@Description 课程Controller
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
    fun addCourse(@RequestBody course: CourseDto): BaseResp {
        //查询改课程名是否存在
        //val oldCourse: Course? = course.courseName?.let { courseService.selectCourseName(it) }

        if (courseRepository.existsByCourseName(course.courseName!!)) {
            return BaseResp(status = 1, message = "该课程已经存在")
        }
        courseService.courseRepository.save(course.entity())
        return BaseResp(message = "添加新课程成功", data = course)
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
    fun updateCourse(@PathVariable courseId: Int, @RequestBody course: CourseDto): BaseResp {
        return courseRepository.findById(courseId).map {
            courseRepository.save(course.entity())
            BaseResp(status = 1, message = "修改成功")
        }.orElse(BaseResp(status = 2, message = "课程不存在！！修改失败"))
    }

    /**
     * 删除课程
     * @param courseId 课程编号
     */
    @DeleteMapping("/{courseId}")
    @Transactional(readOnly = true)
    fun deleteCourse(@PathVariable courseId: Int): BaseResp {
        //先查询 后删除
        return courseRepository.findById(courseId).map {
            // 课程存在（不为空）时执行下列方法
            courseRepository.deleteById(courseId);
            //查询课程地下是否有章节
            chapterService.getChaptersOf(courseId).map {
                chapterService.chapterRepository.delete(it)
            }
            BaseResp(status = 0,message = "删除成功")
        }.orElse(
            // 当课程为空时执行下列方法
            BaseResp(status = 1,message = "删除课程失败")
        )

    }
}