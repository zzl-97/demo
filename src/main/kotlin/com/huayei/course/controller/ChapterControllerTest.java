package com.huayei.course.controller;

import com.huayei.course.event.Chapter;
import com.huayei.course.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
