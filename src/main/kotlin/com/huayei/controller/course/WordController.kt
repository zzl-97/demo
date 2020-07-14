package com.huayei.controller.course

import com.huayei.base.BaseResp
import com.huayei.domain.course.dto.WordDto
import com.huayei.domain.course.entity.Word
import com.huayei.domain.course.repository.WordRepository
import com.huayei.domain.course.service.WordService
import org.springframework.web.bind.annotation.*

/**
 *@Description 作业的controller
 *Author zzl@huayei.com
 *Date 2020/7/9 8:57
 *@Since 1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/word")
class WordController(val wordRepository: WordRepository, val wordService: WordService) {
    /**
     * 作业得添加操作
     */
    @PostMapping("/add")
    fun addWord(@RequestBody wordDto: WordDto): BaseResp {
        wordRepository.save(wordDto.entity());
        return BaseResp(message = "添加作业成功")
    }

    /**
     * 删除作业
     * @param wordId 作业Id
     */
    @DeleteMapping("/{wordId}")
    fun deleteWord(@PathVariable wordId: Long): BaseResp {
        return wordRepository.findById(wordId).map {
            wordRepository.deleteById(wordId)
            BaseResp(message = "作业删除成功")
        }.orElse(BaseResp(status = 1, message = "作业删除成功"))
    }

    /**
     * 修改作业
     * @param wordId 作业Id
     */
    @PutMapping("/{wordId}")
    fun updateWord(@PathVariable wordId: Long, @RequestBody wordDto: WordDto): BaseResp {
        return wordRepository.findById(wordId).map {
            it.wordContent = wordDto.wordContent
            it.wordName = wordDto.wordName
            it.wordUrl = wordDto.wordUrl
            wordRepository.save(it)
            BaseResp(message = "修改作业成功")
        }.orElse(BaseResp(message = "修改作业成功"))
    }

    /**
     * 查询作业 按章节 按时间
     */
    @PostMapping("wordAll")
    fun getWord(@RequestBody wordDto: WordDto): BaseResp {

        return BaseResp(data = wordService.getWordAll(wordDto))
    }
}