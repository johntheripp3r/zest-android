package com.example.roboguice_demo.pojo;

import com.google.inject.Inject;


public class Computer2 {
	
	@Inject
	private Computer2Dependency computer2Dependency;
	
	public int compute() {
		return computer2Dependency.compute();
	}
}
