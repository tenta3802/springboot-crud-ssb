package com.site.ssb.Repository;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.site.ssb.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
