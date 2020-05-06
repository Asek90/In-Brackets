package org.ewarsztat.approach.common.repository;

import org.ewarsztat.approach.common.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question,Long>{
}
