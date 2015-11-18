package jp.co.fitec.traning.project.typing.dao;

import java.util.Set;

import jp.co.fitec.traning.project.typing.entity.Question;
import jp.co.fitec.traning.project.typing.gamedata.Level;

public interface QuestionDao {
	
		/**
		 * Retrieve set of question according to level
		 * @param level level of question
		 * @return set of question according to level
		 */
		public Set<Question> getQuestionSet(Level level) throws DAOException;
		
		
}
