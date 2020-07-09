package com.huayei.course.controller

import com.huayei.course.dto.WordDto
import com.huayei.course.event.Word
import com.huayei.course.repository.WordRepository
import org.springframework.web.bind.annotation.*
import sun.plugin2.message.Message

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/9 8:57
 *@Since 1.0
 **/

@RestController
@CrossOrigin
@RequestMapping("/word")
class WordController(
    val wordRepository: WordRepository
) {
    /**
     * 作业得添加操作
     */
    @PostMapping("/add")
    fun addWord(@RequestBody wordDto: WordDto): WordDto {
        wordRepository.save(wordDto.entity());
        return WordDto(message = "添加作业成功")
    }

    /**
     * 删除作业
     * @param wordId 作业Id
     */
    @DeleteMapping("/{wordId}")
    fun deleteWord(@PathVariable wordId :Long): WordDto{
        wordRepository.findById(wordId).map {
            wordRepository.deleteById(wordId)
        }
        return WordDto(message = "作业删除成功")
    }

    /**
     * 修改作业
     * @param wordId 作业Id
     */
    @PutMapping("/{wordId}")
    fun updateWord(@PathVariable wordId: Long,@RequestBody wordDto: WordDto):WordDto{
        wordRepository.findById(wordId).map {
            it.wordContent = wordDto.wordContent
            it.wordName = wordDto.wordName
            it.wordUrl = wordDto.wordUrl
            wordRepository.save(it)
        }
        return WordDto(message = "修改作业成功")
    }

    /**
     * 查询作业 按章节 按时间
     */
    fun selectWord(@RequestBody wordDto: WordDto): List<Word>?{

        return null
    }
}