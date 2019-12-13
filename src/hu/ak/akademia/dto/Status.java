package hu.ak.akademia.dto;

public enum Status {

	ACTIVE("A", "aktív"), DELETED("D", "törölt");

	private String code;
	private String text;

	private Status(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static Status getByCode(String code) {
    	for (Status status:values()) {
			if(status.getCode().equals(code)) return status;
		}
    	throw new IllegalArgumentException("Illegal status code! ["+code+"]");
    }

}
