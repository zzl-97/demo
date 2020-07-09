package com.huayei.exam.testPaper.event

import javax.persistence.*

@Entity
@Table(name = "TEST_PAPERS_QUESTIONS")
data class TestPaperQuestion(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var paperQuestionId : Int ?= null,

    var paperId : Int ?= null,

    var questionId : Int ?=null
) {
}