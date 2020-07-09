package com.huayei.domain.course.request

import com.huayei.base.PageReq

data class ChapterReq(

    var name: String? = null, // 章节名称

    var courseId: Long? = null, // 课程编号

    var courseName: String? = null // 课程名称
) : PageReq()
