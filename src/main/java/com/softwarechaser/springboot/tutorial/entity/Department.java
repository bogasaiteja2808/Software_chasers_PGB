package com.softwarechaser.springboot.tutorial.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long QId;
	@NotBlank(message="please enter question")
	private String question;
	private String category;
    private String difficulty;
    private String correct_answer;
    @ElementCollection
    private List<String>incorrect_answers;
	public Long getQId() {
		return QId;
	}
	public void setQId(Long qId) {
		QId = qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	public List<String> getIncorrect_answers() {
		return incorrect_answers;
	}
	public void setIncorrect_answers(List<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}
	public Department(Long qId, String question, String category, String difficulty, String correct_answer,
			List<String> incorrect_answers) {
		super();
		QId = qId;
		this.question = question;
		this.category = category;
		this.difficulty = difficulty;
		this.correct_answer = correct_answer;
		this.incorrect_answers = incorrect_answers;
	}
	
	public Department() {

	}
	@Override
	public String toString() {
		return "Department [QId=" + QId + ", question=" + question + ", category=" + category + ", difficulty="
				+ difficulty + ", correct_answer=" + correct_answer + ", incorrect_answers=" + incorrect_answers + "]";
	}


}
