package jp.co.fitec.traning.project.typing.dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import jp.co.fitec.training.project.typing.util.GameUtils;
import jp.co.fitec.traning.project.typing.dao.QuestionDao;
import jp.co.fitec.traning.project.typing.entity.Question;
import jp.co.fitec.traning.project.typing.entity.hibernate.HibernateQuestion;
import jp.co.fitec.traning.project.typing.gamedata.Level;

public class HibernateQuestionDao implements QuestionDao {

	@Override
	public Set<Question> getQuestionSet(Level level) {
		// TODO connect to db and get real question
		Set<Question> questionSet = new HashSet<>();
//		questionSet.add(new Question("java",Level.EASY));
//		questionSet.add(new Question("macha",Level.EASY));
//		questionSet.add(new Question("yogurt",Level.EASY));
//		questionSet.add(new Question("apple",Level.EASY));
//		questionSet.add(new Question("banana",Level.EASY));
//		return questionSet;
		
		
		Session session = HibernateUtils.getSession();
		List<HibernateQuestion> questionList = session.createCriteria(HibernateQuestion.class)
			.add( Restrictions.eq("level", String.valueOf(GameUtils.levelToInt(level))) )
			.list();
		closeSession(session);
		System.out.println("get question : "  +questionList.size());
		for (HibernateQuestion hibernateQuestion : questionList) {
			int levelInt = Integer.parseInt(hibernateQuestion.getLevel());
			Question q = new Question(hibernateQuestion.getQuestion(), GameUtils.IntToLevel(levelInt) );
			questionSet.add(q);
		}
		
		return questionSet;
	}
	private void closeSession(Session session) {
		if(session != null && session.isConnected()) {
			session.close();
		}
	}
}
