package com.huayei.domain.course.controller;

import com.huayei.domain.course.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Administrator
 * @DATE: 2020/7/9
 **/
public class ChapterControllerTest {

    @Autowired
    ChapterRepository chapterRepository;

    public void getChapter(int id) {
        chapterRepository.findById(id).map(chapter -> {
            chapter.setChapterId(123);
            return null;
        }).orElse(null);
    }
}
