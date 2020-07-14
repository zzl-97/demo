package com.huayei.controller.course;

import com.huayei.domain.course.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Administrator
 * @DATE: 2020/7/9
 **/
public class ChapterControllerTest {

    @Autowired
    ChapterRepository chapterRepository;

    public void getChapter(int id) {
        chapterRepository.findById(id).map(chapter -> {
            chapter.setChapterId(123L);
            return null;
        }).orElse(null);

        try(InputStream inputStream = new FileInputStream("");) {

        } catch (IOException e) {

        }
    }
}
