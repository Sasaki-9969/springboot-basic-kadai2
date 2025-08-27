package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;



@Service
public class ToDoService {
		
	//フィールドの宣言
	private final ToDoRepository toDoRepository;
	//コンストラクタインジェクション
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}
	
	//ToDoリストの一括取得メソッド
	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

}
