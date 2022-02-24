package com.ty.foodjoint.exception;

public class IDNotFoundEcxepiton extends RuntimeException {

	String mesg = "User not found";

	public IDNotFoundEcxepiton(String mesg) {
		super();
		this.mesg = mesg;
	}

	public IDNotFoundEcxepiton() {
		super();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return mesg;
	}

}
