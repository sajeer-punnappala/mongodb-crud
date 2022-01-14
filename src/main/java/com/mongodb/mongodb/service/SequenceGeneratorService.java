package com.mongodb.mongodb.service;

public interface SequenceGeneratorService {
	
	long generateSequence(String seqName);
}
