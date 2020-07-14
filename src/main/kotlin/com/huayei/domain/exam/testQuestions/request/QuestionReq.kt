/*
 * Copyright (c) 2020 福建华业信息技术有限公司.
 */

package com.huayei.domain.exam.testQuestions.request

import com.huayei.base.PageReq

/**
 * @Description 试题动态查询实体类
 * @Author  liuh
 * @Email liuh@huayei.com
 * @Date 2020/7/14 14:11
 * @Since 1.0
 **/
data class QuestionReq (
    var courseId: Int? = null,
    var questionType: String? = null
) : PageReq()