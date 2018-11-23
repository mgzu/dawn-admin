package com.github.mgzu.dawn.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mgzu.dawn.common.utils.CodeGeneratorUtil;

/**
 * <p>
 * 代码生成
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-20
 */
public class CodeGenerator {

	private static Logger log = LoggerFactory.getLogger(CodeGenerator.class);
	
    public static void main(String[] args) throws Exception {
    	CodeGeneratorUtil util = new CodeGeneratorUtil();
        util.generator();
    }
}
