package io.github.daschner.Xye.functions.math;

public enum DataType {
	
	VOLUME  (0),
    OPEN(1),
    CLOSE(2),
    HIGH(3),
    LOW(4),
    ADJCLOSE(5);


    private final int dataType;

    DataType(int dataCode) {
        this.dataType = dataCode;
    }
    
    public int getDataCode() {
        return this.dataType;
    }
    
	
}
