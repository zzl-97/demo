package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestPaper
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TestPaperDto (
    @NotNull
    @get: Size(max = 64)
    var paperId: Long? = null,

    @NotBlank
    @get: Size(max = 64)
    var paperName: String? = null,

    @NotBlank
    @get: Size(max = 64)
    var courseId: Int? = null,

    @NotNull
    var paperState: Int? =0
) {
    fun entity(): TestPaper {
        return TestPaper(paperId = paperId,
            paperName = paperName,
            courseId = courseId,
            paperState = paperState)
    }
}