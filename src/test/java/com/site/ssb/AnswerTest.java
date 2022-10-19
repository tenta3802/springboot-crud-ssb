package com.site.ssb;

import com.site.ssb.Repository.AnswerRepository;
import com.site.ssb.Repository.QuestionRepository;
import com.site.ssb.entity.Answer;
import com.site.ssb.entity.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class AnswerTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Test
    void questionSaveTest() {
        Question q1 = new Question();
        q1.setSubject("질문입니다.1");
        q1.setContent("질문 내용입니다.1");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("질문입니다.2");
        q2.setContent("질문 내용입니다.2");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);
    }

    @Test
    void answerSaveTest() {
        Optional<Question> oq = questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer answer = new Answer();
        answer.setContent("2번 질문 답변입니다.");
        answer.setQuestion(q); // 어떤 질문의 답변인지 알기 위해 Question 객체 필요
        answer.setCreateDate(LocalDateTime.now());
        answerRepository.save(answer);
    }

    @Test
    void findIdTest() {
        Optional<Answer> oa = answerRepository.findById(1);
        assertTrue(oa.isPresent()); //답변 아이디 존재 여부 확인
        Answer answer = oa.get();
        assertEquals(2, answer.getQuestion().getId()); //답변을 한 질문의 아이디와 일치하는지 확인
    }

    @Test
    @DisplayName("질문에서 답변찾기 테스트")
    @Transactional //db 세션이 끊기는 것을 방지
    void findAnswerTest() {
        Optional<Question> oq = questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question question = oq.get();

        List<Answer> answerList = question.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("2번 질문 답변입니다.", answerList.get(0).getContent());
    }
}
