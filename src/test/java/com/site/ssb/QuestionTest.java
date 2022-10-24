package com.site.ssb;

import com.site.ssb.Repository.QuestionRepository;
import com.site.ssb.entity.Answer;
import com.site.ssb.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class QuestionTest {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void saveTest() {
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
	void findAllTest() {
		List<Question> all = questionRepository.findAll();
		assertEquals(2, all.size()); // 담은 데이터(객체)의 양이 두개인가?

		Question q = all.get(0);
		assertEquals("질문입니다.1", q.getSubject());
	}

	@Test
	void findByIdTest() {
		Optional<Question> oq = questionRepository.findById(2);
		if (oq.isPresent()){
			Question q = oq.get();
			assertEquals("질문 내용입니다.2", q.getContent());
		}
	}

	@Test
	void findBySubject() {
		Question q = questionRepository.findBySubject("질문입니다.1");
		assertEquals(1, q.getId());
	}

	@Test
	void findBySubjectAndContentTest() {
		Question q = questionRepository.findBySubjectAndContent("질문입니다.1", "질문 내용입니다.1");
		assertEquals(1, q.getId());
	}

	@Test
	void findBySubjectLikeTest() {
		List<Question> list = questionRepository.findBySubjectLike("%입니다%");
		Question q = list.get(0);
		assertEquals("질문입니다.1", q.getSubject());
	}

//	@Test
//	void updateTest() {
//		Optional<Question> oq = questionRepository.findById(1);
//		assertTrue(oq.isPresent()); //true 인지 확인.
//		Question q = oq.get();
//		q.setSubject("수정된 제목.1");
//		questionRepository.save(q);
//	}

//	@Test
//	void deleteTest() {
//		assertEquals(2, questionRepository.count()); // 삭제 전 데이터 수 일치하는지 확인
//		Optional<Question> oq = questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		questionRepository.delete(q);
//		assertEquals(1, questionRepository.count());
//	}
}
