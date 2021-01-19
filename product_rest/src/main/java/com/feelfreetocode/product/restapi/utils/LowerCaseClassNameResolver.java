package com.feelfreetocode.product.restapi.utils;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class LowerCaseClassNameResolver  extends TypeIdResolverBase{

	@Override
	public String idFromValue(Object value) {
		// TODO Auto-generated method stub
		System.out.println("LowerCaseClassNameResolver.idFromValue()----" + value);
		return value.getClass().getSimpleName().toLowerCase();
	}

	@Override
	public String idFromValueAndType(Object value, Class<?> suggestedType) {
		// TODO Auto-generated method stub
		return idFromValue(value);
	}

	@Override
	public Id getMechanism() {
		System.out.println("LowerCaseClassNameResolver.getMechanism()");
		return Id.CUSTOM;
	}



}
