package factorySQL;

import Models.Professor;

public interface ProfessorDAO {

	public void addProfessor(Professor prof);
	public Professor getProfessorById(int prof_id);
}
