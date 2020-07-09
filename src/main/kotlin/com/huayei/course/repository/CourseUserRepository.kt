package com.huayei.course.repository

import com.huayei.course.event.CourseUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface CourseUserRepository : JpaRepository<CourseUser, Int>