package com.github.mgzu.dawn.common;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mgzu.dawn.common.utils.CodeGeneratorUtil;

/**
 * @author https://github.com/mgzu
 */
public class CodeGenerator {

	private static Logger log = LoggerFactory.getLogger(CodeGenerator.class);
	
    public static void main(String[] args) throws Exception {
    	CodeGeneratorUtil util = new CodeGeneratorUtil();
        util.generator();
    }
}
