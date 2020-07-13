package com.huayei.domain.course.repository

import com.huayei.domain.course.entity.CourseUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface CourseUserRepository : JpaRepository<CourseUser, Int>