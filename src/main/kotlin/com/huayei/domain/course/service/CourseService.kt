package com.huayei.domain.course.service

import com.huayei.domain.course.repository.CourseRepository
import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.event.Course
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

/**
 *@Description 课程的服务层
 *Author zzl@huayei.com
 *Date 2020/7/8 9:15
 *@Since 1.0
 **/
@Service
class CourseService(
    val courseRepository: CourseRepository
) {

    fun getCourseName(courseName: String) = courseRepository.findByCourseName(courseName);

    fun getCourse() = courseRepository.findAllBy();
//  courseRepository.findAll()
    /**
     * 课程的查询
     */
    fun getCourseAll( courseDto: CourseDto): List<Course> {
        val course = courseDto.entity();
        val spec: Specification<Course?> =
            Specification<Course?> { root: Root<Course?>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder ->
                val courseName = root.get<Course>("courseName")
                val courseIntroduce = root.get<Course>("courseIntroduce")
                var p1: Predicate? = null
                if (course.courseName !== "") {
                    val p2 = criteriaBuilder.equal(courseName, course.courseName)
                    p1 = if (p1 != null) {
                        criteriaBuilder.and(p1, p2)
                    } else {
                        p2
                    }
                }
                if (course.courseIntroduce != "") {
                    val p2 = criteriaBuilder.equal(courseIntroduce, course.courseIntroduce)
                    p1 = if (p1 != null) {
                        criteriaBuilder.and(p1, p2)
                    } else {
                        p2
                    }
                }
                p1!!
            }
        return courseRepository.findAll(spec);
    }

}